package com.dxc.restful.service;

import java.util.List;

import com.dxc.restful.entity.Employee;

public interface ServiceI {

	public Employee addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public Employee getEmployee(int employeeID);
	public void deleteEmployee(int employeeID);
	
	public List<Employee> getAllEmployee();
	
	
	public List<Employee> findBySalaryGreaterThan(double salary);
	/* public List<Employee> findBySalaryLesserThan(double salary); */
	
	public Employee findByEmployeeName(String employeeName);
	public Employee findBySalary(double salary);
	public List<Employee> findByEmployeeName(String employeeName,double salary);


}
