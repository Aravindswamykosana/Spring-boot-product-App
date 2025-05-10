package com.aravind.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aravind.dto.User;
import com.aravind.repo.UserRepo;
@Repository
public class UserDaoImpl implements UserDao{

	public UserDaoImpl() {
		System.out.println("from user dao imple constructor...!");
	}

	@Autowired
	private UserRepo repo;
	@Override
	public void save(User user) {
		repo.save(user);
	}

}
