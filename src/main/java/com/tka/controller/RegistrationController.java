package com.tka.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tka.entity.User;

@Controller
public class RegistrationController {
	
	@Autowired     // when we auto wired anything,,then we have declared the reference of session factry// we don't need to create object..spring will create its object
	SessionFactory factory;
	
	// @Autowired means spring will create object.
	
	//save data is request handler method
	
	@RequestMapping("saveData")
	public ModelAndView saveData(User user)
	{
		
	   Session session=factory.openSession();
	   // [persist(), merge() ]open session method will give session object.
	   //session is a reference and it will refer to Session object given by openSession()method.
	   
	   Transaction tx=session.beginTransaction();
	   
	      session.persist(user);
	   
	   tx.commit();
	   
	   //request handler methods decides which web page and what dynamic datat should be displayed on that web page(save data is request handler method)
	   
	   ModelAndView modelAndView=new ModelAndView();
	   modelAndView.setViewName("login");
	   modelAndView.addObject("message"," Registration Successful . Please Login Now...");  //request.setAttribute("message","....");
	   
	   
	   
	   return modelAndView;	
	}
	

	@RequestMapping("register")
	public String register() {
		return "register"; // register is a web page name.. DO not write register.jsp
	}
	

}
