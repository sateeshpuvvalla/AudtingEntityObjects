package com.audting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audting.controller.AccountController;
import com.audting.model.Account;
import com.audting.repository.AccountRepository;
import com.audting.repository.audit.CustomAccountRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CustomAccountRepository customAccountRepository;

	@Override
	public Account save(Account account) {
		return this.accountRepository.saveAndFlush(account);
	}

	@Override
	public Account update(Account account) {
		return this.accountRepository.saveAndFlush(account);
	}

	@Override
	public void delete(Account account) {
		this.accountRepository.delete(account);
	}

	@Override
	public Account getAccountById(Long accountId) {
		log.info("Service Layer : AccountId : " + accountId);
		return this.accountRepository.findById(accountId).orElse(new Account());
	}

	@Override
	public void deleteAccountById(Long accountId) {
		this.accountRepository.deleteById(accountId);
	}

	@Override
	public List<Number> getVersionNumbersByAccountId(Long accountId) {
		return this.customAccountRepository.getVersionNumbersByAccountId(accountId);
	}

}
