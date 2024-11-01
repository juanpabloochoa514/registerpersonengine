package api_registerPerson.juanpabloochoa.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="persons")
public class Person{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private Integer id;
	
	private String name;

	private String lastName;
    @JsonFormat(pattern="yyyy-MM-DD",shape=Shape.STRING)
	
	private String birthDate;
	
	private Integer monthPerson;
	
	private Integer agePerson;

	private Long dni;
	@Override
	public String toString() {
		return "Error to convert entity...Person model error.";
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getMonthPerson() {
		return monthPerson;
	}

	public void setMonthPerson(Integer monthPerson) {
		this.monthPerson = monthPerson;
	}

	public Integer getAgePerson() {
		return agePerson;
	}

	public void setAgePerson(Integer agePerson) {
		this.agePerson = agePerson;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

}
