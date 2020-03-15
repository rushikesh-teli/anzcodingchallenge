package com.anz.codingchallenge.accountservice.restcontroller;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.anz.codingchallenge.accountservice.service.InquiryService;

public class AccountControllerTest {

	@Mock
	private InquiryService inquiryService;

	@InjectMocks
	private AccountController accountController;

	@Before
	public void setUp() {
		accountController = new AccountController();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetUserAccounts() {
		accountController.getUserAccounts(1L);
		verify(inquiryService).getAccountsForUser(1L);
	}

	@Test
	public void testGetAccountTransactions() {
		accountController.getAccountTransactions(100L);
		verify(inquiryService).getTransactionsForAccount(100L);
	}
}
