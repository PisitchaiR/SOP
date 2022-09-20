package com.example.firstservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
public class CustomerController {
    private List<Customer> customers;

    public CustomerController(){
        this.customers = new ArrayList<Customer>();
        this.customers.add(new Customer("1010", "John", "Male", 25));
        this.customers.add(new Customer("1018", "Peter", "Male", 25));
        this.customers.add(new Customer("1019", "Sara", "Female", 25));
        this.customers.add(new Customer("1110", "Rose", "Female", 25));
        this.customers.add(new Customer("1001", "Emma", "Female", 25));
    }

    @RequestMapping("/customers")
    public List<Customer> getCustomers() {return this.customers;}

    @RequestMapping("/customersByID/{id}")
    public Customer getCustomerByID(@PathVariable("id") String ID){
        for (Customer c: getCustomers()){
            if(c.getID().equals(ID)){
                return c;
            }
        }
        return null;
    }

    @RequestMapping("/customerbyname/{n}")
    public Customer getCustomerByName(@PathVariable("n") String n){
        for (Customer c: getCustomers()){
            if(c.getName().equals(n)){
                return c;
            }
        }
        return null;
    }
    //    allow for request method delete only
    @RequestMapping(value = "/customerDelByid/{id}", method = RequestMethod.DELETE)
    public boolean delCustomerByID(@PathVariable("id") String ID){
        for (Customer c: getCustomers()){
            if(c.getID().equals(ID)){
                return getCustomers().remove(c);
            }
        }
        return false;
    }
    //    allow for request method delete only
    @RequestMapping(value = "/customerDelByname/{n}", method = RequestMethod.DELETE)
    public boolean delCustomerByName(@PathVariable("n") String n){
        for (Customer c: getCustomers()){
            if(c.getName().equals(n)){
                return getCustomers().remove(c);
            }
        }
        return false;
    }

    @RequestMapping("/addCustomer")
    public boolean addCustomer(@RequestParam("id") String ID, @RequestParam("name") String n, @RequestParam("sex") String s, @RequestParam("age") Integer a){
        return getCustomers().add(new Customer(ID, n, s, a));
    }


//    allow for request method post only
    @RequestMapping(value = "/addCustomer2", method = RequestMethod.POST)
    public boolean addCustomer2(@RequestParam("id") String ID, @RequestParam("name") String n, @RequestParam("sex") String s, @RequestParam("age") Integer a){
        return getCustomers().add(new Customer(ID, n, s, a));
    }
}
