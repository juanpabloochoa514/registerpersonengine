package com.Person_Engine.microservice_Persons.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="persons")
public class Person {

	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer id;
		@Column(name = "person_name")
		private String name;
		@Column(name = "person_lastname")
		private String lastName;
		@Column(name = "person_bithdate")
	    @JsonFormat(pattern="yyyy-MM-DD",shape=Shape.STRING)
		private String birthDate;
		@Column(name = "person_monthperson")
		private Integer monthPerson;
		@Column(name = "person_ageperson")
		private Integer agePerson;

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

}
