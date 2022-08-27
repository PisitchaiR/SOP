package com.example.firstservice;

import org.springframework.stereotype.Controller;

import java.util.*;
@Controller
public class CustomerController {

    private List<Customer> customers = new ArrayList<Customer>();
    customers.add(new Customer("1010", "John", "Male", 25));

    public List<Customer> getCustomers() {
        return this.customers;
    }
    public Customer getCustomerByID(String ID){
        return customers(ID);
    }
    public Customer getCustomerByName(String n){
        return customers;
    }
    public boolean delCustomerByID(String ID) {
        return true;
    }
    public delCustomerByName(String n){
        return true;
    }

    public boolean addCustomer(String ID, String n, String s, int a){
        if(s.equals("male")){
            Customer c = new Customer(ID, n, true, a);
        } else if (s.equals("female")) {
            Customer c = new Customer(ID, n , false, a);
        }
        return true;
    }
}
