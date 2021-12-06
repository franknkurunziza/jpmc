package com.example.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Account;

public interface AccountRepo extends CrudRepository<Account, Long> {
	
	public List<Account> findByAccountNumber(String accountNumber);

}
