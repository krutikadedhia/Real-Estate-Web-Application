package com.neu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name="addresstable")
 //table per subclass

public class Address {
	 	
	@GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="property"))
	@Id
	@GeneratedValue(generator="generator")
	@Column(name="id", unique=true, nullable=false)
	private long id;
		
	    @Column(name="city")
	    private String city;

	    @Column(name="zip")
	    private String zip;
	    
	    @Column(name="street")
	    private String street;

	    @OneToOne(fetch=FetchType.EAGER)
		@JoinColumn(name="propertyid")
		private Property property;

	    
	    public Address() {
	        
	    }
	    public Address(String zip,String city,String street) {
	       this.city=city;
	       this.street=street;
	       this.zip=zip;
	    }

	    
		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}



		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public Property getProperty() {
			return property;
		}


		public void setProperty(Property property) {
			this.property = property;
		}


		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
		
		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}


	    
	    
}
