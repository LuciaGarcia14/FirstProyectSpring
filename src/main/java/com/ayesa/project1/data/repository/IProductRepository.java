package com.ayesa.project1.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ayesa.project1.data.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
	
}
