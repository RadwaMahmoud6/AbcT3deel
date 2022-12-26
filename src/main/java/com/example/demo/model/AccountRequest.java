package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRequest
{
	private Integer accountNumber;

	private Integer customerNum;

	private String accountType;
	
	private Float currentBalance;
	
	
	private Integer hrLetter;
	
	private String currency;
	
}