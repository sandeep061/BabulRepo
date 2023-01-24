package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.EmployeeMgmtServiceImpl;
import com.nt.service.IEmployeeManagementService;

@Controller("payrollControler")
public class PayRollOperationControl {
	@Autowired
  private IEmployeeManagementService empService;
	
	  //invoke the business method
	public String processEmployee(Employee emp) throws Exception{
		String result=empService.registerEmployee(emp);
		return result;
	}
}
