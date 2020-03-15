package com.anz.codingchallenge.accountservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.codingchallenge.accountservice.domain.Account;
import com.anz.codingchallenge.accountservice.domain.UserDetails;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	List<Account> findByUserId(UserDetails userId);
}
