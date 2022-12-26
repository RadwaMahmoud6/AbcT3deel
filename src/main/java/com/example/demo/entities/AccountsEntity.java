package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ACCOUNTS")
@Setter
@Getter
@NoArgsConstructor
public class AccountsEntity {

	@Id
	@Column(name = "ACCOUNT_NUMBER")
	private Integer accountNumber;

	@Column(name = "CUSTOMER_NUM")
	private Integer customerNum;

	@Column(name = "ACCOUNT_TYPE")
	private String accountType;

	@Column(name = "CURRENT_BALANCE")
	private Float currentBalance;

	@Column(name = "HR_LETTER")
	private Integer hrLetter;

	@Column(name = "CURRENCY")
	private String currency;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_NUM", referencedColumnName = "CUSTOMER_SERIAL_NUM", insertable = false, updatable = false)
	private CustomerEntity entity;

}
