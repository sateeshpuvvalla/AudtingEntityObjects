package com.audting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audting.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {


}
