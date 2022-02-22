package org.example;

import org.example.repository.CustomerRepository;
import org.example.repository.CustomerRepositoryDB;
import org.example.service.CustomerService;
import org.example.service.DefaultCustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean("customerService")
  public CustomerService getCustomerService() {
    CustomerService service = new DefaultCustomerService(getCustomerRepositoryDB());
    return service;
  }

  @Bean("customerRepository")
  public CustomerRepository getCustomerRepositoryDB() {
    return new CustomerRepositoryDB();
  }

}
