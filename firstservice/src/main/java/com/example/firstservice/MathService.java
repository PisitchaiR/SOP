package com.example.firstservice;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
public class MathService {
    @RequestMapping(value = "/add/{num1}/{num2}", method = RequestMethod.GET)
    public double add(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
        return num1+num2;
    }
    @RequestMapping(value = "/minus/{num1}/{num2}", method = RequestMethod.GET)
    public double minus(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
        return num1-num2;
    }
    @RequestMapping(value = "/multiply", method = RequestMethod.GET)
    public String multiply(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return (num1*num2)+"";
    }
    @RequestMapping(value = "/devide", method = RequestMethod.GET)
    public String devide(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return (num1 / num2)+"";
    }
}

