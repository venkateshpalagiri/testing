package com.dailycodebuffer.Springboot.tutorial.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.Springboot.tutorial.entity.Employee;
import com.dailycodebuffer.Springboot.tutorial.error.EmployeeNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	@Override
	public Employee featchById(Long employeeId) throws EmployeeNotFoundException{
		Optional<Employee> emp= employeeRepository.findById(employeeId);
		if(!emp.isPresent()) {
			throw new EmployeeNotFoundException("Employ not found");
		}
		return emp.get();
	}

}
