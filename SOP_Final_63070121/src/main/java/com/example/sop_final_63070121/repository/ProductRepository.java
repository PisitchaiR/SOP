package com.example.sop_final_63070121.repository;

import com.example.sop_final_63070121.pojo.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository extends MongoRepository<Product, String> {
    @Query(value="{productName: '?0'}")
    public Product findByName (String productName);
}
