package api_registerPerson.juanpabloochoa.service;
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
import org.springframework.stereotype.Service;
import api_registerPerson.juanpabloochoa.model.Person;
import api_registerPerson.juanpabloochoa.model.PersonDto;
import api_registerPerson.juanpabloochoa.repository.PersonRepository;

@Service
public class PersonService {
	private static final Logger log = LoggerFactory.getLogger(PersonService.class);
	List<Person> listOfPersons;

	public PersonService() {
		this.listOfPersons = new ArrayList<Person>();
	}

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private ModelMapper modelMapper;

	public List<Person> listAgePerson() {

		try {
			return listOfPersons = personRepository.findAll();
		} catch (Exception e) {
			log.error("error to list" + e);
			return null;
		}

	}

	public Double agePromediatedPerson() {
		try {
			List<Person> listPerson = personRepository.findAll();
			Double averagePerson = listPerson.stream().collect(Collectors.averagingInt(n -> n.getAgePerson()));
			return averagePerson;
		} catch (Exception e) {
			log.error("ERROR NO AGE CALCULATED" + e);
			return 0.0;
		}

	}

	/*
	 * listado de personas ordenadas por mes
	 */
	public List<Person> listPerMonthPerson() {
		try {
			List<Person> listOfPerson = personRepository.findAll().stream().sorted(Comparator.comparingInt(Person::getMonthPerson)).collect(Collectors.toList());
			return listOfPerson;
		} catch (Exception e) {
			log.error("error to list" + e);
			return null;
		}

	}

	public void calculatedAgeMonthPerson(PersonDto personDto) {
		try {
		String dateBirthdate = personDto.getBirthDate();
		LocalDate dateBirthDatePerson = LocalDate.parse(dateBirthdate);// parseo defecha de nacimiento
		LocalDate dateNow = LocalDate.now();// fecha actual
		Period yearsPerson = Period.between(dateBirthDatePerson, dateNow);// obtengo los años de diferencia entre fechas
		Integer agePerson = yearsPerson.getYears();
		Integer monthPersonBirthDate = dateBirthDatePerson.getMonthValue();
		personDto.setAgePerson(agePerson);
		personDto.setMonthPerson(monthPersonBirthDate);
		}catch(Exception e) {
			log.error("ERROR TO CALCULATED AGE OF PERSON"+e);
		}
	}

	public void savePerson(PersonDto personDto) {
		try {
			Person person = this.convertToEntity(personDto);
			personRepository.save(person);
		}catch(Exception e) {
			log.error("Error to save person"+e);
		}
		}
		
	

	public Person convertToEntity(PersonDto personDto) {
		try {
		this.calculatedAgeMonthPerson(personDto);
		Person person = modelMapper.map(personDto, Person.class);
		return person;
		}catch(Exception e){
			log.error("error to convert entity person "+e);
			return null;
	}
	}
}
