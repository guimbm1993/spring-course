package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		Query theQuery = entityManager.createQuery("from Employee");
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int employeeId) {
		Employee theEmployee = entityManager.find(Employee.class, employeeId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		Employee dbEmployee = entityManager.merge(theEmployee);
		theEmployee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteById(int employeeId) {

		Employee theEmployee = entityManager.find(Employee.class, employeeId);
		if(theEmployee != null) {
			entityManager.remove(theEmployee);
		}
		
	}

}
