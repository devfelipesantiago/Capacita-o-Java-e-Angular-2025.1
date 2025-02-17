package com.br.minsait.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "contact_tb")
public class Contact {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Enumerated(EnumType.STRING)
  @NotNull
  private ContactType contactType;

  @NotNull
  private String contact;

  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "person_id")
  private Person person;

  public Contact() {
  }

  public Contact(ContactType contactType, String contact, Person person) {
    this.contactType = contactType;
    this.contact = contact;
    this.person = person;
  }

  public int getId() {
    return id;
  }

  public ContactType getContactType() {
    return contactType;
  }

  public void setContactType(ContactType contactType) {
    this.contactType = contactType;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  @Override
  public String toString() {
    return "Contact{" +
        "id=" + id +
        ", contactType=" + contactType +
        ", contact='" + contact + '\'' +
        ", person=" + person +
        '}';
  }
}
