package com.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "place_order_detail")
public class PlaceOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long placeOrderId;
	private String address;
	private String state;
	private String orderDate;
	private Long buyerId;
	private Long productId;
	
	@OneToOne
	@JoinColumn(name="place_order_id")
	Buyer buyerDetails;

	public Long getPlaceOrderId() {
		return placeOrderId;
	}

	public void setPlaceOrderId(Long placeOrderId) {
		this.placeOrderId = placeOrderId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Buyer getBuyerDetails() {
		return buyerDetails;
	}

	public void setBuyerDetails(Buyer buyerDetails) {
		this.buyerDetails = buyerDetails;
	}

	public PlaceOrder(Long placeOrderId, String address, String state, String orderDate, Long buyerId, Long productId,
			Buyer buyerDetails) {
		super();
		this.placeOrderId = placeOrderId;
		this.address = address;
		this.state = state;
		this.orderDate = orderDate;
		this.buyerId = buyerId;
		this.productId = productId;
		this.buyerDetails = buyerDetails;
	}

	public PlaceOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PlaceOrder [placeOrderId=" + placeOrderId + ", address=" + address + ", state=" + state + ", orderDate="
				+ orderDate + ", buyerId=" + buyerId + ", productId=" + productId + ", buyerDetails=" + buyerDetails
				+ ", getPlaceOrderId()=" + getPlaceOrderId() + ", getAddress()=" + getAddress() + ", getState()="
				+ getState() + ", getOrderDate()=" + getOrderDate() + ", getBuyerId()=" + getBuyerId()
				+ ", getProductId()=" + getProductId() + ", getBuyerDetails()=" + getBuyerDetails() + "]";
	}
	
	
	
	
	

}
