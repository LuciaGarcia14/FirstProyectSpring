package com.ayesa.project1.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ayesa.project1.data.model.Product;
import com.ayesa.project1.data.repository.IProductRepository;
import com.ayesa.project1.services.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
private IProductRepository repo;
	
	public ProductServiceImpl(IProductRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	@Override
	public List<Product> findAll() {
		return this.repo.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {
		return this.repo.findById(id);
	}

	@Override
	public Product save(Product product) {
		return this.repo.save(product);
	}

	@Override
	public void deleteById(Long id) {
		this.repo.deleteById(id);
	}

	@Override
	public Boolean existsById(Long id) {
		return this.repo.existsById(id);
	}

	@Override
	public void deleteAll() {
		this.repo.deleteAll();
		
	}

	@Override
	public Product newEntity() {
		Product product = new Product();
		product.setDescription("Desconocido");
		return product;
	}

}
