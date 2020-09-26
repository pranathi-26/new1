package com.dxc.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.restful.entity.Employee;
import com.dxc.restful.repository.RepositoryI;
@Service
public class ServiceImp implements ServiceI {

	@Autowired
	 RepositoryI repo;
	
	@Autowired
	Employee emptyemp;
	
	
	
	@Override
	public Employee addEmployee(Employee employee) {
		
		return repo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		return repo.save(employee);
	}

	@Override
	public Employee getEmployee(int employeeID) {
		
		return repo.findById(employeeID).orElse(emptyemp);
	}

	@Override
	public void deleteEmployee(int employeeID) {
		
	 repo.deleteById(employeeID);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return repo.findAll();
	}

	@Override
	public List<Employee> findBySalaryGreaterThan(double salary) {
		
		return repo.findBySalaryGreaterThan(salary);
	}

	/*
	 * @Override public List<Employee> findBySalaryLesserThan(double salary) {
	 * 
	 * return repo.findBySalaryLesserThan(salary); }
	 */

	@Override
	public Employee findByEmployeeName(String employeeName) {
		
		return repo.findByEmployeeName(employeeName);
	}

	@Override
	public Employee findBySalary(double salary) {
		
		return repo.findBySalary(salary);
	}

	@Override
	public List<Employee> findByEmployeeName(String employeeName, double salary) {
		
		return repo.findByEmployeeName(employeeName, salary);
	}

}
