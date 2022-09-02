package com.example.week4;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    Change change = new Change();
    int temp = 0;


    @RequestMapping(value = "/getChange/{money}", method = RequestMethod.GET)
    public Change myAdd(@PathVariable("money") int money) {
        while(money/1000 != 0){
            change.setB1000(change.getB1000()+1);
            money = money-1000;
        }
        while(money/500 != 0){
            change.setB500(change.getB500()+1);
            money = money-500;
        }
        while(money/100 != 0){
            change.setB100(change.getB100()+1);
            money = money-100;
        }
        while(money/20 != 0){
            change.setB20(change.getB20()+1);
            money = money-20;
        }
        while(money/10 != 0){
            change.setB10(change.getB10()+1);
            money = money-10;
        }
        while(money/5 != 0){
            change.setB5(change.getB5()+1);
            money = money-5;
        }
        while(money/1 != 0){
            change.setB1(change.getB1()+1);
            money = money-1;
        }

        return change;
    }
}
