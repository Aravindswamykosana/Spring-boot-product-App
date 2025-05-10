package com.aravind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.aravind.dto.User;
import com.aravind.repo.UserRepo;
import com.aravind.service.UserServiceImpl;

@SpringBootApplication
public class SpringBootIntro1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext cntxt = SpringApplication.run(SpringBootIntro1Application.class, args);
		UserServiceImpl userservice = cntxt.getBean(UserServiceImpl.class);
		UserRepo repo=cntxt.getBean(UserRepo.class);
		List<String> li = repo.allQueriesBySql();
		for(String u:li) {
			System.out.println(u);
		}
		System.out.println("**********************");
		List<Integer> li1 = repo.allQueriesByHql();
		for(Integer u:li1) {
			System.out.println(u);
		}
		
		User u=new User(3,"brahmi",70,"hitech city");
		repo.delete(u);
	}	

}
