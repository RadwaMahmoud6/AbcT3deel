package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.AuthenticationRequest;
import com.example.demo.service.CustomerDetailsServices;
import com.example.demo.service.JwtUtils;
import lombok.RequiredArgsConstructor;


@CrossOrigin
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController 
{
	@Autowired
	CustomerDetailsServices custdetserv;
	
	@Autowired
	JwtUtils jwtUtils;
	
	
	private final AuthenticationManager authenticationManager;
	
	@CrossOrigin
	@PostMapping("/authenticate")
	public Map<String, Object> authenticate(@RequestBody AuthenticationRequest request)
	{

		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getUserPassword()));
		Map<String, Object> map = new HashMap<>();

		final UserDetails user =  custdetserv.loadUserByUsername(request.getUserName());
		if(user != null)
		{
			map.put("status", 1);
			map.put("token", jwtUtils.generateToken(user));
			return  map;
		}
		
		map.put("status", 0);
		return map;
	}


}
