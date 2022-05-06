package com.dailycodebuffer.Springboot.tutorial.service;

import com.dailycodebuffer.Springboot.tutorial.entity.Employee;
import com.dailycodebuffer.Springboot.tutorial.error.EmployeeNotFoundException;

public interface EmployeeService {
	public Employee saveEmployee(Employee employee);
	public Employee featchById(Long employeeId) throws EmployeeNotFoundException;
	

}
