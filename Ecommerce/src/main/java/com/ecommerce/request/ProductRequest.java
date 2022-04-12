package com.ecommerce.request;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequest {

	String productName;
	String product;
	String price;
	Long quantity;
	
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
	public ProductRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductRequest [productName=" + productName + ", product=" + product + ", price=" + price
				+ ", quantity=" + quantity + ", getProductName()=" + getProductName() + ", getProduct()=" + getProduct()
				+ ", getPrice()=" + getPrice() + ", getQuantity()=" + getQuantity() + "]";
	}
	
	
	
	
	
}
