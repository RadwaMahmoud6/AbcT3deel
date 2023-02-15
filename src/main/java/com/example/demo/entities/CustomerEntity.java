package com.example.demo.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
public class CustomerEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_SERIAL_NUM")
	private Integer customerSerialNum;
	
	@Column(name = "USER_NID")
	private String userNID;
	
	@Column(name="PASSPORT")
	private String passport;
	
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	@Column(name="BIRTHDATE")
	private Date birthdate;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name="MARITAL_STATUS")
	private String maritalStatus;
	
	@Column(name="NATIONALITY")
	private String nationality;
	
	@Column(name="MOBILE_NUMBER")
	private String mobileNumber;
	
	@Column(name="EMAIL", unique = true , nullable = false)
	private String email;
	
	@Column(name="USER_PASSWORD")
	private String userPassword;
	
	@Column(name="USER_NAME")
	private String userName;

	
	

}
