package com.nt;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.PayRollOperationControl;
import com.nt.model.Employee;

@SpringBootApplication
//(exclude = {DataSourceAutoConfiguration.class,JdbcTemplateAutoConfiguration.class})
//@ImportResource("com/nt/cfgs/applicationContext.xml")
public class BootProj03LayeredAppRealtimeDiApplication {
	@Autowired
	  private Environment env;
	  
	  @Bean("c3p0Ds")
	  @Profile("test")
	  public ComboPooledDataSource createC3P0DS()throws Exception {
		  //sandeeep
		  System.out.println("BootProj03LayeredAppRealtimeDiApplication.createC3P0DS()");
		 ComboPooledDataSource cds=new ComboPooledDataSource();
		 cds.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
		 cds.setJdbcUrl(env.getProperty("spring.datasource.url"));
		 cds.setUser(env.getProperty("spring.datasource.username"));
		 cds.setPassword(env.getProperty("spring.datasource.password"));
		 cds.setMinPoolSize(Integer.parseInt(env.getProperty("c3P0.minSize")));
		 cds.setMaxPoolSize(Integer.parseInt(env.getProperty("c3P0.maxSize")));
		  return cds;
	  }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Emp name:");
		String sname=sc.next();
		System.out.println("Enter emp desg");
		String desg=sc.next();
		System.out.println("Enter salary");
		double salary=sc.nextDouble();
		 
		//create the emp class object
		
		Employee emp=new Employee();
		emp.setEname(sname);
		emp.setDesg(desg);
		emp.setSalary(salary);
		
		
		ApplicationContext ctx= SpringApplication.run(BootProj03LayeredAppRealtimeDiApplication.class, args);
		  PayRollOperationControl control=ctx.getBean("payrollControler",PayRollOperationControl.class);
		  //invoke the business method
		  try {
		  String result=control.processEmployee(emp);
		  System.out.println(result);
	}
		  catch(Exception e) {
			  e.printStackTrace();
			  System.out.println("Some internal problem:"+e.getMessage());
		  }
		  ((ConfigurableApplicationContext) ctx).close();
	}
}
