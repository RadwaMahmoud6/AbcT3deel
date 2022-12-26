package com.example.demo.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "TRANSACTIONS")
public class TransactionsEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRANSACTION_NUM")
	private Integer transactionNum;
	
	@Column(name = "ACCOUNT_NUM")
	private Integer accountNum;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_NUM" , referencedColumnName = "ACCOUNT_NUMBER" , insertable = false , updatable = false)
	private AccountsEntity accountsEntity;
	
	@Column(name = "BALANCE_ADDED")
	private Float balanceAdded;
	
	@Column(name = "BALANCE_TRANSFERRED")
	private Float balanceTransferred;
	
	@Column(name = "TRANSACTION_TYPE")
	private String transactionType;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TRANSACTION_DATE" )
	private Date transactionDate;
	
	@Column(name="ACCOUNT_TRANSFERED_TO")
	private Integer accountTransferedTo;

	public Integer getTransactionNum() {
		return transactionNum;
	}

	public void setTransactionNum(Integer transactionNum) {
		this.transactionNum = transactionNum;
	}

	public Integer getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(Integer accountNum) {
		this.accountNum = accountNum;
	}

	public AccountsEntity getAccountsEntity() {
		return accountsEntity;
	}

	public void setAccountsEntity(AccountsEntity accountsEntity) {
		this.accountsEntity = accountsEntity;
	}

	public Float getBalanceAdded() {
		return balanceAdded;
	}

	public void setBalanceAdded(Float balanceAdded) {
		this.balanceAdded = balanceAdded;
	}

	public Float getBalanceTransferred() {
		return balanceTransferred;
	}

	public void setBalanceTransferred(Float balanceTransferred) {
		this.balanceTransferred = balanceTransferred;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Integer getAccountTransferedTo() {
		return accountTransferedTo;
	}

	public void setAccountTransferedTo(Integer accountTransferedTo) {
		this.accountTransferedTo = accountTransferedTo;
	}

	

}
