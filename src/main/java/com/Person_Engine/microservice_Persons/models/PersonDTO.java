package com.Person_Engine.microservice_Persons.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class PersonDTO {
	private String name;

	private String lastName;
    @JsonFormat(pattern="yyyy-MM-DD",shape=Shape.STRING)
	private String birthDate;
	private Integer monthPerson;
	private Integer agePerson;
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

}
