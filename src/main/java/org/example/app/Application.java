package org.example.app;

import org.example.model.Customer;
import org.example.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Application {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    CustomerService service = context.getBean("customerService", CustomerService.class);

    List<Customer> customers = service.getAllCustomers();
    customers.forEach(System.out::println);
  }

}
