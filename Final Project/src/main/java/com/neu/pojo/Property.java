package com.neu.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
//import com.neu.pojo.Address;

@Entity
@Table(name="propertytable")
 //table per subclass

public class Property  {
	
	@Id
	@GeneratedValue
	@Column(name="propertyid", unique=true, nullable=false)
	private long propertyid;
//	
//	@OneToOne(fetch=FetchType.EAGER , mappedBy = "property", cascade= CascadeType.ALL)
//	//@Column(name="address")
//	private Address address;
	
//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name="user")
//    private User user;
 	
	@Column(name="category")
	private String category;
	
	@Column(name="price")
	private String price;
	
	@Column(name="bed")
	private String bed;
	
	@Column(name="bath")
	private String bath;
	
	@Column(name="area")
	private String area;
	
	//Property won't be saved to db
	@Column(name="postedBy")
    private String postedBy;
//
//	@Column(name="zip")
//    private String zip;
	
	@Column(name="status")
    private String status;
	
	@Column(name="buyer")
	private String buyer;
	
//	@Column(name="photo")
//	private String photo;
	
	 @OneToOne(fetch=FetchType.EAGER, mappedBy="property", cascade=CascadeType.ALL)
	    private Address address;
	
	   public Property(String category,String bed,String bath, String price, String area,String status, String postedBy){
	        this.category = category;
	     //   this.user=user;
		   	this.bed = bed;
	        this.bath = bath;
	        this.price = price;
	        this.area=area;
	        this.postedBy=postedBy;
	        this.status=status;
	       // this.zip=zip;
//	        this.user=user;
//	        this.category = category_id;
//	        this.category_name=categoryName;
	    }

	    public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	
		public long getPropertyid() {
		return propertyid;
	}

	public void setPropertyid(long propertyid) {
		this.propertyid = propertyid;
	}

		Property() {
	    }
	
//	    
//	   	public User getUser() {
//			return user;
//		}
//
//		public void setUser(User user) {
//			this.user = user;
//		}

//		public String getCategory_name() {
//			return category_name;
//		}
	    

		public String getBuyer() {
			return buyer;
		}


		public void setBuyer(String buyer) {
			this.buyer = buyer;
		}

//		
//		
//		public String getPhoto() {
//			return photo;
//		}
//
//		public void setPhoto(String photo) {
//			this.photo = photo;
//		}


//		public String getZip() {
//			return zip;
//		}
//
//		public void setZip(String zip) {
//			this.zip = zip;
//		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}



//		public void setCategory_name(String category_name) {
//			this.category_name = category_name;
//		}
//
//		public long getCategory() {
//			return category;
//		}
//
//		public void setCategory(long category) {
//			this.category = category;
//		}


//		public User getUser() {
//			return user;
//		}
//
//		public void setUser(User user) {
//			this.user = user;
//		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public String getBed() {
		return bed;
	}
	public void setBed(String bed) {
		this.bed = bed;
	}
	public String getBath() {
		return bath;
	}
	public void setBath(String bath) {
		this.bath = bath;
	}
//	public String getPropertyID() {
//		return propertyID;
//	}
//	public void setPropertyID(String propertyID) {
//		this.propertyID = propertyID;
//	}
//	public String getPropertyType() {
//		return propertyType;
//	}
//	public void setPropertyType(String propertyType) {
//		this.propertyType = propertyType;
//	}

	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}
