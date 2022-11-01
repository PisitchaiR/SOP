package com.example.demo.query;

import com.example.demo.core.ProductEnity;
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
        ProductEnity productEnity = new ProductEnity();
        BeanUtils.copyProperties(event, productEnity);
        productRepository.save(productEnity);
    }
}
