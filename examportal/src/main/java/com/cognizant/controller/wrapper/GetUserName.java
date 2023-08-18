package com.cognizant.controller.wrapper;

import org.springframework.stereotype.Component;

@Component
public class GetUserName {
	private String contactNo;
	private String email;

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
