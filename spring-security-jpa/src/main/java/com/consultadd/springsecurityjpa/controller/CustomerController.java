package com.consultadd.springsecurityjpa.controller;

import com.consultadd.springsecurityjpa.model.Customer;
import com.consultadd.springsecurityjpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final static String SUCCESS = "Added Successfully";
    private final static String FAILURE = "Already Exists";

    @Autowired
    CustomerRepository repository;

    @GetMapping("/welcome")
    public String welcome(){
        return "Hi there! How can i help you ?";
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }

    @GetMapping("/post")
    public String addCustomer(){

        /*if(repository.existsById(customer.getCustId())){
            return FAILURE;
        }

        repository.save(customer);*/

        return SUCCESS;
    }
}
