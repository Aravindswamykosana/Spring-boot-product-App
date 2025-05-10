package com.aravind.repo;

import org.springframework.data.repository.CrudRepository;

import com.aravind.model.Account;
import com.aravind.model.AccountPK;

public interface AccountRepo extends CrudRepository<Account, AccountPK>{

}
