package com.Person_Engine.microservice_Persons.service;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.Person_Engine.microservice_Persons.exceptions.ExceptionPersons;
import com.Person_Engine.microservice_Persons.interfaces.PersonRepository;
import com.Person_Engine.microservice_Persons.models.Person;
import com.Person_Engine.microservice_Persons.models.PersonDTO;
@org.springframework.stereotype.Service
public class Service extends PersonMethods  {
	
	private static final Logger log = LoggerFactory.getLogger(Service.class);
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	List<Person> listOfPersons;

	
	public Service() {
		this.listOfPersons = new ArrayList<Person>();
	}
	@Override
	public List<Person> listAllPersons() {

		try {
			 return listOfPersons=personRepository.findAll();			 
		} catch (Exception e) {
			log.error("error to list" + e);
			return null;
		}
	}

	@Override
	public Double agePromediatePerson() {
		try {
			List<Person> listPerson = personRepository.findAll();
			Double averagePerson = listPerson.stream().collect(Collectors.averagingInt(n -> n.getAgePerson()));
			return averagePerson;
		} catch (Exception e) {
			log.error("ERROR, NO AGE CALCULATED" + e);
			return 0.0;
		}
	}

	@Override
	public List<Person> listPerMonthPerson()throws ExceptionPersons {
		try {
			List<Person> listOfPerson = personRepository.findAll().stream().sorted(Comparator.comparingInt(Person::getMonthPerson)).collect(Collectors.toList());
			return listOfPerson;
		} catch (Exception e) {
			log.error("error to list" + e);
			return null;
		}	
		
	}

	@Override
	public void calculatedAgeMonthPerson(PersonDTO personDTO) {
		try {
			String dateBirthdate = personDTO.getBirthDate();
			LocalDate dateBirthDatePerson = LocalDate.parse(dateBirthdate);// parseo defecha de nacimiento
			LocalDate dateNow = LocalDate.now();// fecha actual
			Period yearsPerson = Period.between(dateBirthDatePerson, dateNow);// obtengo los años de diferencia entre fechas
			Integer agePerson = yearsPerson.getYears();
			Integer monthPersonBirthDate = dateBirthDatePerson.getMonthValue();
			personDTO.setAgePerson(agePerson);
			personDTO.setMonthPerson(monthPersonBirthDate);
			}catch(Exception e) {
				log.error("ERROR TO CALCULATED AGE OF PERSON"+e);
			}
		
	}

	@Override
	public void savePerson(PersonDTO personDTO) {
		try {
			Person person = this.convertToEntity(personDTO);
			personRepository.save(person);
		}catch(Exception e) {
			log.error("Error to save person"+e);
		}
		
	}

	@Override
	public Person convertToEntity(PersonDTO personDTO) {
		try {
			Person person = modelMapper.map(personDTO, Person.class);
			return person;
			}catch(Exception e){
				log.error("error to convert entity person "+e);
				return null;
		}
	}
	
}
