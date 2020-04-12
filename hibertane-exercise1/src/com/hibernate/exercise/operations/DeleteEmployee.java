package com.hibernate.exercise.operations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.exercise.entity.Employee;

public class DeleteEmployee {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//begin transaction
			session.beginTransaction();
			
			int id =3;
			
			Employee tempEmployee = session.get(Employee.class, id);
			
			session.delete(tempEmployee);
			
			
			//commit
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
