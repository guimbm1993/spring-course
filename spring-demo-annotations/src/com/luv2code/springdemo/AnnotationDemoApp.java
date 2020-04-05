package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		//read spring config file
		ClassPathXmlApplicationContext context = new  ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve the beans
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach coach2 = context.getBean("soccerCoach",SoccerCoach.class);
		Coach coach3 = context.getBean("karateCoach", KarateCoach.class);
		
		//call some methods
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(coach2.getDailyFortune());
		System.out.println(coach3.getDailyFortune());
		
		//close the container
		context.close();
		
	}

}
