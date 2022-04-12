package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired ;  
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Seller;
import com.ecommerce.repo.SellerRepo;
import com.ecommerce.request.BuyerRequest;
import com.ecommerce.request.CategoryRequest;
import com.ecommerce.request.PlaceOrderRequest;
import com.ecommerce.request.ProductRequest;
import com.ecommerce.request.SellerRequest;
import com.ecommerce.response.APIResponse;
import com.ecommerce.service.ServiceLayer;

@CrossOrigin
@RestController
@RequestMapping("/project")
public class MainController {

	@Autowired
	ServiceLayer sellerservice;
	
	// seller register
	@PostMapping("/seller_register")
	public ResponseEntity<APIResponse> create(@RequestParam String approval, @RequestBody SellerRequest request ){
	
	 int i=sellerservice.create(approval, request);
	 if(i>0){
	 return ResponseEntity.ok(new APIResponse("success","user created Suceessful",""));
	 }else{
	 return ResponseEntity.ok(new APIResponse("failed","user not created Suceessful",""));
	 }
	}
	
	//seller=login
	@GetMapping("/seller_login")
	public ResponseEntity<?> login(@RequestParam String username,@RequestParam String password){
		return sellerservice.login(username,password);
	}
	
	//buyer-register
	@PostMapping("/buyer_register")
	public ResponseEntity<APIResponse>buycreate(@RequestParam String approval,@RequestBody BuyerRequest request ){
	 int i=sellerservice.buycreate(approval, request);
	 if(i>0){
	 return ResponseEntity.ok(new APIResponse("success","user created Suceessful",""));
	 }else{
	 return ResponseEntity.ok(new APIResponse("failed","user not created Suceessful",""));
	 }
	}
	
	//buyer-login
	@GetMapping("/buyer_login")
	public ResponseEntity<?> login1(@RequestParam String username,@RequestParam String password){
	return sellerservice.login1(username,password);
	}
	
	//create product by seller
	@PostMapping("/add_product")
	public ResponseEntity<APIResponse> createProduct(@RequestBody CategoryRequest request ){
	 int i=sellerservice.createProduct(request);
	 if(i>0){
	 return ResponseEntity.ok(new APIResponse("success","Product created Suceessful",""));
	 }else{
	 return ResponseEntity.ok(new APIResponse("failed","Please enter product details",""));
	 }
	}
	
	// find product by name
	@GetMapping("/findname")
	public ResponseEntity<APIResponse> findByName(@RequestParam String categoryName){
		APIResponse apiRespons =new APIResponse();
		apiRespons.setStatus("succcess");
		apiRespons.setMessage("");
		apiRespons.setData(sellerservice.findByName(categoryName));
		return ResponseEntity.ok(apiRespons);
	}
	
	// order placed
	@PostMapping("/place_order")
	public ResponseEntity<APIResponse> placeOrder(@RequestParam Long buyerId ,@RequestParam Long productId
			,@RequestBody PlaceOrderRequest request){
		APIResponse apiRespons =new APIResponse();
		apiRespons.setStatus("succcess");
		apiRespons.setMessage("Order Placed");
		apiRespons.setData(sellerservice.placeOrder(buyerId,productId,request));
		return ResponseEntity.ok(apiRespons);
		}
	
	// track order by admin for buyer
	@GetMapping("/track_order_by_admin")
	public ResponseEntity<APIResponse> findAll(){
		APIResponse apiRespons =new APIResponse();
		apiRespons.setStatus("succcess");
		apiRespons.setMessage("List of all the order placed");
		apiRespons.setData(sellerservice.findAll());
		return ResponseEntity.ok(apiRespons);
		}
	
	// admin-login
	@GetMapping("/admin_login")
	public ResponseEntity<?> adminLogin(@RequestParam String adminUsername,@RequestParam String password){
	return sellerservice.adminLogin(adminUsername,password);
	}
	
	@PutMapping("/request_approval_for_seller")
	public ResponseEntity<APIResponse> sellerApproval(@RequestParam Long sellerId) {
		// TODO Auto-generated method stub
		APIResponse apiRespons =new APIResponse();
		apiRespons.setStatus("succcess");
		apiRespons.setMessage("Approved");
		apiRespons.setData(sellerservice.sellerApproval(sellerId));
		return ResponseEntity.ok(apiRespons);
		}
	
	@PutMapping("/request_approval_for_Buyer")
	public ResponseEntity<APIResponse> buyerApproval(@RequestParam Long buyerId) {
		// TODO Auto-generated method stub
		APIResponse apiRespons =new APIResponse();
		apiRespons.setStatus("succcess");
		apiRespons.setMessage("Approved");
		apiRespons.setData(sellerservice.buyerApproval(buyerId));
		return ResponseEntity.ok(apiRespons);
		}
	
	@DeleteMapping("/delete_by_admin_for_seller")
	public ResponseEntity<?> deleteFromSeller(@RequestParam Long sellerId){
		return sellerservice.deleteFromSeller(sellerId);
	}
	
	@DeleteMapping("/delete_by_admin_for_buyer")
	public ResponseEntity<?> deleteFromBuyer(@RequestParam Long buyerId){
		return sellerservice.deleteFromBuyer(buyerId);
	}
	
	@GetMapping("/track_order")
	public ResponseEntity<APIResponse> getById(@RequestParam Long buyerId){
		APIResponse apResponse =new APIResponse();
		apResponse.setStatus("succcess");
		apResponse.setMessage("Here are the Buyer details for placing the order");
		apResponse.setData(sellerservice.getById(buyerId));
		return ResponseEntity.ok(apResponse);
		}
	@GetMapping("/find_all_products")
	public ResponseEntity<?> findAllProducts(){
	return sellerservice.findAllProducts();
	}
	@GetMapping("/find_product_by_id")
	public ResponseEntity<?> findProductById(@RequestParam Long productId){
	return sellerservice.findProductById(productId);
	}
}