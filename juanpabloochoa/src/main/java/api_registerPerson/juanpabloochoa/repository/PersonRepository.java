package api_registerPerson.juanpabloochoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api_registerPerson.juanpabloochoa.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
