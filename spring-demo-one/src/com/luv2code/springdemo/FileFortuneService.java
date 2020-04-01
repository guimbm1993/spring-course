package com.luv2code.springdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileFortuneService implements FortuneService {

	@Override
	public String getFortune() {

		List<String> dailyFortuneList = new ArrayList<String>();
		
		dailyFortuneList.add("Sorte um");
		dailyFortuneList.add("Sorte dois");
		dailyFortuneList.add("Sorte três");
		
		Random random = new Random();
		
		return dailyFortuneList.get(random.nextInt(dailyFortuneList.size()));
	}

}
