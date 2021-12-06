package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Result;
import com.example.demo.model.Account;
import com.example.demo.repo.AccountRepo;

@Service(value="AccountService")
public class AccountService {
	
	@Autowired
	AccountRepo accountRepo;
	
	public List<Account> getAllAccounts(){
		List<Account> list = new ArrayList<>();
		accountRepo.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
	public List<Result> getResult(){
		List<Result> list = new ArrayList<>();
		return list;
	}

}
