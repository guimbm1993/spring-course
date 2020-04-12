package com.hibernate.exercise.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.exercise.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Employee e1 = new Employee("Guilherme", "Moraes", "B2W");
			Employee e2 = new Employee("Gabriela", "Martins", "Fius");
			Employee e3 = new Employee("Adriano", "Moraes", "GM");
			
			//begin transaction
			session.beginTransaction();
			
			session.save(e1);
			session.save(e2);
			session.save(e3);
			
			//commit
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
