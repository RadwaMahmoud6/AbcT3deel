package com.example.demo.model;

import java.sql.Date;

public class TransactionResponse {
	
	private Integer transactionNum;

	private Integer accountNum;
	
	private Float balanceAdded;
	
	private Float balanceTransferred;
	
	private String transactionType;
	
	private Date transactionDate;

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
