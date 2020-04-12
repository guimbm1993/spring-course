package com.hibernate.exercise.operations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.exercise.entity.Employee;

public class ReadEmployee {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//begin transaction
			session.beginTransaction();
			
			List<Employee> employeeList = session.createQuery("from Employee").getResultList();
			
			for(Employee e : employeeList) {
				System.out.println(e);
			}
			
			//commit
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
