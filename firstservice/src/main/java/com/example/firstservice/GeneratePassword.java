package com.example.firstservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class GeneratePassword {
    @RequestMapping(value = "/xxx.generate", method = RequestMethod.GET)
    public String  generate(@RequestParam("name") String name) {
        return "Hi,"+name;
    }
}
