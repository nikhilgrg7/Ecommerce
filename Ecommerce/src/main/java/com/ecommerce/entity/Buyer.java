package com.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "buyer_detail")
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long buyerId;
	String name;
	String address;
	String mobile;
	String username;
	String password;
	String approval;

	@Column(name = "place_order_id")
	Long placeOrderId;

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

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

	public Long getPlaceOrderId() {
		return placeOrderId;
	}

	public void setPlaceOrderId(Long placeOrderId) {
		this.placeOrderId = placeOrderId;
	}

	public Buyer(Long buyerId, String name, String address, String mobile, String username, String password,
			String approval, Long placeOrderId) {
		super();
		this.buyerId = buyerId;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.username = username;
		this.password = password;
		this.approval = approval;
		this.placeOrderId = placeOrderId;
	}

	public Buyer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Buyer [buyerId=" + buyerId + ", name=" + name + ", address=" + address + ", mobile=" + mobile
				+ ", username=" + username + ", password=" + password + ", approval=" + approval + ", placeOrderId="
				+ placeOrderId + ", getBuyerId()=" + getBuyerId() + ", getName()=" + getName() + ", getAddress()="
				+ getAddress() + ", getMobile()=" + getMobile() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getApproval()=" + getApproval() + ", getPlaceOrderId()="
				+ getPlaceOrderId() + "]";
	}

}
