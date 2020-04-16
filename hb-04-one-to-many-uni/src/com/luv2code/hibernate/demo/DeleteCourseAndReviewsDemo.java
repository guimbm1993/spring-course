package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			System.out.println("start a transaction");
			session.beginTransaction();
			
			//get the course
			int theId = 11;
			Course tempCourse = session.get(Course.class, theId);
			
			//print the course
			if(tempCourse != null) {
				session.delete(tempCourse);
			}
			
			//print the course reviews

			// commit transaction
			session.getTransaction().commit();
			System.out.println("done");

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}

	}

}
