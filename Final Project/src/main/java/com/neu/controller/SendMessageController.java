package com.neu.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neu.DAO.MessageDAO;

import com.neu.DAO.UserDAO;
import com.neu.exception.AdException;
import com.neu.pojo.Messages;


@Controller
//@RequestMapping("/sendMessage.htm")
public class SendMessageController {

	@Autowired
	@Qualifier("messageValidator")
	MessageValidator messageValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(messageValidator);
	}
	
	
	@RequestMapping(value="/sendMessage.htm",method=RequestMethod.POST)
	public ModelAndView saveMessageDetails(HttpServletRequest request,@RequestParam String agentname) throws AdException{
//
		ModelAndView mv=new ModelAndView();
//		propertyValidator.validate(property, result);
//		if(result.hasErrors())
//		{
//			return "Seller";
//		}
    	String message=request.getParameter("message");
		String fromUser=(String) request.getSession().getAttribute("username");
		String messageTo=agentname;
		
        
        //get user message from addAdvertForm
      System.out.println(messageTo);
      

        try {
        UserDAO users=new UserDAO();
        //User user = users.get(postedBy);
           // SellerDAO seller = new SellerDAO();
       //     CategoryDAO categories = new CategoryDAO();
            MessageDAO messages = new MessageDAO();

            //searching from database
//           User user = users.get(username);

            //insert a new property
          messages.create(message,fromUser,messageTo);
          
          //  Property prop=properties.create(bed,bath,price, area, users);
          System.out.println("message created");
            
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }
     
        		mv.setViewName("messageSent");
        		return mv;
    }
 
	@RequestMapping(value="/viewmessage.htm",method=RequestMethod.POST)
	protected ModelAndView viewMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		  //long propID = Long.parseLong(hsr.getParameter("data"));
		String fromUser=(String) request.getSession().getAttribute("username");
		  System.out.println("Agent Name: " + fromUser);
		  MessageDAO messagedao = null;
		  //Messages message;
		  ModelAndView mv=new ModelAndView();
		  List messageList = null;
		  List msgList = new ArrayList();
		  try {
			  messagedao = new MessageDAO();
		         messageList = messagedao.messagelist(fromUser);
		         System.out.println("size is "+messageList.size());
		            Iterator msgIterator = messageList.iterator();

		                while (msgIterator.hasNext())
		                {
		                    Messages message1 = (Messages) msgIterator.next();
		                    msgList.add(message1);
		                    System.out.println(message1.getMessage());
		            }
		            //DAO.close();
		        } 
		        catch (AdException e) {
		            System.out.println(e.getMessage());
		        }
		  mv.addObject("sentMessages", msgList);
		  mv.setViewName("AgentMessages");
		  return mv;
		 //}	
		  //@RequestMapping(method=RequestMethod.GET)
//    public String initializeForm(@ModelAttribute("property")Property property, BindingResult result) { 
//   
       // return "Agent"; 
    } 
}