package com.anz.codingchallenge.accountservice.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.anz.codingchallenge.accountservice.domain.TransactionType;
import com.anz.codingchallenge.accountservice.formatter.BigDecimalSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({"account_number", "account_name", "value_date", "currency_code", "debit_amount", "credit_amount", "transaction_type", "transaction_narrative"})
public class TransactionDto implements Serializable {

	private static final long serialVersionUID = 8452921357754912073L;

	@JsonProperty("account_number")
    private Long accountNumber;
	
	@JsonProperty("account_name")
	private String accountName;
	
	@JsonProperty("value_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MMM, dd, yyyy")
	private LocalDate valueDate;
	
	@JsonProperty("currency_code")
	private String currencyCode;
	
	@JsonProperty("debit_amount")
	@JsonSerialize(using = BigDecimalSerializer.class)
	private BigDecimal debitAmount;
	
	@JsonProperty("credit_amount")
	@JsonSerialize(using = BigDecimalSerializer.class)
	private BigDecimal creditAmount;
	
	@JsonProperty("transaction_type")
	private TransactionType transactionType;
	
	@JsonProperty("transaction_narrative")
	private String transactionNarrative;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public LocalDate getValueDate() {
		return valueDate;
	}

	public void setValueDate(LocalDate valueDate) {
		this.valueDate = valueDate;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}

	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionNarrative() {
		return transactionNarrative;
	}

	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}
}
