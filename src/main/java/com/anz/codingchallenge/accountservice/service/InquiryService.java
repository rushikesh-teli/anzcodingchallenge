package com.anz.codingchallenge.accountservice.service;

import java.util.List;

import com.anz.codingchallenge.accountservice.domain.Account;
import com.anz.codingchallenge.accountservice.model.TransactionDto;

/**
 * Interface to inquire account and transactions.
 *
 */
public interface InquiryService {

	/**
	 * This method returns list of accounts for given user.
	 * @param userId user id for accounts to be fetched.
	 * @return list of {@link Account} for given user id.
	 */
	List<Account> getAccountsForUser(Long userId);
	
	/**
	 * This method returns list of transactions for given account.
	 * @param accountNumber account number of which transactions to be fetched.
	 * @return list of {@link TransactionDto} for given account.
	 */
	List<TransactionDto> getTransactionsForAccount(Long accountNumber);
}
