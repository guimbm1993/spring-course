package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//constructor inject dependency
	
	@Autowired
	public TennisCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	//define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TennisCoach inside of doMyStartupStuff");
	}
	
	//define my destroy method
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println("TennisCoach inside of doMyCleanUpStuff");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
