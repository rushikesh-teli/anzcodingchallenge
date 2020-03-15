package com.anz.codingchallenge.accountservice.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.anz.codingchallenge.accountservice.formatter.BigDecimalSerializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "ACCOUNT", schema = "ANZ")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"userId", "transactions"})
@JsonPropertyOrder({"account_number", "account_name", "account_type", "balance_date", "currency_code", "opening_available_balance"})
public class Account implements Serializable {

	private static final long serialVersionUID = 8846114403051442382L;

	@Id
    @Column(name = "ACCOUNT_NUMBER", unique = true, nullable = false)
	@JsonProperty("account_number")
    private Long accountNumber;
	
	@Column(name = "ACCOUNT_NAME", nullable = false, length = 80)
	@JsonProperty("account_name")
	private String accountName;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ACCOUNT_TYPE", nullable = false, length = 25)
	@JsonProperty("account_type")
	private AccountType accountType;
	
	@Column(name = "BALANCE_DATE", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@JsonProperty("balance_date")
	private LocalDate balanceDate;
	
	@Column(name = "CURRENCY_CODE", nullable = false, length = 20)
	@JsonProperty("currency_code")
	private String currencyCode;
	
	@Column(name = "OPENING_AVAILABLE_BALANCE", nullable = false)
	@JsonProperty("opening_available_balance")
	@JsonSerialize(using = BigDecimalSerializer.class)
	private BigDecimal openingAvailableBalance;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="USER_ID", nullable=false)
	@JsonProperty("user_id")
    private UserDetails userId;
	
	@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name="ACCOUNT_TRANSACTION", schema = "ANZ",
    	joinColumns={@JoinColumn(name="ACCOUNT_NUMBER", referencedColumnName="ACCOUNT_NUMBER")},
    	inverseJoinColumns={@JoinColumn(name="TRANSACTION_ID", referencedColumnName="TRANSACTION_ID")}
    )
	@JsonProperty("transactions")
    private List<Transaction> transactions;

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

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public LocalDate getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(LocalDate balanceDate) {
		this.balanceDate = balanceDate;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getOpeningAvailableBalance() {
		return openingAvailableBalance;
	}

	public void setOpeningAvailableBalance(BigDecimal openingAvailableBalance) {
		this.openingAvailableBalance = openingAvailableBalance;
	}

	public UserDetails getUserId() {
		return userId;
	}

	public void setUserId(UserDetails userId) {
		this.userId = userId;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
}
