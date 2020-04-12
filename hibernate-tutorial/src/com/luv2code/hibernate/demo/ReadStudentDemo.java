package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {			
			
			//create the Student object
			System.out.println("create a student object");
			Student tempStudent = new Student("Guilherme", "Moraes", "guimbm@gmail.com");
			
			//start a transaction
			System.out.println("start a transaction");
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			//NEW CODE
			
			//find out the student's id: primary key
			System.out.println("Saved student generated id: " + tempStudent.getId());
			
			//now get  a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve the student based on id 
			System.out.println("Getting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: " + myStudent);
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
			
			
			
		}finally {
			factory.close();
		}

	}

}
