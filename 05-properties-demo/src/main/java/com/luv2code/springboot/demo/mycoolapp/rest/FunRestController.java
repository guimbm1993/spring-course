package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;

	@GetMapping("/")
	public String helloWorld() {
		return "Hello World time on server: " + LocalDateTime.now();
	}
	
	//expose a new endpoint for workout
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5KM";
	}
	
	@GetMapping("/team")
	public String getTeam() {
		return "Coach name: "+ coachName + " \n Team name: " + teamName;
	}
	
}
