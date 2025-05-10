package aravind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aravind.dao.UserDao;
import aravind.dto.User;

@Service
public class UserServiceImpl implements UserService{

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private UserDao dao;
	@Override
	public void save(User user) {
		dao.save(user);
		System.out.println("data saved succesfully..!");
	}

}
