package com.aravind;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.aravind.entity.Employee;
import com.aravind.repo.EmployeeRepo1;

@SpringBootApplication
public class SpringBootDataJpa2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext	cntxt=SpringApplication.run(SpringBootDataJpa2Application.class, args);
		EmployeeRepo1 repo = cntxt.getBean(EmployeeRepo1.class);
		Employee e=new Employee();
		e.setId(2);
		e.setEmpGender("mawdle");
		e.setEmpName("arvind");
		e.setDept("softeware");
		e.setEmpSalary(60000.0);
		repo.save(e);
		System.out.println("record inserted..!");
		
		
//		List<Employee>li=repo.findAll();
//		//li.forEach(System.out::println);
//		
//		System.out.println("record fetched..!");
//		
////		Sort sort = Sort.by("empSalary","empName").descending();
////		List<Employee> descen = repo.findAll(sort);
////		descen.forEach(System.out::println);
//		
//		Employee e=new Employee();
//		//e.setEmpName("arvind");
//		e.setEmpGender("female");
//		Example<Employee> ex = Example.of(e);
//		List<Employee> empoo = repo.findAll(ex);
//		empoo.forEach(System.out::println);
//		int page_No=20;
//		PageRequest page = PageRequest.of(page_No-1, 2);
//		
//		 Page<Employee> emps = repo.findAll(page);
//		emps.forEach(System.out::println);
		
	}

}
