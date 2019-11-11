package com.sandesh.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sandesh.annotation.PostalCode;

@Entity
@Table(name="student")
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotNull(message="Name is Required")
	@Size(min=1, message="Name should contain some value")
	@Column(name="name")
	private String name;
	
	@NotNull(message="Gender is Required")
	@Size(min=1, message="Gender should contain some value")
	@Column(name="gender")
	private String gender;
	
	@Column(name="country")
	private String country;
	
	@PostalCode(message="Postal code must begin with SAN")
	@Pattern(regexp="^[a-zA-z0-9]{5}", message="Invalid regexp for postal code")
	@Column(name="postal_code")
	private String postalCode;
	
	@NotNull(message="Roll number cannot be null")
	@Min(value=1, message="Minimum value can be 1")
	@Max(value=100, message="Maximum value can be 100")
	@Id
	@Column(name="roll_no")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer rollNo;
	
	@Transient
	private Map<String, String> countryList;
	
	@OneToOne(mappedBy="student", cascade=CascadeType.ALL)
	private StudentCS studentCS;
	
	@OneToMany(mappedBy="student", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Course> courses;

	public Student() {
		countryList = new HashMap<>();
		countryList.put("BR", "Brazil");
		countryList.put("NP", "Nepal");
		countryList.put("GR", "Germany");
		countryList.put("IN", "India");
	}
	
	public Student(
			@NotNull(message = "Name is Required") @Size(min = 1, message = "Name should contain some value") String name,
			@NotNull(message = "Gender is Required") @Size(min = 1, message = "Gender should contain some value") String gender,
			String country,
			@Pattern(regexp = "^[a-zA-z0-9]{5}", message = "Invalid regexp for postal code") String postalCode) {
		this();
		this.name = name;
		this.gender = gender;
		this.country = country;
		this.postalCode = postalCode;
	}



	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Map<String, String> getCountryList() {
		return countryList;
	}	

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public StudentCS getStudentCS() {
		return studentCS;
	}

	public void setStudentCS(StudentCS studentCS) {
		this.studentCS = studentCS;
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", country=" + country + ", postalCode=" + postalCode
				+ ", rollNo=" + rollNo + "]";
	}
}
