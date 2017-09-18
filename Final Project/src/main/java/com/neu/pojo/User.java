package com.neu.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
//import javax.validation.constraints.Size;

//import org.hibernate.validator.constraints.Email;
//import org.hibernate.validator.constraints.NotEmpty;


@Entity //annotation for every pojo
@Table(name="usertable") //table name
@PrimaryKeyJoinColumn(name="personID") // for reference to superclass using foreign key
public class User extends Person {
	
	  @Override
	    public void setFirstName(String fname){
	        super.setFirstName(fname);
	    }
	  @Override
	    public String getFirstName(){
	       return super.getFirstName();
	    }
	  @Override
	    public void setLastName(String lname){
	        super.setLastName(lname);
	    } 
	  @Override
	    public String getLastName(){
	       return super.getLastName();
	    }
	  
	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	//@Size(min = 6, max = 15, message = "Your password must be between 6 and 15 characters")
	@Column(name="password")
    private String password;
    //private Address address;
    
	  @OneToOne(fetch=FetchType.EAGER, mappedBy="user", cascade=CascadeType.ALL)
	    private Email email;
	
	@Column(name="type")
	private String type;

    public User(String username, String password, String type) {
        
    	this.username = username;
        this.password= password;
       // this.email=email;
        this.type=type;
      
    }
    
   public User(String firstname,String lastname){
    	super();
    	
    }
   public User(){
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

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

       
}
