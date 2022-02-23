package org.example.model;

import javax.persistence.*;

@Entity(name = "customers")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id")
  private String id;

  private String name;
  private String city;

  public Customer() {}

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public String toString() {
    return "Customer{" +
      "id='" + id + '\'' +
      ", name='" + name + '\'' +
      ", city='" + city + '\'' +
      '}';
  }
}
