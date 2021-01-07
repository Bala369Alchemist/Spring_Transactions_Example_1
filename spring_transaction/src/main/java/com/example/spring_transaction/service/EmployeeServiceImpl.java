package com.example.spring_transaction.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_transaction.entity.Department;
import com.example.spring_transaction.entity.Employee;
import com.example.spring_transaction.repository.DepartmentRepository;
import com.example.spring_transaction.repository.EmployeeRespository;
import com.example.spring_transaction.vo.EmployeeRequestVO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRespository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	@Transactional
	public String saveEmployee(EmployeeRequestVO employeeRequestVO) {
		
		Department department = new Department();
		department.setDepartmentName(employeeRequestVO.getDepartmentName());
		department.setDepartmentCode(employeeRequestVO.getDepartmentName());
		
		Long departmentId = departmentRepository.save(department).getDepartmentId();
		
		Employee employee = new Employee();
		employee.setEmpName(employeeRequestVO.getEmpName());
		employee.setEmail(employeeRequestVO.getEmail());
		employee.setDepartmentId(departmentId);
		
		employeeRepository.save(employee);
		
		return "employee is saved with Employee ID : "+employee.getEmployeeId();
	}

}
