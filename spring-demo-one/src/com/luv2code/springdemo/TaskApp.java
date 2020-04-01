package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TaskApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("myPingPongCoach", Coach.class);
		
		System.out.println(theCoach.getDailyFortune());
		
		context.close();

	}

}
