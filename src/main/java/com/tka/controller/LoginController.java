package com.tka.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tka.entity.User;

@SpringBootApplication
@Controller // @Controller Anotation indicates that this is a controller class
public class LoginController {
	
	@Autowired
	SessionFactory factory;
	
	//localhost:8080/login
	//Spring will start searching controller class for given url.
	//Once method is found with request URL , that method will be called by spring
	// This method generally gives web page name.
	
	
	@RequestMapping("login")
	public String login() {
		
		
		return "login"; // login is a web page name.. DO not write login.jsp
	}
	
	@RequestMapping("validate")
	public ModelAndView validate(String username,String password) {
		
		String webpage="";
		String data="";
		
		Session session=factory.openSession();
		
		User userfromdb=session.get(User.class,username);
		
		// userfromdb==> [ username=sumit,password=..] user class object given by get(). It contains data from database.
		
		if(username.equals(userfromdb.getUsername()) && password.equals(userfromdb.getPassword()))
		{
			webpage="welcome";
			data="Welcome "+ username;
			
			
		}
		else {
			webpage="login";
			data="Invalid Credentials";
		}
		
		   ModelAndView modelAndView=new ModelAndView();
		   
		   modelAndView.setViewName(webpage);
		   modelAndView.addObject("message",data);  //request.setAttribute("message","....");
		   
		   
		   
		   return modelAndView;	
		   
		
		
		
	}
	

}
