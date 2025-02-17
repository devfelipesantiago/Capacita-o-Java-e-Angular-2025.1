package com.br.minsait.models.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "person_tb")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotNull
  @Column(nullable = false)
  private String name;
  private String address;
  private String zipCode;
  private String city;
  private String state;

  @JsonManagedReference
  @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
  private final List<Contact> contactList = new ArrayList<>();

  public Person() {
  }

  public Person(String name, String adress, String zipCode, String city, String state) {
    this.name = name;
    this.address = adress;
    this.zipCode = zipCode;
    this.city = city;
    this.state = state;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public List<Contact> getContactList() {
    return contactList;
  }

  public void setContactList(Contact contact) {
    this.contactList.add(contact);
  }

  @Override
  public String toString() {
    return "Person{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", zipCode='" + zipCode + '\'' +
        ", city='" + city + '\'' +
        ", state='" + state + '\'' +
        ", contactList=" + contactList +
        '}';
  }
}
