package com.example.demo.query;

import com.example.core.event.ProductReservedEvent;
import com.example.demo.core.ProductEntity;
import com.example.demo.core.data.ProductRepository;
import com.example.demo.core.event.ProductCreateEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {

    private final ProductRepository productRepository;

    public ProductEventsHandler(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @EventHandler
    public  void on(ProductCreateEvent event){
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);
        productRepository.save(productEntity);
    }

    @EventHandler
    public void on(ProductReservedEvent productReservedEvent) {
        ProductEntity productEntity = productRepository.findByProductId(productReservedEvent.getProductId());
        productEntity.setQuantity(productEntity.getQuantity() - productReservedEvent.getQuantity());
        productRepository.save(productEntity);
    }
}
