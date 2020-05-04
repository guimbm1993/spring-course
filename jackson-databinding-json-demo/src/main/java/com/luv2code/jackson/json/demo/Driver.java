package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read json file and map/convert to Java POJO data/sample-lite.json
			Student myStudent = mapper.readValue(new File("data/sample-lite.json"), Student.class);
			
			//print first, last active and id
			System.out.println(myStudent.getId());
			System.out.println(myStudent.getFirstName());
			System.out.println(myStudent.getLastName());
			System.out.println(myStudent.isActive());
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
