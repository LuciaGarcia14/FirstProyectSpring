package com.ayesa.project1.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ayesa.project1.data.model.FamilyProduct;
import com.ayesa.project1.data.repository.IFamilyProductRepository;
import com.ayesa.project1.services.IFamilyProductService;

@Service
public class FamilyProductServiceImpl implements IFamilyProductService{
private IFamilyProductRepository repo;
	
	public FamilyProductServiceImpl(IFamilyProductRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	@Override
	public List<FamilyProduct> findAll() {
		return this.repo.findAll();
	}

	@Override
	public Optional<FamilyProduct> findById(Long id) {
		return this.repo.findById(id);
	}

	@Override
	public FamilyProduct save(FamilyProduct familyProduct) {
		return this.repo.save(familyProduct);
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
	public FamilyProduct newEntity() {
		FamilyProduct familyProduct = new FamilyProduct();
		familyProduct.setName("Desconocido");
		return familyProduct;
	}

}
