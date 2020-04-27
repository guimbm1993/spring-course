package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	public static void main(String[] args) {

		// read Spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring context
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\n Main program: AroundDemoApp");
		
		System.out.println("Calling getFortune");
		
		boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire);
		
		System.out.println("\n My fortune is: " + data);
		
		System.out.println("finished");

		// close the context
		context.close();

	}

}
