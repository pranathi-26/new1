package com.dxc.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.restful.entity.Employee;
import com.dxc.restful.service.ServiceI;
import com.dxc.restful.service.ServiceImp;
@Controller
@RestController
@RequestMapping(path="/emp")
public class EmployeeController {

	
	
	
	@Autowired
	Employee employee;
	@Autowired
	ServiceI service;
	
	
	@GetMapping(path="/get/{id}",produces= {"apllication/json","application/xml"})
	public Employee get(@PathVariable("id") int employeeID) {
		
		
		return service.getEmployee(employeeID);
	}
	
	@GetMapping(path="/employees")
	public List<Employee> getAllEmployee(){
		
		return service.getAllEmployee();
	}
	
	@PostMapping(path="/update",consumes= {"application/xml","application/json"},produces = { "application/xml","application/json" })
	public Employee update(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}
	@DeleteMapping(path="/delete/{id}")
	public String delete(@PathVariable("id") int employeeID) {
		service.deleteEmployee(employeeID);
		return "Employee deleted with employeeID"+employeeID;
	}
	
	@GetMapping(path="/findname/{employeeName}")
	public Employee findByEmployeeName(@PathVariable("employeeName") String employeeName) {
		return service.findByEmployeeName(employeeName);
	}
	@GetMapping(path = "/gtsalary/{salary}")
	public List<Employee> findByEmployeeGreaterThan(@PathVariable("salary") double salary){
		return service.findBySalaryGreaterThan(salary);
	}
	

	/*
	 * @GetMapping(path = "/ltsalary/{salary}") public List<Employee>
	 * findByEmployeeLesserThan(@PathVariable("salary") double salary){ return
	 * service.findBySalaryLesserThan(salary); }
	 */
	@GetMapping("/get/{employeeName}/{salary}")
	public List<Employee> getByEmployeeName(@PathVariable("employeeName") String employeeName,@PathVariable("salary") double salary){
		return service.findByEmployeeName(employeeName, salary);
	}
	
}
