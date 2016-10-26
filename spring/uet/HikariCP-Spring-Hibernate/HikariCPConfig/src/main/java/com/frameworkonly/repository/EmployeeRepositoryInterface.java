package com.frameworkonly.repository;

import java.util.Collection;

import com.frameworkonly.domain.Employee;

public interface EmployeeRepositoryInterface {

	public Employee saveEmployee(Employee emp);
	public Boolean deleteEmployee(Employee emp);
	public Employee editEmployee(Employee emp);
	public Employee findEmployee(Long empId);
	public Collection<Employee> getAllEmployees();
}
