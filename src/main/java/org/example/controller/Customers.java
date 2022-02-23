package org.example.controller;

import org.example.model.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Customers {

  @Autowired
  private CustomerService customerService;

  @GetMapping("/api/customers")
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

}

