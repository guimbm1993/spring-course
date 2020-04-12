package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {			
			

			//create the objects
			Instructor tempInstructor = 
					new Instructor("Susan","Publican", "susan@gmail.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail("http://susan/youtube", "play games");
			
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
			//add clean up code
			session.close();
			factory.close();
		}

	}

}
