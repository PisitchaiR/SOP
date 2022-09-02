package com.example.week4;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;


@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
public class MathService {
    @RequestMapping(value = "/plus/{n1}/{n2}", method = RequestMethod.GET)
    public double myAdd(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return n1+n2;
    }

    @RequestMapping(value = "/minus/{n1}/{n2}", method = RequestMethod.GET)
    public double myMinus(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return n1-n2;
    }

    @RequestMapping(value = "/multi/{n1}/{n2}", method = RequestMethod.GET)
    public String myMulti(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return (n1*n2)+"";
    }

    @RequestMapping(value = "/divide/{n1}/{n2}", method = RequestMethod.GET)
    public String myDevide(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return (n1 / n2)+"";
    }

    @RequestMapping(value = "/mod/{n1}/{n2}", method = RequestMethod.GET)
    public String myMod(@PathVariable("n1") double n1, @PathVariable("n2") double n2) {
        return (n1 % n2)+"";
    }

    @RequestMapping(value = "/max", method = RequestMethod.POST)
    public String myMax(@RequestParam("n1") double n1, @RequestParam("n2") double n2) {
        return Math.max(n1, n2)+"";
    }
}