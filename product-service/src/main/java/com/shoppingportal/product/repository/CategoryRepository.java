package com.shoppingportal.product.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.shoppingportal.product.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

	@Query(value = "select c.category_name,SUM(p.quantity) as total_quantity from product p join category c on c.category_id = p.category_id group by c.category_name", nativeQuery = true)
	public List<Map<String,Integer>> findTotalProductInEachCategory();
	

}



 