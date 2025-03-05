package com.Person_Engine.microservice_Persons.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Person_Engine.microservice_Persons.models.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer	>{

}
