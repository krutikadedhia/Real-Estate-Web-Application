package com.neu.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.exception.AdException;
import com.neu.pojo.Email;
//import com.neu.pojo.Email;
import com.neu.pojo.User;


public class UserDAO extends DAO {
	
	 public UserDAO() {
	    }
    public User get(String username)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where username = :username");
            q.setString("username", username);
            User user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }
    
    public List list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where type='Agent'");
           // q.setString("type",'Agent');
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the agents", e);
        }
    }
	
    public String passwordMatch(String username)
            throws AdException {
        try {
            begin();
            Query q = getSession().createSQLQuery("Select password from usertable where username=:username");
            q.setString("username", username);
            System.out.println(q);
            System.out.println(username);
            String pwd = q.uniqueResult().toString();
            //User user = (User) q.uniqueResult();
            commit();
            return pwd;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }
    
	public User create(String username, String password,String emailId, String firstName, String lastName, String type)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
            
            Email email=new Email(emailId);
            User user=new User(username,password, type);
            
            user.setFirstName(firstName);
            user.setLastName(lastName);
            
            //buyer.setEmail(emailId);
            user.setEmail(email);
            email.setUser(user);
            
            getSession().save(user);
            
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }
}
