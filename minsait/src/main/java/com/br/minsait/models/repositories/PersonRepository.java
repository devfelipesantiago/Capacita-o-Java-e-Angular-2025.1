package com.br.minsait.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.minsait.models.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
