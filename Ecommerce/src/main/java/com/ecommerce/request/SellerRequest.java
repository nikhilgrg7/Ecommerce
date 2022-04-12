package com.ecommerce.request;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SellerRequest {
	String name;
	String address;
	String mobile;
	String username;
	String password;
	String approval;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public SellerRequest(String name, String address, String mobile, String username, String password,
			String approval) {
		super();
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.username = username;
		this.password = password;
		this.approval = approval;
	}

	public SellerRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AccountRequest [name=" + name + ", address=" + address + ", mobile=" + mobile + ", username=" + username
				+ ", password=" + password + ", approval=" + approval + ", getName()=" + getName() + ", getAddress()="
				+ getAddress() + ", getMobile()=" + getMobile() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getApproval()=" + getApproval() + "]";
	}

}