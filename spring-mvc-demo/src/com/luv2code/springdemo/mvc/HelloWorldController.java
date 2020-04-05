package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	//need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the HTML form
	@RequestMapping("processForm")
	public String processForm() {
		return "helloworld";
	}
	
	/* add a new controller method to read form data and
	 * add data to the model
	 * */
	@RequestMapping("processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
	
		//read the request parameter from html form
		String theName = request.getParameter("studentName");
		
		//convert the data to upper case
		theName =  theName.toUpperCase();
		
		String result = "Yo " + theName;
		//create the message
		model.addAttribute("message", result);
		
		//add the message to the model
		
		return "helloworld";
	}
}
