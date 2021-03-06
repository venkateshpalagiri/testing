package com.dailycodebuffer.Springboot.tutorial.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.Springboot.tutorial.entity.Employee;
import com.dailycodebuffer.Springboot.tutorial.error.EmployeeNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.service.EmployeeService;


@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	private final Logger LOGGER=LogManager.getLogger(EmployeeController.class);
	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		LOGGER.info("this is postmapping venky");
		return employeeService.saveEmployee(employee);
	}
	@GetMapping("/employee/{id}")
	public Employee featchById(@PathVariable("id") Long employeeId) throws EmployeeNotFoundException{
		LOGGER.info("this is get mapping ");
		return employeeService.featchById(employeeId);
	}

}
