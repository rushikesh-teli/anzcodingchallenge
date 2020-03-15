package com.anz.codingchallenge.accountservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.anz.codingchallenge.accountservice.domain.Transaction;
import com.anz.codingchallenge.accountservice.model.TransactionDto;

@Component
public class TransactionConverter implements Converter<Transaction, TransactionDto> {

	@Override
	public TransactionDto convert(Transaction transaction) {
		TransactionDto transactionDto = new TransactionDto();
		
		transactionDto.setAccountName(transaction.getAccount().getAccountName());
		transactionDto.setAccountNumber(transaction.getAccount().getAccountNumber());
		transactionDto.setCreditAmount(transaction.getCreditAmount());
		transactionDto.setDebitAmount(transaction.getDebitAmount());
		transactionDto.setCurrencyCode(transaction.getCurrencyCode());
		transactionDto.setValueDate(transaction.getValueDate());
		transactionDto.setTransactionType(transaction.getTransactionType());
		transactionDto.setTransactionNarrative(transaction.getTransactionNarrative());
		
		return transactionDto;
	}
}
