package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		//load spring config
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieeve bean
		Coach theCoach = context.getBean("tennisCoach", TennisCoach.class);
		

		//call method
		
		System.out.println(theCoach);
		//close context
		context.close();
	}

}
