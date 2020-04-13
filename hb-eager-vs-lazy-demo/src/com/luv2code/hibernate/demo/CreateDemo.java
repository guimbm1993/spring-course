package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {			
			
//			//create the objects
//			Instructor tempInstructor = 
//					new Instructor("Guilherme","Moraes", "guimbm@gmail.com");
//			
//			InstructorDetail tempInstructorDetail =
//					new InstructorDetail("http://codingwithgui/youtube", "code");
//			
			//create the objects
			Instructor tempInstructor = 
					new Instructor("Madhu","Patel", "madhu@gmail.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail("http://madhu/youtube", "play guitar");
			
			
			
			//associate the objects

			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction
			System.out.println("start a transaction");
			session.beginTransaction();

			//save the instructor
			//this also save the intructor detail object
			//because of cascade type.all
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			//commit transaction
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
