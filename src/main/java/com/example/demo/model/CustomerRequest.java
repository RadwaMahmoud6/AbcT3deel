package com.example.demo.model;


import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {
	
	private Integer customerSerialNum;
	
	private String userNID;
	
	private String passport;
	
	private String customerName;
	
	private Date birthdate;
	
	private String address;
	
	private String maritalStatus;
	
	private String nationality;
	
	private String mobileNumber;
	
	private String email;
	
	private String userPassword;

	private Integer accountNumber;
	
	private String userName;


	

}
