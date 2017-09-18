//package com.neu.controller;
//
//import javax.servlet.http.HttpServletRequest;
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
//import com.neu.DAO.PropertyDAO;
//import com.neu.DAO.UserDAO;
//import com.neu.exception.AdException;
//import com.neu.pojo.Property;
//import com.neu.pojo.User;
//
//
//@Controller
//@RequestMapping("/deleteProperty.htm")
//public class DeletePropertyController {
//
//	@Autowired
//	@Qualifier("propertyValidator")
//	PropertyValidator propertyValidator;
//	
//	/*@InitBinder
//	private void initBinder(WebDataBinder binder)
//	{
//		binder.setValidator(propertyValidator);
//	}*/
//	
//	@RequestMapping(method=RequestMethod.POST)
//    protected String doSubmitAction(@ModelAttribute("property")Property property,BindingResult result,HttpServletRequest hsr) throws Exception{
//
//		propertyValidator.validate(property, result);
//		if(result.hasErrors())
//		{
//			return "listSellerProperties";
//		}
//    	
//    	
//      //  String username = property.getPostedBy();   //get posting user from addAdvertForm
//     //   String categoryTitle = property.getCategory_name();   //get category user from addAdvertForm
//        String category=property.getCategory();
//        String area=property.getArea();
//        String bath=property.getBath();
//        String bed=property.getBed();
//        String price=property.getPrice();
//        String zip=hsr.getParameter("zip");
//        String city=hsr.getParameter("city");
//        String street=hsr.getParameter("street");
//        String status="Available";
//        String postedBy= (String) hsr.getSession().getAttribute("username");
//        
//        //get user message from addAdvertForm
//      System.out.println(postedBy);
//      
//
//        try {
//        UserDAO users=new UserDAO();
//        //User user = users.get(postedBy);
//           // SellerDAO seller = new SellerDAO();
//       //     CategoryDAO categories = new CategoryDAO();
//            PropertyDAO properties = new PropertyDAO();
//
//            //searching from database
////           User user = users.get(username);
//
//            //insert a new property
//          properties.create(area,bed,bath,category, price,status,postedBy,zip,city,street);
//          
//          //  Property prop=properties.create(bed,bath,price, area, users);
//
//            
//        } catch (AdException e) {
//            System.out.println(e.getMessage());
//        }
//        return "listSellerProperties";
//    }
//    
//	@RequestMapping(method=RequestMethod.GET)
//    public String initializeForm(@ModelAttribute("property")Property property, BindingResult result) { 
//   
//        return "listSellerProperties"; 
//    } 
//}