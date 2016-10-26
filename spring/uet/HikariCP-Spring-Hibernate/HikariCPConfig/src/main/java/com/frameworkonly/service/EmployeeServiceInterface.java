package com.frameworkonly.service;

import java.util.Collection;

import com.frameworkonly.domain.Employee;

public interface EmployeeServiceInterface {

	public Employee saveEmployee(Employee emp);
	public Boolean deleteEmployee(Long empId);
	public Employee editEmployee(Employee emp);
	public Employee findEmployee(Long empId);
	public Collection<Employee> getAllEmployees();
}
