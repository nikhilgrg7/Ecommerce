package com.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category,String> {

	List<Category> findByCategoryName(String categoryName);

}

