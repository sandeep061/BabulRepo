package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;
  @Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeManagementService {
       @Autowired
      
	  private IEmployeeDAO empDAO;
       public EmployeeMgmtServiceImpl() {
		System.out.println("EmployeeMgmtServiceImpl 0 param constructer");
	}
	@Override
	public String registerEmployee(Employee emp) throws Exception {
		 //calculate grossSalary
       double grossSalary=emp.getSalary()+(emp.getSalary()*0.4f);
       double netSalary=grossSalary-(grossSalary*0.2f);
       //set the gross salary,net Salary in emp object
       emp.setGrossSalary(grossSalary);
       emp.setNetSalary(netSalary);
       int count=empDAO.insert(emp);
     System.out.println(count);
		return count==0?"Employee registration fail":"Employee registration success salary=="+emp.getSalary()+ "Emp gross salary------>"+emp.getGrossSalary()+"emp net sal---------->"+emp.getNetSalary();
	}

}
