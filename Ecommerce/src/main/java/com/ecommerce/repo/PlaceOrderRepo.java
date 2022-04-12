package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.PlaceOrder;

@Repository
public interface PlaceOrderRepo extends JpaRepository<PlaceOrder, Long>{
	
}


