package com.anz.codingchallenge.accountservice.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TRANSACTION", schema = "ANZ")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 8846114403051442382L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID", unique = true, nullable = false)
    private Long transactionId;
	
	@Column(name = "VALUE_DATE", nullable = false)
	private LocalDate valueDate;
	
	@Column(name = "CURRENCY_CODE", nullable = false, length = 20)
	private String currencyCode;
	
	@Column(name = "DEBIT_AMOUNT")
	private BigDecimal debitAmount;
	
	@Column(name = "CREDIT_AMOUNT")
	private BigDecimal creditAmount;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TRANSACTION_TYPE", nullable = false, length = 20)
	private TransactionType transactionType;
	
	@Column(name = "TRANSACTION_NARRATIVE", nullable = false, length = 100)
	private String transactionNarrative;
	
	@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="ACCOUNT_TRANSACTION", schema = "ANZ", 
    	joinColumns={@JoinColumn(name="TRANSACTION_ID", referencedColumnName="TRANSACTION_ID",
    			insertable = false, updatable = false)},
    	inverseJoinColumns={@JoinColumn(name="ACCOUNT_NUMBER", referencedColumnName="ACCOUNT_NUMBER",
    	    	insertable = false, updatable = false)}
    )
    private Account account;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
