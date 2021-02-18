package com.naga.demo.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao;
	
//first API
	@GetMapping("/employee")
	public Iterable<tblEmployee> getEmployee()
	{
		return employeeDao.getEmployee();
	}
}
