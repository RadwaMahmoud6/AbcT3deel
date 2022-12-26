package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.aspect.GeneralAspects;
import com.example.demo.model.AccountRequest;
import com.example.demo.model.AccountResponse;
import com.example.demo.model.CustomerResponse;
import com.example.demo.service.AccountsService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("accounts") //http://localhost:8282/users
public class AccountsController {
	
	@Autowired
	private AccountsService accserv;
	
	@GetMapping
	public AccountResponse getAccounts(@RequestBody AccountRequest request) 
	{
//		AccountResponse accresp = new AccountResponse();
//		accserv.getAccounts(request);
//		BeanUtils.copyProperties(request, accresp);
//		return accresp;
		return accserv.getAccounts(request);
	
	}
	
	@GetMapping("/cust")
	public CustomerResponse getCustomer(@RequestBody AccountRequest request) 
	{
		
		return accserv.getCustomers(request);
	
	}
	

}
