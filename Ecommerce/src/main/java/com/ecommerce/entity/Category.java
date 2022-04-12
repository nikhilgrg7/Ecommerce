package com.ecommerce.entity;

import java.util.List;

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
@Table(name = "category_details")
public class Category {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Long categoryId;
	    String categoryName;
		String category;
		
		@OneToMany
		@JoinColumn(name="category_id")
		private List<Product> products;

		public Long getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(Long categoryId) {
			this.categoryId = categoryId;
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

		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}

		public Category(Long categoryId, String categoryName, String category, List<Product> products) {
			super();
			this.categoryId = categoryId;
			this.categoryName = categoryName;
			this.category = category;
			this.products = products;
		}

		public Category() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", category=" + category
					+ ", products=" + products + ", getCategoryId()=" + getCategoryId() + ", getCategoryName()="
					+ getCategoryName() + ", getCategory()=" + getCategory() + ", getProducts()=" + getProducts() + "]";
		}
		
		
		
		
		
		
	  
	}
