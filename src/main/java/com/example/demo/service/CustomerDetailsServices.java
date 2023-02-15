package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.controller.CustomerDetails;
import com.example.demo.entities.CustomerEntity;
import com.example.demo.repository.CustomerRepo;

@Service
public class CustomerDetailsServices implements UserDetailsService  {

	@Autowired
	CustomerRepo custrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Optional<CustomerEntity> custent = custrepo.findByUserName(username);
		 
		 custent.orElseThrow(()-> new UsernameNotFoundException("The username" + username +" doesnot exist"));

		 
		 return custent.map(CustomerDetails::new).get();
		 
	}

}
