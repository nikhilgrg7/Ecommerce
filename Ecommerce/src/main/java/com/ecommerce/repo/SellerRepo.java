package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Seller;
import com.ecommerce.request.SellerRequest;

@Repository
public interface SellerRepo extends JpaRepository<Seller, Long> {

	@Query("SELECT b FROM Seller b WHERE b.username=:username AND b.password=:password")
	Seller validate(@Param ("username") String username, @Param ("password") String password);

	
}
