package com.example.demo.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticationRequest 
{
	
	private  String userName;
	private String userPassword;

}
