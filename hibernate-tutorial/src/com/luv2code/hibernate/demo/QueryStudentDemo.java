package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {			
			//start a transaction
			System.out.println("start a transaction");
			session.beginTransaction();
			
			//query students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			//display the students
			displayStudents(theStudents);
			
			//query students: lastName = 'Moraes'
			theStudents = session.createQuery("from Student s where s.lastName = 'Moraes' ").list();
			
			//display the students
			displayStudents(theStudents);
			
			//query students last name = 'Moraes' or first name = 'Gabriela'
			theStudents = session.createQuery("from Student s where s.lastName = 'Moraes'"
					+ " or s.firstName='Gabriela'").list();
			
			displayStudents(theStudents);
			
			//query students that have @gmail on email
			theStudents = session.createQuery("from Student s where"
					+ " s.email like '%gmail%'").list();
			displayStudents(theStudents);
			
			
			//commit transaction
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}
