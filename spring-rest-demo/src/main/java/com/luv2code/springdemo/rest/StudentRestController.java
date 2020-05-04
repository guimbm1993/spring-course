package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@GetMapping("/students")
	public List<Student> getStudents() {

		List<Student> response = new ArrayList<Student>();

		response.add(new Student("Mario", "Rossi"));
		response.add(new Student("Madhu", "Kajar"));
		response.add(new Student("Mary", "Public"));

		return response;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		List<Student> response = new ArrayList<Student>();

		response.add(new Student("Mario", "Rossi"));
		response.add(new Student("Madhu", "Kajar"));
		response.add(new Student("Mary", "Public"));

		if ((studentId >= response.size()) || studentId < 0) {
			throw new StudentNotFoundException("Student id not found: " + studentId);
		}

		return response.get(studentId);
	}

}
