package com.neu.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.neu.exception.AdException;
import com.neu.pojo.Messages;
//import com.neu.pojo.Address;
//import com.neu.pojo.Email;


public class MessageDAO extends DAO {
	
	public Messages create(String message, String fromUser, String messageTo) throws AdException{
            
        try {
            begin();
            Messages msg=new Messages(message,fromUser, messageTo);
            
            System.out.println("Posted by in Message DAO " );
//            Property property = new Property(area,bed, bath,category,price, status,postedBy);
            msg.setMessage(message);
            msg.setFromUser(fromUser);
            msg.setMessageTo(messageTo);

            
            getSession().save(msg);
            commit();
            return msg;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create property", e);
            throw new AdException("Exception while creating message: " + e.getMessage());
        }
    }
	
	public List messagelist(String user) throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from messagetable where messageTo=:user");
            System.out.println("MessageTo "+user);
            q.setString("user",user);
            List list = q.list();
            System.out.println(q);
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the messages", e);
        }
    }
	
}
