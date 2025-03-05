package com.Person_Engine.microservice_Persons.service;

import java.util.List;

import com.Person_Engine.microservice_Persons.models.Person;
import com.Person_Engine.microservice_Persons.models.PersonDTO;

public abstract class PersonMethods {
	

	
	public  void personsMethods(PersonDTO personDTO) {
		listAllPersons();
		agePromediatePerson();
		listPerMonthPerson();
		calculatedAgeMonthPerson(personDTO);
		savePerson(personDTO);
		convertToEntity(personDTO);
		
	}

	abstract List<Person>listAllPersons();
	
	abstract Double agePromediatePerson();
	
	abstract List<Person> listPerMonthPerson();
	
	abstract void calculatedAgeMonthPerson(PersonDTO personDTO);
	
	abstract void savePerson(PersonDTO personDTO);
	
	abstract Person convertToEntity(PersonDTO personDTO);
	
}
