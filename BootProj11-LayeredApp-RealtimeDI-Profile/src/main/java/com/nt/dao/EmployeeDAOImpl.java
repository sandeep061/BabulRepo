package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;
  @Repository("empDAO")
  @Profile({"uat","prod"})
public class EmployeeDAOImpl implements IEmployeeDAO {
	  public EmployeeDAOImpl() {
		System.out.println("EmployeeDAOImpl 0-param constructer-ORACLE");
	}
   public static final String Insert_Emp="INSERT INTO EMPLOYEE_INFO VALUES(EID_SEQ1.NEXTVAL,?,?,?,?,?)";
    int count=0;
   @Autowired
   private DataSource ds;
	@Override
	public int insert(Employee emp) throws Exception {
		// int count=0;
		System.out.println("data source class name::"+ds.getClass());
		 try(Connection con=ds.getConnection();
				 //create prepareStatement
				 PreparedStatement ps=con.prepareStatement(Insert_Emp);
				 ){
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getDesg());
			ps.setDouble(3, emp.getSalary());
			ps.setDouble(4, emp.getGrossSalary());
			ps.setDouble(5, emp.getNetSalary()); 
			
			//execute the query
		 count=	ps.executeUpdate();
			
		 }//try
		 
		 catch (SQLException se) {
			se.printStackTrace();
			throw se;
		}
		 catch (Exception e) {
		e.printStackTrace();
		throw e;
		}
		return count;
	}

}
