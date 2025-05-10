package com.aravind.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aravind.entity.Employee;

public interface EmployeeRepo1 extends JpaRepository<Employee, Integer>{

}
