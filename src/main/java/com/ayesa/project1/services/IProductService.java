package com.ayesa.project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ayesa.project1.data.model.Product;

@Service
public interface IProductService {
	public  List<Product> findAll();
	public Optional<Product> findById(Long id);
	
	public Product save(Product entity);
	public void deleteById(Long id);
	public Boolean existsById(Long id);
	public void deleteAll();
	public Product newEntity();
}
