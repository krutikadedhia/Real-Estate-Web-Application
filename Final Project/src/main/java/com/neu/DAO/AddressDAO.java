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

public class AddressDAO extends DAO {
	 	 
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
	       if (flag.equalsIgnoreCase("street")) {
	        	Query q1=getSession().createQuery("from Address where street like :key");
	        	q1.setString("key", "%"+key+"%");
	        	 list = q1.list();
	            } else if (flag.equalsIgnoreCase("city")) {
	            	Query q2=getSession().createQuery("from Address where city like :key");
	            	q2.setString("key", "%"+key+"%");
	            	 list = q2.list();
	            } else if (flag.equalsIgnoreCase("zip")) {
	            Query q3=getSession().createQuery("from Address where zip like :key");
	            q3.setString("key", "%"+key+"%");
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
