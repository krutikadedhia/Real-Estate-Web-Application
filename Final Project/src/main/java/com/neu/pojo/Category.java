//package com.neu.pojo;
//
//
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//
//
//@Entity
//@Table(name="categorytable")
//public class Category {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="categoryid", unique = true, nullable = false  )
//	private long id;
//	
//	@Column(name="title")
//    private String title;
//	
////	@Column(name="type")
////	private String type;
//    
//	
//	@OneToMany(fetch=FetchType.LAZY, mappedBy="category")
//	private Set<Property> properties = new HashSet<Property>();
//
//    public Category(String title) {
//        this.title = title;
//       // this.type = type;
//        this.properties = new HashSet<Property>();
//    }
//
//    public void addProperty(Property property) {
//        getProperties().add(property);
//    }
//    
//    Category() {
//    }
//
//    public Set<Property> getProperties() {
//        return properties;
//    }
//
//    void setProperties(Set<Property> properties) {
//        this.properties = properties;
//    }
//
//    public void addAdvert(Property property) {
//        getProperties().add(property);
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public long getId() {
//        return id;
//    }
//    
//    public void setId(long id) {
//        this.id = id;
//    }
////
////	public String getType() {
////		return type;
////	}
////
////	public void setType(String type) {
////		this.type = type;
////	}
//    
//    
//}