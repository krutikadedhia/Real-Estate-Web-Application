package com.neu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity //annotation for every pojo
@Table(name="seller") //table name
@PrimaryKeyJoinColumn(name="personID") // for reference to superclass using foreign key
public class Seller extends Person {

	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	@Column(name="password")
    private String password;
    //private Address address;
    //private Date joinedDate;
	
	@Column(name="email")
    private String email;
    
    public Seller(String username, String password) {
    	this.username = username;
        this.password= password;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
