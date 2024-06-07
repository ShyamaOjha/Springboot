package com.example.newcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.newcrud.entity.Employee;
import com.example.newcrud.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	public void saveOrUpdate(Employee employee) {
	employeeRepo.save(employee);
		
	}
	
	public List<Employee> getAll(){
		return employeeRepo.findAll();
	}

	public Optional<Employee> getById(String id) {
		return employeeRepo.findById(id);

	}
	public String deleteById(String id) {
		employeeRepo.deleteById(id);
		return id;
	}




}
