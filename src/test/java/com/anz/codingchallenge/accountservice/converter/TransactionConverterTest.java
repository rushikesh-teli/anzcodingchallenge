package com.anz.codingchallenge.accountservice.converter;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.anz.codingchallenge.accountservice.domain.Account;
import com.anz.codingchallenge.accountservice.domain.Transaction;
import com.anz.codingchallenge.accountservice.domain.TransactionType;
import com.anz.codingchallenge.accountservice.model.TransactionDto;

public class TransactionConverterTest {

	@Mock
	private Transaction transaction;
	@Mock
	private Account account;

	@Before
	public void setUp() {
		transaction = new Transaction();
		account = new Account();

		MockitoAnnotations.initMocks(this);

		LocalDate valueDate = LocalDate.of(2020, 03, 01);

		when(account.getAccountNumber()).thenReturn(1L);
		when(account.getAccountName()).thenReturn("Account 1");

		when(transaction.getCreditAmount()).thenReturn(new BigDecimal("100.25"));
		when(transaction.getDebitAmount()).thenReturn(null);
		when(transaction.getCurrencyCode()).thenReturn("AUD");
		when(transaction.getValueDate()).thenReturn(valueDate);
		when(transaction.getTransactionType()).thenReturn(TransactionType.Credit);
		when(transaction.getTransactionNarrative()).thenReturn("Test Transaction");
		when(transaction.getAccount()).thenReturn(account);
	}

	@Test
	public void testConvert() {
		TransactionConverter transactionConverter = new TransactionConverter();
		TransactionDto expectedTransactionDto = new TransactionDto();
		expectedTransactionDto.setAccountName("Account 1");
		expectedTransactionDto.setAccountNumber(1L);
		expectedTransactionDto.setCreditAmount(new BigDecimal("100.25"));
		expectedTransactionDto.setDebitAmount(null);
		expectedTransactionDto.setCurrencyCode("AUD");
		expectedTransactionDto.setValueDate(LocalDate.of(2020, 03, 01));
		expectedTransactionDto.setTransactionType(TransactionType.Credit);
		expectedTransactionDto.setTransactionNarrative("Test Transaction");

		TransactionDto actualTransactionDto = transactionConverter.convert(transaction);
		Assertions.assertThat(actualTransactionDto).isEqualToComparingFieldByField(expectedTransactionDto);
	}
}
