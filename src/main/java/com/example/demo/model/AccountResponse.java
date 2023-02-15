package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

//@AllArgsConstructor

@Setter
@Getter
public class AccountResponse{
	
	private Integer accountNumber;

	private Integer customerNum;

	private String accountType;
	
	private Float currentBalance;
	
	private Integer hrLetter;
	
	private String currency;
	

	
}
