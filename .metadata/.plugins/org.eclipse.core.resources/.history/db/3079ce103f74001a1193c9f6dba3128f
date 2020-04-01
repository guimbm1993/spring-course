package com.luv2code.springdemo;

public class PingPongCoach implements Coach {

	// private field for the dependency
	private FortuneService fortuneService;

	// define a constructor for dependency injection
	public PingPongCoach(FortuneService theFortuneService) {
		// TODO Auto-generated constructor stub
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "25 aces";
	}

	@Override
	public String getRepsNumber() {
		// TODO Auto-generated method stub
		return "make it 10 times";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
