package com.aravind;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.aravind.model.Account;
import com.aravind.model.AccountPK;
import com.aravind.model.Employee;
import com.aravind.repo.AccountRepo;
import com.aravind.repo.EmployeeRepo;

@SpringBootApplication
public class SpringBootDataJpa3Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext cntxt = SpringApplication.run(SpringBootDataJpa3Application.class, args);
		
		EmployeeRepo repo=cntxt.getBean(EmployeeRepo.class);
		Employee emp=new Employee();
		emp.setName("hihhihi..!");
		repo.save(emp);
		System.out.println("record is inserted...!");
		
		//AccountRepo bean = cntxt.getBean(AccountRepo.class);
//		AccountPK pk=new AccountPK();
//		pk.setAccNum(8610100017095l);
//		pk.setAccType("savings");
//		
//		Account acc =new Account();
//		acc.setBranchName("karapa");
//		acc.setHolderName("Aravind");
//		acc.setAccountPK(pk);
//		
//		bean.save(acc);
//		System.out.println("record is inserted...!");
		
//		AccountPK pk=new AccountPK();
//		pk.setAccNum(8610100017095l);
//		pk.setAccType("savings");
//		Optional<Account> res = bean.findById(pk);
//		if(res.isPresent()) {
//			System.out.println(res.get());
//		}
	}

}
