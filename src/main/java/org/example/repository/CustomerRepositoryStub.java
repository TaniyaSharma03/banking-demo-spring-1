package org.example.repository;

import org.example.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Arrays.asList;

@Repository("stub")
public class CustomerRepositoryStub implements CustomerRepository {

  public List<Customer> findAll() {
    return asList(
      new Customer("1", "Brijesh", "New Delhi"),
      new Customer("2", "Dharmesh", "New Delhi"),
      new Customer("3", "Taniya", "New Delhi")
    );
  }

}
