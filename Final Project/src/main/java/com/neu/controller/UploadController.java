//package com.neu.controller;
//
//import java.io.File;
//import java.io.IOException;
//
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.commons.io.FileUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.context.ServletContextAware;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.neu.DAO.PropertyDAO;
//import com.neu.DAO.UserDAO;
//import com.neu.exception.AdException;
//import com.neu.pojo.Property;
//import com.neu.pojo.User;
//
//
//@Controller
//@RequestMapping(value = "/upload.htm")
//public class UploadController implements  ServletContextAware{
//	
//	private ServletContext servletContext;
//	
//	@Override
//	public void setServletContext(ServletContext servletContext) {
//		this.servletContext = servletContext;		
//	}
//	
//	@RequestMapping(method = RequestMethod.POST)
//	public String updateDetails(@ModelAttribute("property") Property property, BindingResult result, 
//			@RequestParam(value = "image", required = false) MultipartFile image, 
//			HttpServletRequest request){
//		try {
//			System.out.println("Saving Image...");
//			saveImage(property.getPropertyid() + ".jpg", image);
//			property.setPhoto(property.getPropertyid() + ".jpg"); //Set the path in user object for accessing later
//			
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//		return "Seller";
//			}
//	
//	private void saveImage(String filename, MultipartFile image)
//			throws RuntimeException, IOException {
//			try {
//			File file = new File(servletContext.getRealPath("/")+"/resources/images/"
//			+ filename);	//Creates a new File
//			 
//			FileUtils.writeByteArrayToFile(file, image.getBytes());  //Transfers Byte by Byte to location
//			System.out.println("Go to the location:  " + file.toString()
//			+ " on your computer and verify that the image has been stored.");
//			} 
//			catch (IOException e) {
//				e.printStackTrace();
//			}
//	}
//}	
