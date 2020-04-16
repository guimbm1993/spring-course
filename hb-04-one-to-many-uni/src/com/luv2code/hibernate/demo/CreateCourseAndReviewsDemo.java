package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

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

			// create a course
			Course tempCourse = new Course("Spring - the inicial course");

			// add some reviews
			tempCourse.addReview(new Review("Great course"));
			tempCourse.addReview(new Review("wonderfull course"));
			tempCourse.addReview(new Review("i don't like it so much"));

			// save the course and leverage the cascade all
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);

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
