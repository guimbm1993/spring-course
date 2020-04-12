package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			System.out.println("start a transaction");
			session.beginTransaction();

			int id = 10;
			// get instructor detail object
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, id);

			if (tempInstructorDetail != null) {
				// print instructor detail
				System.out.println("Instructor detail : " + tempInstructorDetail);

				// print the associated instructor object
				System.out.println("Instructor associated obejct: " + tempInstructorDetail.getInstructor());
			}
			// commit transaction
			session.getTransaction().commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// handle connection leak
			session.close();
			factory.close();
		}

	}

}
