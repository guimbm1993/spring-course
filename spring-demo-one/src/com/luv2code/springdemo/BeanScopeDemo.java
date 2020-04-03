package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//load configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//retrieve
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		//call methods
		boolean result = (theCoach == alphaCoach);
		
		System.out.println(result);
		
		System.out.println("Memory location for theCoach " + theCoach );
		
		System.out.println("Memory location for alphaCoach " + alphaCoach );
		
		//close
		context.close();
	}

}
