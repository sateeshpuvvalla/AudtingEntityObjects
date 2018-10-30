package com.audting.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audting.model.Account;
import com.audting.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/account")
@Slf4j
@Transactional
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/save")
	public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
		return ResponseEntity.ok().body(this.accountService.save(account));
	}

	@PutMapping("/update")
	public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
		return ResponseEntity.ok().body(this.accountService.update(account));
	}

	@DeleteMapping("/{accountId}")
	public ResponseEntity<Boolean> deleteAccount(@PathVariable Long accountId) {
		this.accountService.deleteAccountById(accountId);
		return ResponseEntity.ok().body(true);
	}

	@GetMapping("/{accountId}")
	public ResponseEntity<Account> getAccountById(@PathVariable Long accountId) {
		log.info(" user name : " + SecurityContextHolder.getContext().getAuthentication().getName());
		log.info("Account Id : " + accountId);
		return ResponseEntity.ok().body(this.accountService.getAccountById(accountId));
	}

	@GetMapping("/{accountId}/revisions")
	public ResponseEntity<List<Number>> getRevisionsByAccountId(@PathVariable Long accountId) {
		return ResponseEntity.ok().body(this.accountService.getVersionNumbersByAccountId(accountId));
	}

}
