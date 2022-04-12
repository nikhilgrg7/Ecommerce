package com.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "product_details")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long productId;
	String productName;
	String product;
	String price;
	Long quantity;
	
	@Column(name="category_id")
	private Long categoryId;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	public Product(Long productId, String productName, String product, String price, Long quantity, Long categoryId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.categoryId = categoryId;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", product=" + product + ", price="
				+ price + ", quantity=" + quantity + ", categoryId=" + categoryId + ", getProductId()=" + getProductId()
				+ ", getProductName()=" + getProductName() + ", getProduct()=" + getProduct() + ", getPrice()="
				+ getPrice() + ", getQuantity()=" + getQuantity() + ", getCategoryId()=" + getCategoryId() + "]";
	}

	
}