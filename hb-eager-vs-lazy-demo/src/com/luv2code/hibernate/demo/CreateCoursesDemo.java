package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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

			Instructor tempInstructor = session.get(Instructor.class, id);

			if (tempInstructor != null) {

				// create some courses
				Course tempCourse1 = new Course("Spring");
				Course tempCourse2 = new Course("Mongo");
				Course tempCourse3 = new Course("Kubernetes");

				// add courses to instructor
				tempInstructor.add(tempCourse1);
				tempInstructor.add(tempCourse2);
				tempInstructor.add(tempCourse3);

				// save the courses
				session.save(tempCourse1);
				session.save(tempCourse2);
				session.save(tempCourse3);
			}

			// commit transaction
			session.getTransaction().commit();

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}

	}

}
