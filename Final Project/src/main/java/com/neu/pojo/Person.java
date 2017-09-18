package com.neu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="person")
@Inheritance(strategy= InheritanceType.JOINED) //table per subclass

public class Person {

	@Id
	@GeneratedValue
	@Column(name="personID", unique=true, nullable=false)
	private long personID;
	
	@Column(name="firstName") //create column in database
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
//	
//	@Column(name="phone")
//	private String phone;
	
	//@OneToMany(fetch=FetchType.EAGER , mappedBy = "property", cascade= CascadeType.ALL)
	//private Address address;
	
	public Person(){
		
	}
	
	public long getPersonID() {
		return personID;
	}
	public void setPersonID(long personID) {
		this.personID = personID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
//	public String getPhone(){
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
	//public Address getAddress() {
		//return address;
	//}
	//public void setAddress(Address address) {
		//this.address = address;
	//}
	
	
}