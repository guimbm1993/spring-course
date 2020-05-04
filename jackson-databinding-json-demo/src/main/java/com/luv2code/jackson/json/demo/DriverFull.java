package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DriverFull {

	public static void main(String[] args) {
		
		try {
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read json file and map/convert to Java POJO data/sample-lite.json
			Student myStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			//print first, last active and id
			System.out.println(myStudent.getId());
			System.out.println(myStudent.getFirstName());
			System.out.println(myStudent.getLastName());
			System.out.println(myStudent.isActive());
			
			//print out the address
			Address tempAddress = myStudent.getAddress();
			System.out.println(tempAddress.getStreet());
			System.out.println(tempAddress.getCity());
			
			for(String aux: myStudent.getLanguages()) {
				System.out.println(aux);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
