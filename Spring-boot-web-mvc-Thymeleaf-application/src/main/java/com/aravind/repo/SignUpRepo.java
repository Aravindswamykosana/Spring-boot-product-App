package com.aravind.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aravind.model.SignUp;

public interface SignUpRepo extends JpaRepository<SignUp, Integer>{
	public SignUp findByEmailAndPwd(String email, String pwd);
	public SignUp findByEmail(String email);
}
