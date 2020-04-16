package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteCoursesDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			System.out.println("start a transaction");
			session.beginTransaction();

			//get a course
			int id = 10;
			Course tempCourse = session.get(Course.class, id);
			
			System.out.println("Deleting the course: " + tempCourse);
			
			//delete the course
			session.delete(tempCourse);
			
			// commit transaction
			session.getTransaction().commit();

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}

	}

}
