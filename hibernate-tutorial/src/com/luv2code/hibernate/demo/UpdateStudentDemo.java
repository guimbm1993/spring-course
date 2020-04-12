package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 3;

			// now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve the student based on id
			System.out.println("Getting student with id: " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			System.out.println("Updating student ");
			myStudent.setFirstName("Scooby");

			// commit the transaction
			session.getTransaction().commit();

			// new code
			session = factory.getCurrentSession();
			session.beginTransaction();

			// update all e-mails
			session.createQuery("Update Student set email= 'foo@outlook.com'").executeUpdate();

			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			factory.close();
		}

	}

}
