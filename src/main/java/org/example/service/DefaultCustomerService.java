package org.example.service;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service("customerService")
public class DefaultCustomerService implements CustomerService {

  @Autowired
  private CustomerRepository repository;

  public DefaultCustomerService() {}

  //setter injection
  public void setCustomerRepository(CustomerRepository repository) {
    this.repository = repository;
  }

  public List<Customer> getAllCustomers() {
    return repository.findAll();
  }

  @Override
  public ResponseEntity<Customer> getCustomer(Long id) {
    Optional<Customer> optionalCustomer = repository.findById(id);
    if(optionalCustomer.isPresent()) {
      return new ResponseEntity<>(optionalCustomer.get(), HttpStatus.OK);
    }
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found");
  }

  @Override
  public void deleteCustomer(Long id) {
    // before deleting, verify that the Customer exists in the DB
    ResponseEntity<Customer> responseEntity = getCustomer(id);

    if(responseEntity.getStatusCode().is4xxClientError()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found");
    }
    repository.deleteById(id);
  }

  @Override
  public Customer saveCustomer(Customer customer) {
    return repository.saveAndFlush(customer);
  }

  @Override
  public Customer updateCustomer(Long id, Customer customer) {
    ResponseEntity<Customer> responseEntity = getCustomer(id);
    if(responseEntity.getStatusCode().is4xxClientError()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "invalid customer id");
    }
    Customer existingCustomer = responseEntity.getBody();
    BeanUtils.copyProperties(customer, existingCustomer, "id");
    return repository.saveAndFlush(existingCustomer);
  }

}
