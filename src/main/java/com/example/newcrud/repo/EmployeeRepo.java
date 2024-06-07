package com.example.newcrud.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.newcrud.entity.Employee;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee,String> {

}
