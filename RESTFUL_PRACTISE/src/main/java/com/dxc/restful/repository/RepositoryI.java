package com.dxc.restful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dxc.restful.entity.Employee;
@Repository
public interface RepositoryI extends JpaRepository<Employee, Integer> {

	public Employee findByEmployeeName(String employeeName);
	public List<Employee> findBySalaryGreaterThan(double salary);
	
	
	public List<Employee> findBySalaryLesserThan(double salary);
	
	public Employee findBySalary(double salary);
	
	
	@Query("select e from Employee e where e.employeeName=?1 or e.salary=?2")
	public List<Employee> findByEmployeeName(String employeeName,double salary);
	
	
}
