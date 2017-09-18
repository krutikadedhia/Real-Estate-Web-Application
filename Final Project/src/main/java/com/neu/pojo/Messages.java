package com.neu.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="messagetable")
public class Messages {

	@Id
	@GeneratedValue
	@Column(name="messageId", unique=true, nullable=false)
	private String messageId;
	
	@Column(name="userName")
    private String userName;
	
	@Column(name="fromUser")
    private String fromUser;
	
	@Column(name="message")
    private String message;
	
	@Column(name="messageTo")
    private String messageTo;
	
	
	
	public Messages(){
		
	}
	
	 public Messages(String message, String fromUser, String messageTo) {
	        this.message = message;
	        this.fromUser= fromUser;
	        this.messageTo=messageTo;
	       // this.email=email;
	    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public String getMessageTo() {
		return messageTo;
	}

	public void setMessageTo(String messageTo) {
		this.messageTo = messageTo;
	}   
    
}

