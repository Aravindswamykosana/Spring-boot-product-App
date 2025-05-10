package aravind.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aravind.config.UserConfig;
import aravind.dto.User;
import aravind.service.UserServiceImpl;

public class UserController {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(UserConfig.class);
		UserServiceImpl userservice = context.getBean(UserServiceImpl.class);
		User user=new User(2,"swamy",23);
		userservice.save(user);
	}

}
