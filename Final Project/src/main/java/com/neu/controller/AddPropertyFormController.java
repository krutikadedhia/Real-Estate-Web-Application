package com.neu.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.DAO.PropertyDAO;
import com.neu.DAO.UserDAO;
import com.neu.exception.AdException;
import com.neu.pojo.Property;
import com.neu.pojo.User;


@Controller
@RequestMapping("/addproperty.htm")
public class AddPropertyFormController {

	@Autowired
	@Qualifier("propertyValidator")
	PropertyValidator propertyValidator;
	
	/*@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(propertyValidator);
	}*/
	
	@RequestMapping(method=RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("property")Property property,BindingResult result,HttpServletRequest hsr) throws Exception{

		propertyValidator.validate(property, result);
		if(result.hasErrors())
		{
			return "Seller";
		}
    	
		String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
		String STRING_PATTERN = "[a-zA-Z]+";
		String Number_PATTERN = "[0-9]+";
		String STRING_Number = "[a-zA-Z0-9]+";
		
      //  String username = property.getPostedBy();   //get posting user from addAdvertForm
     //   String categoryTitle = property.getCategory_name();   //get category user from addAdvertForm
        String category=property.getCategory();
        String area=property.getArea();
        String bath=property.getBath();
        String bed=property.getBed();
        String price=property.getPrice();
        String zip=hsr.getParameter("zip");
        String city=hsr.getParameter("city");
        String street=hsr.getParameter("street");
        String status="Available";
        String postedBy= (String) hsr.getSession().getAttribute("username");
        Pattern pattern;
        Matcher matcher;
		
        if (!(zip != null && zip.isEmpty())) { 
        	 pattern = Pattern.compile(regex);
        	matcher = pattern.matcher(zip);        
            if (!matcher.matches()) {  
        	   System.out.println("Enter valid zip code");
          	  return  "Seller";
        }
        }
            if (!(city != null && city.isEmpty())) { 
           	 pattern = Pattern.compile(STRING_PATTERN);
           	matcher = pattern.matcher(city);
               if (!matcher.matches()) {  
           	   System.out.println("Enter valid city name");
             	  return  "Seller";
           }
            }
               if (!(street != null && street.isEmpty())) { 
                 	 pattern = Pattern.compile(STRING_Number);
                 	matcher = pattern.matcher(street);
                     if (!matcher.matches()) {  
                 	   System.out.println("Enter valid street name");
                   	  return  "Seller";
                 }
               }
                     if (!(price != null && price.isEmpty())) { 
                     	 pattern = Pattern.compile(Number_PATTERN);
                     	matcher = pattern.matcher(price);
                         if (!matcher.matches()) {  
                     	   System.out.println("Enter valid value for price");
                       	  return  "Seller";
                     }
                         if (!(area != null && area.isEmpty())) { 
                         	 pattern = Pattern.compile(STRING_Number);
                         	matcher = pattern.matcher(area);
                             if (!matcher.matches()) {  
                         	   System.out.println("Enter valid sq feet area");
                           	  return  "Seller";
                         }
                         }
        //get user message from addAdvertForm
      
      }
        try {
        UserDAO users=new UserDAO();
        //User user = users.get(postedBy);
           // SellerDAO seller = new SellerDAO();
       //     CategoryDAO categories = new CategoryDAO();
            PropertyDAO properties = new PropertyDAO();

            //searching from database
//           User user = users.get(username);

            //insert a new property
          properties.create(area,bed,bath,category, price,status,postedBy,zip,city,street);
          
          //  Property prop=properties.create(bed,bath,price, area, users);

            
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }
        return "addedProperty";
    }
	
    
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("property")Property property, BindingResult result) { 
   
        return "Seller"; 
    } 
}