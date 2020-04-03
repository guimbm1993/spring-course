package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k" ;
	}

	@Override
	public String getRepsNumber() {
		// TODO Auto-generated method stub
		return "make it 2 times";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just do it: " +fortuneService.getFortune();
	}
	
	//add an init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach inside the method doMyStartupStuff");
	}
	
	//add a destroy method
	public void doMyDestroyStuff() {
		System.out.println("TrackCoach inside the method doMyDestroyStuff");
	}
}
