package com.example.demo.core.data;

import com.example.demo.core.ProductEnity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<ProductEnity, String>  {
    ProductEnity findByProductId(String productId);
    ProductEnity findByProductIdOrTitle(String productId, String title);

}
