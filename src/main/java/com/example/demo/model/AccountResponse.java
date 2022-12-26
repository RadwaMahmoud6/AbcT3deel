package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@AllArgsConstructor

public @Data class AccountResponse{
	
	private Integer accountNumber;

	private Integer customerNum;

	private String accountType;
	
	private Float currentBalance;
	
	private Integer hrLetter;
	
	private String currency;
	

	
}
