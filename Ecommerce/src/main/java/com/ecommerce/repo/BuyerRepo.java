package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Buyer;
import com.ecommerce.entity.Seller;

@Repository
public interface BuyerRepo extends JpaRepository<Buyer, Long> {

	@Query("SELECT a FROM Buyer a WHERE a.username=:username AND a.password=:password")
	Buyer validate(@Param("username") String username, @Param("password") String password);

	Buyer getByBuyerId(Long buyerId);

}
