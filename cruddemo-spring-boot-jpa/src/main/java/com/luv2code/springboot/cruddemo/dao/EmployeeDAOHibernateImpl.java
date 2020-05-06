package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entitymanager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		// execute the query and get result list
		List<Employee> employees = theQuery.getResultList();

		// return the results

		return employees;
	}

	@Override
	public Employee findById(int employeeId) {

		Session currentSession = entityManager.unwrap(Session.class);

		Employee theEmployee = currentSession.get(Employee.class, employeeId);

		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {

		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theEmployee);

	}

	@Override
	public void deleteById(int employeeId) {

		Session currentSession = entityManager.unwrap(Session.class);

		Query theQuery = currentSession.createQuery("delete from Employee where id =:employeeId");
		theQuery.setParameter("employeeId", employeeId);
		theQuery.executeUpdate();

	}

}
