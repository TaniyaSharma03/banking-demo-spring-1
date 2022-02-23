package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultCustomerService implements CustomerService {

  private CustomerRepository repository;

  public DefaultCustomerService() {}

  //setter injection
  public void setCustomerRepository(CustomerRepository repository) {
    this.repository = repository;
  }

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
