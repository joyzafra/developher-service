package com.acn.developher.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acn.developher.service.dao.AccountRepo;
import com.acn.developher.service.domain.Account;

@RestController
@RequestMapping(path = "/develop-her")
@CrossOrigin
public class AccountController {
	
	@Autowired
	private AccountRepo accountRepo;
	

	@GetMapping(path="/account/all", produces = "application/json")
	public List<Account> getAllAccounts() {

		List<Account> accountList = new ArrayList<Account>();
		Iterable<Account> accounts = accountRepo.findAll();
		accounts.forEach(account -> {
			accountList.add(account);
			
		});
		return accountList;
	}
	
	@PostMapping(path= "/account/add", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Account> registerAccount(@RequestBody Account account) {

		return ResponseEntity.ok(accountRepo.save(account));

	}
	
	
	

}
