package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {			
			
			//create the Student object
			System.out.println("create a student object");
			Student tempStudent = new Student("Gabriela", "Martins", "gabi@gmail.com");
			
			//start a transaction
			System.out.println("start a transaction");
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the student");
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
