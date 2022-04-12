package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
	
	@Query("SELECT a FROM Admin a WHERE a.adminUsername=:admin_username AND a.password=:password")
	Admin validate(@Param ("admin_username") String adminUsername, @Param ("password") String password);

}
