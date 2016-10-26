package com.frameworkonly.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frameworkonly.domain.Employee;
import com.frameworkonly.repository.EmployeeRepositoryInterface;

@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeServiceInterface{

	@Autowired
	protected EmployeeRepositoryInterface employeeRepositoryInterface;

	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepositoryInterface.saveEmployee(emp);
	}

	@Override
	public Boolean deleteEmployee(Long empId) {
		// TODO Auto-generated method stub
		Employee temp = employeeRepositoryInterface.findEmployee(empId);
		if(temp!=null){
			return employeeRepositoryInterface.deleteEmployee(temp);
		}
		return false;
	}

	@Override
	public Employee editEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepositoryInterface.editEmployee(emp);
	}

	@Override
	public Collection<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepositoryInterface.getAllEmployees();
	}

	@Override
	public Employee findEmployee(Long empId) {
		// TODO Auto-generated method stub
		return employeeRepositoryInterface.findEmployee(empId);
	}
	

}
