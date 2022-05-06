package com.dailycodebuffer.Springboot.tutorial.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.Springboot.tutorial.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
		
	}
	@Override
	public List<Department> featchDepartmentList(){
		return departmentRepository.findAll();
	}
	@Override
	public Department featchDepartmentById(Long departmenId)throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Department> byId= departmentRepository.findById(departmenId);
		if(!byId.isPresent()) {
			throw new DepartmentNotFoundException("The one your lokking for not found");
		}
		return byId.get();
	}
	@Override
	public Department featchDepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentName(departmentName);
	}
	@Override
	public Department featchDepartmentByCode(String departmentCode) {
		return departmentRepository.findByDepartmentCode(departmentCode);
	}
	@Override
	public Department updateDepartment(Long departmentId,Department department) {
		Department dp=departmentRepository.findById(departmentId).get();
		if(Objects.nonNull(department.getDepartmentName())&& !"".equalsIgnoreCase(department.getDepartmentName())){
			dp.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(department.getDepartmentAddress())&&!"".equalsIgnoreCase(department.getDepartmentAddress())){
			dp.setDepartmentAddress(department.getDepartmentAddress());
		}
		if(Objects.nonNull(department.getDepartmentCode())&&!"".equalsIgnoreCase(department.getDepartmentCode())){
			dp.setDepartmentCode(department.getDepartmentCode());
		}
		return departmentRepository.save(dp);
	}
	@Override
	public Department updateDepartmentByCode(String departmentCode,Department department) {
		Department dpc=departmentRepository.findByDepartmentCode(departmentCode);
		System.out.println(dpc.getDepartmentAddress());
		if(Objects.nonNull(department.getDepartmentName())&&!"".equalsIgnoreCase(department.getDepartmentName())) {
			dpc.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(department.getDepartmentAddress())&&!"".equalsIgnoreCase(department.getDepartmentAddress())) {
			dpc.setDepartmentAddress(department.getDepartmentAddress());
		}
		if(Objects.nonNull(department.getDepartmentCode())&&!"".equalsIgnoreCase(department.getDepartmentCode())) {
			dpc.setDepartmentCode(department.getDepartmentCode());
		}
		return departmentRepository.save(dpc);
	}
	@Override
	public Department updateDepartmentByName(String departmentName,Department department) {
		Department dp=departmentRepository.findByDepartmentName(departmentName);
		dp.setDepartmentAddress(department.getDepartmentAddress());
		dp.setDepartmentName(department.getDepartmentName());
		dp.setDepartmentCode(department.getDepartmentCode());
		return departmentRepository.save(dp);
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
	}
	@Override
	public void deleteDepartmentByName(String departmentName) {
		departmentRepository.deleteAll();
		
	}
}
