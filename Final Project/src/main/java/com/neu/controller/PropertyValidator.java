package com.neu.controller;



import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.neu.pojo.Property;

import org.springframework.validation.ValidationUtils;

@Component
public class PropertyValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Property.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	Property property = (Property) obj;

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bed", "error.invalid.property", "No of bed Required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bath", "error.invalid.property", "No of bath Required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "area", "error.invalid.property", "Area Required");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "error.invalid.property", "Price");
    }
}
