package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.AccountResponse;
import com.example.demo.model.CustomerRequest;
import com.example.demo.model.MessageResponse;
import com.example.demo.service.CustomerService;


@CrossOrigin
@RestController
@RequestMapping("customer") //http://localhost:8282/users
public class CustomerController {
	
	@Autowired
	private CustomerService custserv;
	
	@PostMapping("/login")
	public MessageResponse Logincustomer(@RequestBody CustomerRequest custreq) 
	{
		MessageResponse Response = custserv.LoginCustomer(custreq);
		
		return Response;

	}
	
	@PutMapping("/activate")
	public MessageResponse ActivateAcc(@RequestBody CustomerRequest custreq) 
	{
		MessageResponse Response = custserv.ActivateCustomer(custreq);
		
		return Response;

	}
	
	@PutMapping("/changepass")
	public MessageResponse ChangePass(@RequestBody CustomerRequest request)
	{
		MessageResponse Response = custserv.ChangePassword(request);
		
		return Response;
		
	}
	
	@GetMapping("/getaccounts")
	public List<AccountResponse> getAcc(@RequestBody CustomerRequest request)
	{
		List<AccountResponse> accountlist =custserv.GetAllAccounts(request);
		
		return accountlist;
	}


}
