package com.ecommerce.entity;


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
@Table(name = "seller_detail")
public class Seller {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Long sellerId;
		String name;
		String address;
		String mobile;
		String username;
		String password;
		String approval;
		public Long getSellerId() {
			return sellerId;
		}
		public void setSellerId(Long sellerId) {
			this.sellerId = sellerId;
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
		public Seller(Long sellerId, String name, String address, String mobile, String username, String password,
				String approval) {
			super();
			this.sellerId = sellerId;
			this.name = name;
			this.address = address;
			this.mobile = mobile;
			this.username = username;
			this.password = password;
			this.approval = approval;
		}
		public Seller() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Account [sellerId=" + sellerId + ", name=" + name + ", address=" + address + ", mobile=" + mobile
					+ ", username=" + username + ", password=" + password + ", approval=" + approval
					+ ", getSellerId()=" + getSellerId() + ", getName()=" + getName() + ", getAddress()=" + getAddress()
					+ ", getMobile()=" + getMobile() + ", getUserName()=" + getUsername() + ", getPassword()="
					+ getPassword() + ", getApproval()=" + getApproval() + "]";
		}
		
		
}