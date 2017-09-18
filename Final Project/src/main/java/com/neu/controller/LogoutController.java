package com.neu.controller;

import javax.servlet.http.HttpServletRequest;
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

import com.neu.DAO.UserDAO;
import com.neu.exception.AdException;
import com.neu.pojo.User;

@Controller
@RequestMapping("/logout.htm")
public class LogoutController {
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.GET)
	protected String doSubmitAction(HttpServletRequest hsr,@ModelAttribute("user") User user, BindingResult result) throws Exception {
		HttpSession session=hsr.getSession();
		System.out.println("Session after clicking logout" + hsr.getSession().getAttribute("username"));
		session.invalidate();
		System.out.println("Session after invalidate" + hsr.getSession().getAttribute("username"));
		return "index";

		//return "home";
	}

	
	/*@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {

		return "index";
	}*/
	
}