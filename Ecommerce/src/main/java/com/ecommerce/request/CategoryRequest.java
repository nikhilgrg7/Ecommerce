package com.ecommerce.request;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryRequest {

    String categoryName;
	String category;
	ProductRequest products;
	
	public ProductRequest getProducts() {
		return products;
	}
	public void setProducts(ProductRequest products) {
		this.products = products;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "CategoryRequest [categoryName=" + categoryName + ", category=" + category + ", products=" + products
				+ ", getProducts()=" + getProducts() + ", getCategoryName()=" + getCategoryName() + ", getCategory()="
				+ getCategory() + "]";
	}
	
	
}
