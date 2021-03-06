package com.neu.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.pojo.Messages;
import com.neu.pojo.User;

public class MessageValidator implements Validator {

//	 private Pattern pattern;  
//	 private Matcher matcher; 
//	 String STRING_PATTERN = "[a-zA-Z]+";
    public boolean supports(Class clazz)
    {
        return clazz.equals(Messages.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	Messages messages = (Messages) obj;
    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message", "error.invalid.messages", "Message Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
//        if (!(user.getUsername() != null && user.getUsername().isEmpty())) {  
//      	   pattern = Pattern.compile(STRING_PATTERN);  
//      	   matcher = pattern.matcher(user.getUsername());  
//      	   if (!matcher.matches()) {  
//      	    errors.rejectValue("username", "user.containNonChar",  
//      	      "Enter a valid Username");  
//      	   }  
//      	  } 
//         if (!(user.getPassword() != null && user.getPassword().isEmpty())) { 
//         if (user.getPassword().toString().length() < 8) {  
//             errors.rejectValue("password", "password.less",  
//               "Password should contain minimum 8 characters");  
//            }  
//           }
//     }
    }
}
    

