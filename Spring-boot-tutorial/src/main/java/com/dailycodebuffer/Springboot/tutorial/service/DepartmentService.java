package com.dailycodebuffer.Springboot.tutorial.service;

import java.util.List;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;

public interface DepartmentService {
	public Department saveDepartment(Department department);
	public List<Department> featchDepartmentList();
	public Department featchDepartmentById(Long departmenId)throws DepartmentNotFoundException;
	public Department featchDepartmentByName(String departmentName);
	public Department featchDepartmentByCode(String departmentCode);
	public Department updateDepartment(Long departmentId,Department department);
	public Department updateDepartmentByCode(String departmentCode,Department department);
	public Department updateDepartmentByName(String departmentName,Department department);
	public void deleteDepartmentById(Long departmentId);
	public void deleteDepartmentByName(String departmentName);

}
