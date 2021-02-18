package com.naga.demo.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDao {

	@Autowired
	EmployeeRepo employeeRepo;

	public Iterable<tblEmployee> getEmployee() {
		
		return employeeRepo.findAll();
	} 
	
	
}
