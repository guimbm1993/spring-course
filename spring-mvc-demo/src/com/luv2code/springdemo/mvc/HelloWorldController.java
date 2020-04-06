package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	/*
	 * add a new controller method to read form data and add data to the model
	 */
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		// read the request parameter from html form
		String theName = request.getParameter("studentName");

		// convert the data to upper case
		theName = theName.toUpperCase();

		String result = "Yo " + theName;
		// create the message
		model.addAttribute("message", result);

		// add the message to the model

		return "helloworld";
	}

	/*
	 * add a new controller method to read form data and add data to the model
	 */
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName,
			Model model) {

		// convert the data to upper case
		theName = theName.toUpperCase();

		String result = "Hey my friend! " + theName;
		// create the message
		model.addAttribute("message", result);

		// add the message to the model

		return "helloworld";
	}
}
