package org.example.model;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "customers")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id")
  private Long id;
  private String name;
  private String city;

  @Column(name = "date_of_birth")
  private Date dateOfBirth;
  private String zipcode;
  private Integer status;

  public Customer() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
