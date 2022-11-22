package com.example.bookstoreservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookStore {

    @RequestMapping("/recommended")
    public String getRecommend() {return "Spring in Action (Manning), Clound Native Java";}
}
