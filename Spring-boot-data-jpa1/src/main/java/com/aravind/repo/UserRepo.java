package com.aravind.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.aravind.dto.User;

public interface UserRepo extends CrudRepository<User, Integer>{
	
//	public List<User> findByAgeGreaterThan(int age);
//	public List<User> findByAgeLessThan(int age);
	
	@Query(value = "select name from User where age>=24",nativeQuery = true)
	public List<String> allQueriesBySql();
	
	@Query(value = "select age from User where age>=24")
	public List<Integer> allQueriesByHql();
}
