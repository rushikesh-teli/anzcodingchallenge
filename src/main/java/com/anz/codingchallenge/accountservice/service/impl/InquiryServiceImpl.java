package com.anz.codingchallenge.accountservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anz.codingchallenge.accountservice.converter.TransactionConverter;
import com.anz.codingchallenge.accountservice.domain.Account;
import com.anz.codingchallenge.accountservice.domain.Transaction;
import com.anz.codingchallenge.accountservice.domain.UserDetails;
import com.anz.codingchallenge.accountservice.model.TransactionDto;
import com.anz.codingchallenge.accountservice.repository.AccountRepository;
import com.anz.codingchallenge.accountservice.repository.TransactionRepository;
import com.anz.codingchallenge.accountservice.repository.UserRepository;
import com.anz.codingchallenge.accountservice.service.InquiryService;

@Service
public class InquiryServiceImpl implements InquiryService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private TransactionConverter transactionConverter;
	
	@Override
	public List<Account> getAccountsForUser(Long userId) {
		UserDetails user = userRepository.findById(userId).get();
		List<Account> accounts = accountRepository.findByUserId(user);
		return accounts;
	}

	@Override
	public List<TransactionDto> getTransactionsForAccount(Long accountNumber) {
		Account account = accountRepository.findById(accountNumber).get();
		List<Transaction> transactions = transactionRepository.findByAccount(account);
		List<TransactionDto> transactionDtos = transactions.stream().map(transactionConverter::convert).collect(Collectors.toList());
		return transactionDtos;
	}

}
