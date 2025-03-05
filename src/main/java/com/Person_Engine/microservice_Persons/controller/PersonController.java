package com.Person_Engine.microservice_Persons.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Person_Engine.microservice_Persons.models.Person;
import com.Person_Engine.microservice_Persons.models.PersonDTO;
import com.Person_Engine.microservice_Persons.service.Service;
@RestController
@RequestMapping("/api/person")
public class PersonController {
	
	private static final Logger log = LoggerFactory.getLogger(PersonController.class);
	
	private  List<Person> listPerson = new ArrayList<Person>();
	
	@Autowired
	private Service service;
	
	public PersonController() {
		this.listPerson = new ArrayList<Person>();
	}
	
	@GetMapping("/listAllPersons")
	public ResponseEntity< List<Person>> getPersons() {
		try {
			listPerson=service.listAllPersons();
			return	new ResponseEntity<List<Person>>(listPerson,HttpStatus.OK);
		} catch (Exception e) {
			log.error("error  :" + e);
			return new ResponseEntity<List<Person>>(listPerson,HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/order-people-by-birthMonth")
	public ResponseEntity< List<Person>> orderPersonByMonth() {
		try {
			listPerson=service.listPerMonthPerson();
			return	new ResponseEntity<List<Person>>(listPerson,HttpStatus.OK);
		} catch (Exception e) {
			log.error("error  :" + e);
			return new ResponseEntity<List<Person>>(listPerson,HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/get_averageAgePerson")
	public ResponseEntity<String> ageAveragePerson() {
		try {
			Double avgPerson = service.agePromediatePerson();
			return ResponseEntity.status(200).body(avgPerson.toString());
		} catch (Exception e) {
			log.error("exception error in the endpoint : add_person" + e);
			return ResponseEntity.status(500).body("If the result its 0.0 its because error ocurried in the proces");
		}
	}

	@PostMapping("/add_person")
	public ResponseEntity<String> addPerson(@RequestBody PersonDTO personDTO) {
		try {
			log.info("endpoint add_person");
			service.savePerson(personDTO);
			return ResponseEntity.status(200).body("person added");
		} catch (Exception e) {
			log.error("exception error in the endpoint : add_person" + e);
			return ResponseEntity.status(500).body("internal error to add person");
		}
	}

}
