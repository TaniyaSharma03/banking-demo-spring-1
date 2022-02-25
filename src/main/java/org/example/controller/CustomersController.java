package org.example.controller;

import org.example.model.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

  @Autowired
  private CustomerService customerService;

  @RequestMapping
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

  @RequestMapping("{id}")
  public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
    return customerService.getCustomer(id);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
  public void deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
  }

  @PostMapping
  public Customer saveCustomer(@RequestBody Customer customer) {
    return customerService.saveCustomer(customer);
  }

  @RequestMapping(value = "{id}", method = RequestMethod.PUT)
  public Customer updateCustomer(@PathVariable Long id,
                                 @RequestBody Customer customer) {
    return customerService.updateCustomer(id, customer);
  }



}
