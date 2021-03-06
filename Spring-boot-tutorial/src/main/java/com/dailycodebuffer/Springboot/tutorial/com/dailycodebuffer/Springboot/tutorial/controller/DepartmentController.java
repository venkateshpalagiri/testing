package com.dailycodebuffer.Springboot.tutorial.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	private final Logger LOGGER=LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/department")
	public Department saveDepartment(@RequestBody Department department) {
		LOGGER.info("ENTERED INTO POSTMAPPING");
		return departmentService.saveDepartment(department);
		
	}
	@GetMapping("/department")
	public List<Department> featchDepartmentList(){
		return departmentService.featchDepartmentList();
	}
	@GetMapping("/department/{id}")
	public Department featchDepartmentById(@PathVariable("id") Long departmentId)
	throws DepartmentNotFoundException{
		LOGGER.debug("ENTERED INTO GETMAPPING AND ITS A DEBUG MODE");
		return departmentService.featchDepartmentById(departmentId);
	}
	@GetMapping("/{name}")
	public Department featchDepartmentByName(@PathVariable("name") String departmentName) {
		return departmentService.featchDepartmentByName(departmentName);
	}
	@GetMapping("/department/code/{code}")
	public Department featchDepartmentByCode(@PathVariable("code") String departmentCode) {
		return departmentService.featchDepartmentByCode(departmentCode);
	}
	@PutMapping("/department/update/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		return departmentService.updateDepartment(departmentId,department);
	}
	@PutMapping("/update/{name}")
	public Department updateDepartmentByCode(@PathVariable("name")String departmentCode, @RequestBody Department department) {
		return departmentService.updateDepartmentByCode(departmentCode,department);
	}
	@PutMapping("/updateByName/{byName}")
	public Department updateDepartmentByName(@PathVariable("byName")String departmentName,@RequestBody Department department) {
		return departmentService.updateDepartmentByName(departmentName,department);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteDepartmentById(@PathVariable("id")Long departmentId) {
		Department dbc=featchDepartmentById(departmentId);
		departmentService.deleteDepartmentById(departmentId);
		return "deleted ="+dbc.getDepartmentAddress();
	}
	@DeleteMapping("/delete/byName/{name}")
	public String deleteDepartmentByName(@PathVariable("name")String departmentName) {
		departmentService.deleteDepartmentByName(departmentName);
		return "deleted by Venkatesh";
	}
	

	
}
