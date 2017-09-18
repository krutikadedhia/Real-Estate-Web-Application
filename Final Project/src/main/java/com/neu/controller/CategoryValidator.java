/*package com.neu.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.neu.pojo.Category;

import org.springframework.validation.ValidationUtils;

@Component
public class CategoryValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Category.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Category category = (Category) obj;

        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.category", "Category Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "error.invalid.category", "Type Required");
    }
}
*/