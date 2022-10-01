package com.example.sop_final_63070121.controller;

import com.example.sop_final_63070121.repository.ProductService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RabbitListener(queues = "AddProductQueue")
    public
}
