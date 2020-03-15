package com.anz.codingchallenge.accountservice.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.anz.codingchallenge.accountservice.converter.TransactionConverter;
import com.anz.codingchallenge.accountservice.domain.Account;
import com.anz.codingchallenge.accountservice.domain.Transaction;
import com.anz.codingchallenge.accountservice.domain.UserDetails;
import com.anz.codingchallenge.accountservice.model.TransactionDto;
import com.anz.codingchallenge.accountservice.repository.AccountRepository;
import com.anz.codingchallenge.accountservice.repository.TransactionRepository;
import com.anz.codingchallenge.accountservice.repository.UserRepository;
import com.anz.codingchallenge.accountservice.service.impl.InquiryServiceImpl;

public class InquiryServiceImplTest {

	@Mock
	private AccountRepository accountRepository;

	@Mock
	private UserRepository userRepository;

	@Mock
	private TransactionRepository transactionRepository;

	@Mock
	private TransactionConverter transactionConverter;

	@InjectMocks
	private InquiryService inquiryService;

	private UserDetails user;
	private Account account;
	private Transaction transaction;
	private TransactionDto transactionDto;

	@Before
	public void setUp() {
		inquiryService = new InquiryServiceImpl();
		MockitoAnnotations.initMocks(this);

		user = mock(UserDetails.class);
		Optional<UserDetails> dbuser = Optional.of((UserDetails) user);
		when(userRepository.findById(1L)).thenReturn(dbuser);

		account = mock(Account.class);
		Optional<Account> dbAccount = Optional.of(account);
		when(accountRepository.findById(100L)).thenReturn(dbAccount);

		when(transactionConverter.convert(transaction)).thenReturn(transactionDto);

		List<Transaction> transactions = new ArrayList<>();
		transactions.add(transaction);
		when(transactionRepository.findByAccount(account)).thenReturn(transactions);
	}

	@Test
	public void testGetAccountsForUser() {
		inquiryService.getAccountsForUser(1L);
		verify(userRepository).findById(1L);
		verify(accountRepository).findByUserId(user);
	}

	@Test
	public void testGetTransactionsForAccount() {
		inquiryService.getTransactionsForAccount(100L);
		verify(accountRepository).findById(100L);
		verify(transactionRepository).findByAccount(account);
		verify(transactionConverter).convert(transaction);
	}
}
