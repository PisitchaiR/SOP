package com.example.demo.query;

import com.example.demo.core.ProductEntity;
import com.example.demo.core.data.ProductRepository;
import com.example.demo.query.rest.ProductRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductQueryHandler {
    private final ProductRepository productRepository;

    public ProductQueryHandler(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @QueryHandler
    List<ProductRestModel> findProducts(FindProductsQuery query){

        List<ProductRestModel> productRest = new ArrayList<>();
        List<ProductEntity> storedProducts = productRepository.findAll();
        for(ProductEntity productEntity : storedProducts){
            ProductRestModel productRestModel =  new ProductRestModel();
            BeanUtils.copyProperties(productEntity, productRestModel);
            productRest.add(productRestModel);
        }
        return productRest;
    }
}
