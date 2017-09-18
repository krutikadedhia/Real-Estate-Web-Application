package com.neu.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.exception.AdException;
import com.neu.pojo.Address;
//import com.neu.pojo.Address;
//import com.neu.pojo.Email;
import com.neu.pojo.Property;
import com.neu.pojo.Seller;
import com.neu.pojo.User;

public class PropertyDAO extends DAO {
	//public Property create(String bed,String bath,String price,String area)
	//public Property create(String area,String bed,String bath,String category,String postedBy, String price, String status, String zip,User user)
	public Property create(String area, String bed, String bath, String category,  String price,
			String status,String postedBy,String zip, String city, String street) throws AdException{
            
        try {
            begin();
            Address address=new Address(zip,city,street);
            
            System.out.println("Posted by in Property DAO " );
            Property property = new Property(area,bed, bath,category,price, status,postedBy);
            address.setCity(city);
            address.setZip(zip);
            address.setStreet(street);
            property.setArea(area);
            property.setBed(bed);
            property.setBath(bath);
            property.setCategory(category);
            property.setPostedBy(postedBy);
            property.setPrice(price);
            property.setStatus(status); 
          property.setAddress(address);
          address.setProperty(property);
           //property.setZip(zip);
            
            getSession().save(property);
            commit();
            return property;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create property", e);
            throw new AdException("Exception while creating property: " + e.getMessage());
        }
    }

	public String markComplete(String id, String username) throws AdException {
        try {
            begin();
//          Long  userId = user.getPersonID();
          

          //Long taskID = Long.parseLong(taskId);
            Query q = getSession().createQuery("update Property set status=:status, buyer=:username where id =:id ");
//            q.setLong("tasker",user.getPersonID());
            q.setString("username", username);
            q.setString("status","Sold Out");
            q.setString("id",id);
            //q.setLong("taskID",taskID);
           int i= q.executeUpdate();
           commit();
            close();
           if (i>0){
               
               return "success";
           }
           else{
               return "";
           }
//            List list = q.list();
            
//            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not process the request", e);
        }
    }
	
	 public List searchBypropId(long propID) throws AdException {
	        try {
	            begin();
	            //String hql="Select * from Property where zipcode like :zipCode";
	            System.out.println("inside search by prop id function");
	            Query q = getSession().createQuery("from Property where propertyID=:propID");
	            System.out.println(q);
	            System.out.println("property id is :  "+propID);
	            //String proppID = String.valueOf(propID);
	            //q.setString("propID",proppID);
	            q.setLong("propID", propID);
	            //q.setString("avail", "Available");
	            System.out.println("full query"+q);
	            List list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not list the properties", e);
	        }
	    }
	
	 public List list() throws AdException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from Property");
	            List list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not list the properties", e);
	        }
	    }
	 
	 public List sellerlist(String user) throws AdException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from Property where postedBy=:user");
	            System.out.println("Seller "+user);
	            q.setString("user",user);
	            List list = q.list();
	            System.out.println(q);
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not list the properties", e);
	        }
	    }
	 
	 public List agentlist() throws AdException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from Property");
	            System.out.println("Agent ");
	           // q.setString("user",user);
	            List list = q.list();
	            System.out.println(q);
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not list the properties", e);
	        }
	    }
	 
	 public List searchBy(String key, String flag) throws AdException {
	     List list = null;   
		 try {
	            begin();
	         
	            //String hql="Select * from Property where zipcode like :zipCode";
	           //String q = "select * from Property";
	            
	          /* if (flag.equalsIgnoreCase("bed")) {
	                q += " where bed LIKE ':" + key + "%'";
	            } else if (flag.equalsIgnoreCase("zip")) {
	                q += " where zip LIKE ':" + key + "%'";
	            } else if (flag.equalsIgnoreCase("category")) {
	                q += " where category LIKE ':" + key + "%'";
	            }*/
	       if (flag.equalsIgnoreCase("bed")) {
	        	Query q1=getSession().createQuery("from Property where bed like :key");
	        	q1.setString("key", key);
	        	 list = q1.list();
	            } else if (flag.equalsIgnoreCase("zip")) {
	            	Query q2=getSession().createQuery("from Address where zip like :key");
	            	q2.setString("key", key);
	            	 list = q2.list();
	            } else if (flag.equalsIgnoreCase("category")) {
	            Query q3=getSession().createQuery("from Property where category like :key");
	            q3.setString("key", key);
	             list = q3.list();
	             
	            }
	          
	           // System.out.println(q);
	          //  Query query = getSession().createQuery(q);
	           // query.setString("key",key);
	            System.out.println(key);
	       //     List list = query.list();
//	            q.setString("key",flag);
//	            List list = q.list();
	            commit();
	            System.out.println("list");
	            return list;
	            
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not list the properties", e);
	        }
	    }
	
    public void delete(Property property)
            throws AdException {
        try {
            begin();
            getSession().delete(property);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete property", e);
        }
    }


		// TODO Auto-generated method stub
		
	
}
