package org.example.service;

import org.example.model.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {

  List<Customer> getAllCustomers();

  ResponseEntity<Customer> getCustomer(Long id);

  void deleteCustomer(Long id);
}
