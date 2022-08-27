package com.example.firstservice;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class GeneratePasswordService {
    @RequestMapping(path = "{name:[a-z]+}.generate", method = RequestMethod.GET)
    public String  generate(@PathVariable("name") String name) {
        Random rand = new Random();
        int upperbound = 999999999;
        int int_random = rand.nextInt(upperbound);

        return "Hi,"+name+"\n"+"Your new password is "+ int_random+'.';
    }
}
