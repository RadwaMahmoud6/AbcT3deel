package com.example.demo.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CUSTOMER")
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

	public Integer getCustomerSerialNum() {
		return customerSerialNum;
	}

	public void setCustomerSerialNum(Integer customerSerialNum) {
		this.customerSerialNum = customerSerialNum;
	}

	public String getUserNID() {
		return userNID;
	}

	public void setUserNID(String userNID) {
		this.userNID = userNID;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	
	

}
