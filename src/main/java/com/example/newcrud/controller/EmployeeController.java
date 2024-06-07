package com.example.newcrud.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newcrud.entity.Employee;
import com.example.newcrud.service.EmployeeService;


@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
private EmployeeService employeeService;
	
	@PostMapping(value="/addemployee")
	private String addEmployee(@RequestBody Employee employee) {
		employeeService.saveOrUpdate(employee);
		return employee.getId();
		
	}
	@GetMapping(value= "/getAll")
	public List<Employee> getEmployee(){
		return employeeService.getAll();
	}

	
	@RequestMapping("/getById/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable(name="id")String id){
		return employeeService.getById(id);
	}	
	
	@PutMapping("/editById/{id}")
	public Employee updateById(@RequestBody Employee employee, @PathVariable(name="id") String id){
		employee.setId(id);
		employeeService.saveOrUpdate(employee);
		return employee;
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable(name="id") String id) {
		employeeService.deleteById(id);
		return id;
	}


	
}

	


