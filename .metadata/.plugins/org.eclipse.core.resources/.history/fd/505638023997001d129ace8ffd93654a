package com.masai.heybroker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String password;
	private String role;
	private String mobile;
	private String email;
	private String city;
	
	
	//non-parameterized constructor
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	//parameterized constructor with userId
	public User(Integer userId, String password, String role, String mobile, String email, String city) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.mobile = mobile;
		this.email = email;
		this.city = city;
	}

	//parameterized constructor without userId
	public User(String password, String role, String mobile, String email, String city) {
		super();
		this.password = password;
		this.role = role;
		this.mobile = mobile;
		this.email = email;
		this.city = city;
	}
	
	//getters and setters
	
	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

	//toString method

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + ", mobile=" + mobile
				+ ", email=" + email + ", city=" + city + "]";
	}
	
	
	
	
	
	
	
	

}
