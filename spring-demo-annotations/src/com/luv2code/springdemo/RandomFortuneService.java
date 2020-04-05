package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	//create random array
	private String [] data = {"Luck day 1","Lucky day 2","Lucky day 3"};
	
	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		
		//pick one position of array
		int index = myRandom.nextInt(data.length);
		String dailyFortune = data[index];
		
		return dailyFortune;
	}

}
