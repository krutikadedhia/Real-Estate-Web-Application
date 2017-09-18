package com.neu.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neu.DAO.PropertyDAO;
import com.neu.exception.AdException;
import com.neu.pojo.Property;

@Controller
//@RequestMapping("/listProperties.htm")
public class ListPropertiesController{

	@RequestMapping(value="/listProperties.htm", method=RequestMethod.POST)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //CategoryDAO categories = null;
        //List categoryList = null;
		PropertyDAO properties=null;
		List propertyList = null;
        List propList = new ArrayList();

        try {
        	properties = new PropertyDAO();
            propertyList = properties.list();

            Iterator propIterator = propertyList.iterator();

                while (propIterator.hasNext())
                {
                    Property property = (Property) propIterator.next();
                    propList.add(property);
                    System.out.println(property.getBed());
                    System.out.println(property.getPostedBy());
            }
            //DAO.close();
        } 
        catch (AdException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("listProperties", "properties", propList);
        return mv;
    }
	
	
	@RequestMapping(value="/listprops.htm", method=RequestMethod.POST)
    protected ModelAndView handleRequestInternal1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //CategoryDAO categories = null;
        //List categoryList = null;
		PropertyDAO properties=null;
		List propertyList = null;
        List propList = new ArrayList();
        String user=(String) request.getSession().getAttribute("username");
        System.out.println(user);
        try {
        	properties = new PropertyDAO();
            propertyList = properties.sellerlist(user);
            System.out.println(propertyList.size());
            Iterator propIterator = propertyList.iterator();

                while (propIterator.hasNext())
                {
                    Property property = (Property) propIterator.next();
                    propList.add(property);
                    System.out.println(property.getBed());
                    System.out.println(property.getPostedBy());
            }
            //DAO.close();
        } 
        catch (AdException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("listSellerProperties", "properties", propList);
        return mv;
    }
	
	
	@RequestMapping(value="/listagentprops.htm", method=RequestMethod.POST)
    protected ModelAndView handleRequestInternal2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //CategoryDAO categories = null;
        //List categoryList = null;
		PropertyDAO properties=null;
		List propertyList = null;
        List propList = new ArrayList();
        String user=(String) request.getSession().getAttribute("username");
        System.out.println(user);
        try {
        	properties = new PropertyDAO();
            propertyList = properties.agentlist();
            System.out.println(propertyList.size());
            Iterator propIterator = propertyList.iterator();

                while (propIterator.hasNext())
                {
                    Property property = (Property) propIterator.next();
                    propList.add(property);
                    System.out.println(property.getBed());
                    System.out.println(property.getPostedBy());
            }
            //DAO.close();
        } 
        catch (AdException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("listAgentProperties", "properties", propList);
        return mv;
    }
	
	 @RequestMapping(value="/viewMoreDetails.htm*",method=RequestMethod.GET)
	 public ModelAndView viewPropertyDetails(@RequestParam int propId) throws AdException{
	  
	  System.out.println("Property ID : " + propId  );
	  PropertyDAO properties = null;
	  Property property;
	 List propertyList = null;
	  ModelAndView mv=new ModelAndView();
	  List propList = new ArrayList();
	  try {
	         properties = new PropertyDAO();
	         propertyList = properties.searchBypropId(propId);
	         System.out.println("size is "+propertyList.size());
	            Iterator propIterator = propertyList.iterator();

	                while (propIterator.hasNext())
	                {
	                    Property property1 = (Property) propIterator.next();
	                    propList.add(property1);
	                
	            }
	            //DAO.close();
	        } 
	        catch (AdException e) {
	            System.out.println(e.getMessage());
	        }
	  mv = new ModelAndView("listMoreDetails", "searchProperties", propList);
      return mv;
	
	 }
	
	
	@RequestMapping(value={"/markComplete.htm"})
	 public @ResponseBody String markComplete(HttpServletRequest hsr ) throws AdException {
	  HttpSession session = hsr.getSession(false);
	  //User user = (User) session.getAttribute("user");
	  //hsr.getSession().setAttribute("sold", );
	  String username = (String) hsr.getSession().getAttribute("username");
	  String propertyID = hsr.getParameter("propertyID");
	  PropertyDAO prop = new PropertyDAO();
	  return prop.markComplete(propertyID, username);
	  
	 }
	
}