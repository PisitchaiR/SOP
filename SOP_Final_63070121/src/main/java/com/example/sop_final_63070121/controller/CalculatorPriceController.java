package com.example.sop_final_63070121.controller;

import com.example.sop_final_63070121.repository.CalculatorPriceService;
import com.example.sop_final_63070121.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorPriceController {
    @Autowired
    private CalculatorPriceService service;

    @RequestMapping(value = "/getPrice/{cost}/{profit}", method = RequestMethod.GET)
    public double serviceGetProducts(@PathVariable double cost, @PathVariable double profit){
        return service.getPrice(cost, profit);
    }
}
