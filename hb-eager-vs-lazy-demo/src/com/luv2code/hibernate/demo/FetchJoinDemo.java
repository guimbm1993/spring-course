package com.luv2code.hibernate.demo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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

			// get the instructor from db
			int id = 1;

			Query<Instructor> query = session.createQuery(
					"select i from Instructor i  " + "Join Fetch i.courses " + "where i.id=:theInstructorId",
					Instructor.class);
			
			query.setParameter("theInstructorId", id);
			Instructor tempInstructor = query.getSingleResult();
			System.out.println("Instructor : " + tempInstructor);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("session is closed");

			session.close();
			System.out.println("Courses of instructor: " + tempInstructor.getCourses());

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}

	}

}
