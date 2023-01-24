package com.nt.model;

import lombok.Data;

@Data
public class Employee {
   Integer empno;
   String ename;
   String desg;
   Double salary;
   Double netSalary;
   double grossSalary;
public Integer getEmpno() {
	return empno;
}
public void setEmpno(Integer empno) {
	this.empno = empno;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getDesg() {
	return desg;
}
public void setDesg(String desg) {
	this.desg = desg;
}
public Double getSalary() {
	return salary;
}
public void setSalary(Double salary) {
	this.salary = salary;
}
public Double getNetSalary() {
	return netSalary;
}
public void setNetSalary(Double netSalary) {
	this.netSalary = netSalary;
}
public double getGrossSalary() {
	return grossSalary;
}
public void setGrossSalary(double grossSalary) {
	this.grossSalary = grossSalary;
}
   
}
