package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("customerService")
public class DefaultCustomerService implements CustomerService {

  @Autowired
  @Qualifier("stub")
  private CustomerRepository repository;

  public List<Customer> getAllCustomers() {
    return repository.findAll();
  }

  public List<Customer> getAllCustomersWithStars() {
    return repository.findAll()
      .stream()
      .map(c -> new Customer(c.getId(), "#####"+c.getName()+"****", c.getCity()))
      .collect(Collectors.toList());
  }

}
