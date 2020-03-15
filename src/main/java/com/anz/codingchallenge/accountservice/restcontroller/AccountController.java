package com.anz.codingchallenge.accountservice.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anz.codingchallenge.accountservice.domain.Account;
import com.anz.codingchallenge.accountservice.model.TransactionDto;
import com.anz.codingchallenge.accountservice.service.InquiryService;

@RestController
@RequestMapping("anz/")
public class AccountController {
	
	@Autowired
	private InquiryService inquiryService;

	@GetMapping(path = "/user/{userId}/accounts", produces = "application/json")
	public List<Account> getUserAccounts(@PathVariable("userId") Long userId){
		List<Account> accounts = inquiryService.getAccountsForUser(userId);
		return accounts;
	}
	
	@GetMapping(path = "/account/{accountNumber}/transactions", produces = "application/json")
	public List<TransactionDto> getAccountTransactions(@PathVariable("accountNumber") Long accountNumber){
		List<TransactionDto> transactionDtos = inquiryService.getTransactionsForAccount(accountNumber);
		return transactionDtos;
	}
}
