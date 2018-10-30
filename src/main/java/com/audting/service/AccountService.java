package com.audting.service;

import java.util.List;

import com.audting.model.Account;

public interface AccountService {

	public Account save(Account account);

	public Account update(Account account);

	public void delete(Account account);

	public Account getAccountById(Long accountId);

	public void deleteAccountById(Long accountId);
	
	public List<Number> getVersionNumbersByAccountId(Long accountId);

}
