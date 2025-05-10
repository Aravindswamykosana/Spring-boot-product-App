package com.aravind.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aravind.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,String>{
//	 @Query("SELECT COUNT(e) FROM Employee e")
//	 public  long getEmployeeCount();

}
