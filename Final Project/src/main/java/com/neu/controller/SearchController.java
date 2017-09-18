package com.neu.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.DAO.AddressDAO;
import com.neu.DAO.PropertyDAO;
import com.neu.exception.AdException;
import com.neu.pojo.Address;
import com.neu.pojo.Property;

@Controller
@RequestMapping("/search.htm")
public class SearchController {

	//@Autowired
	//@Qualifier("propertyValidator")
	//PropertyValidator propertyValidator;
	
	/*@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(propertyValidator);
	}*/
	

	@RequestMapping(method=RequestMethod.POST)
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse response) throws Exception {
        //CategoryDAO categories = null;
        //List categoryList = null;
		AddressDAO addressdao=null;
		List propertyList = null;
        List propList = new ArrayList();
        String key=hsr.getParameter("address");
        String searchKey=hsr.getParameter("searchkey");

        try {
        	addressdao = new AddressDAO();
            propertyList = addressdao.searchBy(key, searchKey);

            Iterator propIterator = propertyList.iterator();

                while (propIterator.hasNext())
                {
                    Address address = (Address) propIterator.next();
                    propList.add(address);
                    System.out.println(address.getProperty().getBed());
                    System.out.println(address.getProperty().getPostedBy());
            }
            //DAO.close();
        } 
        catch (AdException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("searchProperties", "addressdao", propList);
        return mv;
    }
}