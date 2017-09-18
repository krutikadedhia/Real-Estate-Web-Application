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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neu.DAO.PropertyDAO;
import com.neu.DAO.UserDAO;
import com.neu.exception.AdException;
import com.neu.pojo.Property;
import com.neu.pojo.User;

@Controller
//@RequestMapping("/showAgents.htm")
public class ListAgentsController{

	@RequestMapping(value="/showAgents.htm", method=RequestMethod.POST)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //CategoryDAO categories = null;
        //List categoryList = null;
		UserDAO users=null;
		List agentlist = null;
        List agents = new ArrayList();

        try {
        	users = new UserDAO();
        	agentlist = users.list();

            Iterator agentIterator = agentlist.iterator();

                while (agentIterator.hasNext())
                {
                    User user = (User) agentIterator.next();
                    agents.add(user);
                    System.out.println(user.getType());
                    System.out.println(user.getUsername());
            }
            //DAO.close();
        } 
        catch (AdException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("listAgents", "users", agents);
        return mv;
    }
	
/*	
	@RequestMapping(value={"/markComplete.htm"})
	 public @ResponseBody String markComplete(HttpServletRequest hsr ) throws AdException {
	  HttpSession session = hsr.getSession(false);
	  //User user = (User) session.getAttribute("user");
	  //hsr.getSession().setAttribute("sold", );
	  String username = (String) hsr.getSession().getAttribute("username");
	  String propertyID = hsr.getParameter("propertyID");
	  PropertyDAO prop = new PropertyDAO();
	  return prop.markComplete(propertyID, username);*/
	  
	 //}
	
}