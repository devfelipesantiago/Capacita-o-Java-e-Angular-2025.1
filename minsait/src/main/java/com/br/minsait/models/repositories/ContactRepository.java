package com.br.minsait.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.minsait.models.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

  List<Contact> findContactByPersonId(int personId);
}
