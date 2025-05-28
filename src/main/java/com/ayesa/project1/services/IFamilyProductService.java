package com.ayesa.project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ayesa.project1.data.model.FamilyProduct;

@Service
public interface IFamilyProductService {
	public  List<FamilyProduct> findAll();
	public Optional<FamilyProduct> findById(Long id);
	
	public FamilyProduct save(FamilyProduct entity);
	public void deleteById(Long id);
	public Boolean existsById(Long id);
	public void deleteAll();
	public FamilyProduct newEntity();
}
