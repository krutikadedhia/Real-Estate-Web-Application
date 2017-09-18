//package com.neu.controller;
//
//import com.neu.pojo.Category;
//import com.neu.pojo.User;
////import com.neu.DAO;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.neu.DAO.CategoryDAO;
//import com.neu.exception.AdException;
//
//@Controller
//@RequestMapping("/addcategory.htm")
//public class AddCategoryFormController
//{
//	@Autowired
//	@Qualifier("categoryValidator")
//	CategoryValidator categoryValidator;
//	
//	@InitBinder
//	private void initBinder(WebDataBinder binder)
//	{
//		binder.setValidator(categoryValidator);
//	}
//	
//	@RequestMapping(method=RequestMethod.POST)
//    protected String doSubmitAction(@ModelAttribute("category")Category category,BindingResult result) throws Exception
//    {
//		categoryValidator.validate(category, result);
//		if(result.hasErrors())
//		{
//			return "addCategoryForm";
//		}
//        
//        try
//        {
//            CategoryDAO categoryDAO = new CategoryDAO();
//            categoryDAO.create(category.getTitle());
//            //DAO.close();
//        }
//        catch (AdException e)
//        {
//            System.out.println(e.getMessage());
//        }
//        return "addProperty";
//    }
//    
//	@RequestMapping(method=RequestMethod.GET)
//    public String initializeForm(@ModelAttribute("category")Category category, BindingResult result) { 
//   
//        return "addCategoryForm"; 
//    } 
//}