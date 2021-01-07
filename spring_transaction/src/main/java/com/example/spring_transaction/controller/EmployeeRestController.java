package com.example.spring_transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_transaction.service.EmployeeService;
import com.example.spring_transaction.vo.EmployeeRequestVO;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value = "/employee")
	public String saveEmployee(@RequestBody EmployeeRequestVO employeeRequestVO) {
		return employeeService.saveEmployee(employeeRequestVO);
	}
	
}
