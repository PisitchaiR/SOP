package com.example.sop_final_63070121.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorPriceService {
    private final ProductRepository repository;

    public CalculatorPriceService(ProductRepository repository) {
        this.repository = repository;
    }

    public double getPrice(double pCost, double pProfit){
        return (pCost+pProfit);
    }
}
