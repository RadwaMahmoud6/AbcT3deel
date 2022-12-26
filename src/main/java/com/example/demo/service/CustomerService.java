package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.AccountsEntity;
import com.example.demo.entities.CustomerEntity;
import com.example.demo.model.AccountResponse;
import com.example.demo.model.CustomerRequest;
import com.example.demo.model.MessageResponse;
import com.example.demo.repository.AccountsRepo;
import com.example.demo.repository.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo custrepo;

	@Autowired
	private AccountsRepo accrep;

	// LOGIN FUNCTION
	public MessageResponse LoginCustomer(CustomerRequest custreq) {
		MessageResponse response = new MessageResponse();

		Optional<CustomerEntity> ent = custrepo.findByEmail(custreq.getEmail());

		if (ent.isPresent()) {
			if (custreq.getEmail().equals(ent.get().getEmail())
					&& custreq.getUserPassword().equals(ent.get().getUserPassword())) {
				response.setResponseMessage("Login Successful");
				response.setResponseStatus(1);
			}
		} else {
			response.setResponseMessage("Login Failed");
			response.setResponseStatus(0);
		}

		return response;
	}

	// REGISTER FUNCTION
	public MessageResponse ActivateCustomer(CustomerRequest custreqact) {
		MessageResponse response = new MessageResponse();

		Optional<CustomerEntity>  custent = custrepo.findByEmail(custreqact.getEmail());
		if (custent.isPresent()) 
		{
			if ((custreqact.getBirthdate().toString()).equals(custent.get().getBirthdate().toString()))
	//		if(custreqact.getBirthdate().toString() == custent.getBirthdate().toString())
			{
				response.setResponseMessage("Valid Birthdate");
				response.setResponseStatus(1);
	
			} else {
				response.setResponseMessage("Invalid Birthdate ,Please Enter valid data or contact customer service");
				response.setResponseStatus(0);
				return response;
	
			}
	
			if (custreqact.getMobileNumber().equals(custent.get().getMobileNumber())) {
				response.setResponseMessage("Valid Number");
				response.setResponseStatus(1);
	
			} else {
				response.setResponseMessage("Invalid Number ,Please Enter valid data or contact customer service");
				response.setResponseStatus(0);
				return response;
	
			}
	
			List<AccountsEntity> accent = accrep.findByCustomerNum(custent.get().getCustomerSerialNum());
	
			for (AccountsEntity en : accent) {
				if (en.getAccountNumber().equals(custreqact.getAccountNumber())) {
					response.setResponseMessage("Valid Account Number , Activation Successful");
					response.setResponseStatus(1);
	
					custent.get().setUserPassword(custreqact.getUserPassword());
					custrepo.save(custent.get());
					return response;
				}
	
			}
		}

		response.setResponseMessage("Invalid Data ,Please Enter valid data or contact customer service");
		response.setResponseStatus(0);
		return response;

	}

	public MessageResponse ChangePassword(CustomerRequest req) {

		MessageResponse response = new MessageResponse();

		Optional<CustomerEntity> custent = custrepo.findByEmail(req.getEmail());
		if (custent.isPresent()) 
		{
			if (custent.get().getUserPassword().equals(req.getUserPassword())) 
			{
				response.setResponseMessage("Pasword matches the old one, please type another password");
				response.setResponseStatus(0);
				return response;
	
			} 
			else
			{
					custent.get().setUserPassword(req.getUserPassword());
					custrepo.save(custent.get());
					response.setResponseMessage("Password Changed Successfully");
					response.setResponseStatus(1);
					return response;
					
			}
		}
		
		
		return response;

	}

	public List<AccountResponse> GetAllAccounts(CustomerRequest req) {

		List<AccountResponse> resp = new ArrayList<>();
		List<AccountsEntity> accountlist = accrep.findByCustomerNum(req.getCustomerSerialNum());

		for (AccountsEntity en : accountlist) {

			AccountResponse res = new AccountResponse();
			BeanUtils.copyProperties(en, res);
			resp.add(res);
		}

		return resp;
	}
}
