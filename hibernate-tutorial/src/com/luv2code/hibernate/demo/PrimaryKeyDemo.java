package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		//create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
				//create a session
				Session session = factory.getCurrentSession();
				
				try {			
					
					//create 3 Student objects
					System.out.println("create 3 student object");
					Student tempStudent1 = new Student("Gabriela", "Martins", "gabi@gmail.com");
					Student tempStudent2 = new Student("Joao", "Maria", "joao@gmail.com");
					Student tempStudent3 = new Student("Maria", "Rodrigues", "gabi@gmail.com");
					
					//start a transaction
					System.out.println("start a transaction");
					session.beginTransaction();
					
					//save the student object
					System.out.println("saving the student");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					//commit transaction
					session.getTransaction().commit();
					
				}finally {
					factory.close();
				}


	}

}
