package com.PJ.Shipping.Controller;

import com.PJ.Shipping.Entity.Customer;
import com.PJ.Shipping.Repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class CustomerController {

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerController(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

  
    // @GetMapping("profile/customer")
    // public Collection<Customer> Customers() {
    // return customerRepository.findAll().stream().collect(Collectors.toList());
    // }

    @GetMapping("/customer")
    public Collection<Customer> Customers() {
        return customerRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/customer/{Cus_id}")
    public Customer getCustomers(@PathVariable("Cus_id") final long id) {
    return customerRepository.findById(id);
    }
    @PostMapping("/customer/{Fname}/{Lname}/{Email}/{Phone}")
    public Customer CreateNewCustomer(
        @PathVariable String Fname ,
        @PathVariable String Lname ,
        @PathVariable String Email,
        @PathVariable String Phone )
        
         {

        Customer customer = new Customer();

        

        customer.setFname(Fname);
        customer.setLname(Lname);
        customer.setEmail(Email);
        customer.setPhone(Phone);

        return customerRepository.save(customer); // บันทึก Objcet ชื่อ Customer

    }

}