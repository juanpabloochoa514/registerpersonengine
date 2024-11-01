package api_registerPerson.juanpabloochoa.model;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PersonDto {
	private Integer id;
	private String name;
	private String lastName;
	private String birthDate;
	private Integer monthPerson;
	private Integer agePerson;
	private Long dni;
	
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
