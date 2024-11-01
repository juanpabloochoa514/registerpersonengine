package api_registerPerson.juanpabloochoa.controller;

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

import api_registerPerson.juanpabloochoa.model.Person;
import api_registerPerson.juanpabloochoa.model.PersonDto;
import api_registerPerson.juanpabloochoa.service.PersonService;

@RestController
@RequestMapping("/register-person")
public class PersonController {
	
	private static final Logger log = LoggerFactory.getLogger(PersonController.class);
	
	public PersonController() {
	this.listPerson = new ArrayList<Person>();
	}
	private  List<Person> listPerson = new ArrayList<Person>();
	@Autowired
	private PersonService personService;
	
	@GetMapping("/listAllPersons")
	public ResponseEntity< List<Person>> getPersons() {
		
		try {
			
			listPerson =personService.listAgePerson();
			return	new ResponseEntity<List<Person>>(listPerson,HttpStatus.OK);
		} catch (Exception e) {
			log.error("error  :" + e);
			return new ResponseEntity<List<Person>>(listPerson,HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/order-people-by-birthMonth")
	public ResponseEntity< List<Person>> orderPersonByMonth() {
		try {
			listPerson=personService.listPerMonthPerson();
			return	new ResponseEntity<List<Person>>(listPerson,HttpStatus.OK);
		} catch (Exception e) {
			log.error("error  :" + e);
			return new ResponseEntity<List<Person>>(listPerson,HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/get_averageAgePerson")
	public ResponseEntity<String> ageAveragePerson() {
		try {
			Double avgPerson = personService.agePromediatedPerson();
			return ResponseEntity.status(200).body(avgPerson.toString());
		} catch (Exception e) {
			log.error("exception error in the endpoint : add_person" + e);
			return ResponseEntity.status(500).body("internal error calculated person");
		}
	}

	@PostMapping("/add_person")
	public ResponseEntity<String> addPerson(@RequestBody PersonDto personDto) {
		try {
			log.info("endpoint add_person");
			personService.savePerson(personDto);
			return ResponseEntity.status(200).body("person added");
		} catch (Exception e) {
			log.error("exception error in the endpoint : add_person" + e);
			return ResponseEntity.status(500).body("internal error to add person");
		}
	}


}
