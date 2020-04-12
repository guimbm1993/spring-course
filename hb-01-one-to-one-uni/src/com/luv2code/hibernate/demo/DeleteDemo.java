package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

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

			// get instructor by id
			int id = 2;
			Instructor tempInstructor = session.get(Instructor.class, id);

			if (tempInstructor != null) {
				// delete that instructor
				session.delete(tempInstructor);
			}

			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
