package com.ecommerce.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.entity.Admin;
import com.ecommerce.entity.Buyer;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.PlaceOrder;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.Seller;
import com.ecommerce.repo.AdminRepo;
import com.ecommerce.repo.BuyerRepo;
import com.ecommerce.repo.CategoryRepo;
import com.ecommerce.repo.PlaceOrderRepo;
import com.ecommerce.repo.ProductRepo;
import com.ecommerce.repo.SellerRepo;
import com.ecommerce.request.BuyerRequest;
import com.ecommerce.request.CategoryRequest;
import com.ecommerce.request.PlaceOrderRequest;
import com.ecommerce.request.SellerRequest;
import com.ecommerce.response.APIResponse;

@Service
public class ServiceLayer {
	@Autowired
	private SellerRepo sellerRepo;
	@Autowired
	private BuyerRepo buyerRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired 
	private ProductRepo productRepo;
	@Autowired 
	private PlaceOrderRepo placeOrderRepo;
	@Autowired
	private AdminRepo adminRepo;
	
	// for seller registration
	public int create(@RequestParam String approval,SellerRequest request){
		Seller se=new Seller();
		se.setName(request.getName());
		se.setAddress(request.getAddress());
		se.setMobile(request.getMobile());
		se.setPassword(request.getPassword());
		se.setUsername(request.getUsername());
		se.setApproval(approval);
		sellerRepo.save(se);
		return 1;
	}
	
	// for seller login
	public ResponseEntity<APIResponse> login(String username, String password) {
		Seller seller=sellerRepo.validate(username, password);
		if(seller == null) {
		return ResponseEntity.ok(new APIResponse("Failed","Retry",""));
		}
		else {
			return ResponseEntity.ok(new APIResponse("Successfully ","Login",""));
		}
	}
	
	// for buyer registration
	public int buycreate(@RequestParam String approval,BuyerRequest request){
		Buyer se=new Buyer();
		se.setName(request.getName());
		se.setAddress(request.getAddress());
		se.setMobile(request.getMobile());
		se.setPassword(request.getPassword());
		se.setUsername(request.getUsername());
		se.setApproval(approval);
		buyerRepo.save(se);
		return 1;
	}
	
	// for buyer login
	public ResponseEntity<APIResponse> login1(String username, String password) {
		Buyer buyer=buyerRepo.validate(username, password);
		if(buyer==null) {
		return ResponseEntity.ok(new APIResponse("Failed","Retry",""));
		}
		else {
			return ResponseEntity.ok(new APIResponse("Successfully ","Login",""));
		}
}
	
// adding the product
	public int createProduct(CategoryRequest catRequest){
		Category se=new Category();
		se.setCategory(catRequest.getCategory());
		se.setCategoryName(catRequest.getCategoryName());
		categoryRepo.save(se);
		
		Product p1 = new Product();
		p1.setProductName(catRequest.getProducts().getProductName());
		p1.setProduct(catRequest.getProducts().getProduct());
		p1.setPrice(catRequest.getProducts().getPrice());
		p1.setQuantity(catRequest.getProducts().getQuantity());
		p1.setCategoryId(se.getCategoryId());
		productRepo.save(p1);
		return 1;
}
	// find by category name
	public List<Category> findByName(String categoryName) { 
		return (List<Category>) categoryRepo.findByCategoryName(categoryName);
	}
	
//    place order 
	public PlaceOrder placeOrder(Long buyerId, Long productId, PlaceOrderRequest request) {
		// TODO Auto-generated method stub
		PlaceOrder p1 = new PlaceOrder();
		p1.setAddress(request.getAddress());
		p1.setOrderDate(request.getOrderDate());
		p1.setState(request.getState());
		p1.setBuyerId(buyerId);
		p1.setProductId(productId);
		placeOrderRepo.save(p1);
		
		Buyer b1 = buyerRepo.findById(buyerId).get();
		b1.setPlaceOrderId(p1.getPlaceOrderId());
		buyerRepo.save(b1);
		return p1;
	}
	
//   place order details
	public List<PlaceOrder> findAll() {
		// TODO Auto-generated method stub
		return placeOrderRepo.findAll();
	}
	
	// approval for seller
	public Seller sellerApproval(Long sellerId) {
		// TODO Auto-generated method stub
		Seller s1 =sellerRepo.findById(sellerId).get();
		s1.setApproval("yes");
		sellerRepo.save(s1);
		return s1 ;
		}
	// approval for Buyer
	public Buyer buyerApproval(Long buyerId) {
		// TODO Auto-generated method stub
		Buyer b1 =buyerRepo.findById(buyerId).get();
		b1.setApproval("yes");
		buyerRepo.save(b1);
		return b1 ;
		}
	
	// admin login
	public ResponseEntity<APIResponse> adminLogin(String adminUsername, String password) {
		Admin admin=adminRepo.validate(adminUsername, password);
		if(admin == null) {
		return ResponseEntity.ok(new APIResponse("Failed","Retry",""));
		}
		else {
			return ResponseEntity.ok(new APIResponse("Successfully ","Login",""));
		}
}
	
	// delete seller from list
	public ResponseEntity<APIResponse> deleteFromSeller(Long sellerId){
		return sellerRepo.findById(sellerId).map(obj ->{sellerRepo.delete(obj);
		return ResponseEntity.ok(new APIResponse("success","seller Data delete successfully",""));
		}).orElse(null);
		}
	
	// delete buyer from list
		public ResponseEntity<APIResponse> deleteFromBuyer(Long buyerId){
			return buyerRepo.findById(buyerId).map(obj ->{buyerRepo.delete(obj);
			return ResponseEntity.ok(new APIResponse("success","Buyer Data delete successfully",""));
			}).orElse(null);
			}
	
	// finding Buyer id to track order
	public Buyer getById(Long buyerId) {
		return buyerRepo.getByBuyerId(buyerId);
	}

	public ResponseEntity<?> findAllProducts() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(new APIResponse("success","",productRepo.findAll()));
	}

	public ResponseEntity<?> findProductById(Long productId) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(new APIResponse("success","",productRepo.findById(productId)));
	}
}