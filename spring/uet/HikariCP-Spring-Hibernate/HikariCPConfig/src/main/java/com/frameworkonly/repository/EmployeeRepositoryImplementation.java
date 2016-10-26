package com.frameworkonly.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.frameworkonly.domain.Employee;

@Repository
public class EmployeeRepositoryImplementation implements EmployeeRepositoryInterface{

	protected EntityManager entityManager;

	public EmployeeRepositoryImplementation() {
		// TODO Auto-generated constructor stub

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext(unitName="EmployeeContext")
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		entityManager.persist(emp);
		entityManager.flush();
		return emp;
	}

	@Override
	public Boolean deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
		try {
		     entityManager.remove(emp);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public Employee editEmployee(Employee emp) {
		// TODO Auto-generated method stub
		try{
		   return entityManager.merge(emp);
		} catch(Exception ex) {
			return null;
		}
	}

	@Override
	public Collection<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e", Employee.class);
		return query.getResultList();
	}

	@Override
	public Employee findEmployee(Long empId) {
		// TODO Auto-generated method stub
		return entityManager.find(Employee.class, empId);
	}

	
}
