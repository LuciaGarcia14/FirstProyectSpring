package com.ayesa.project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ayesa.project1.data.model.Customer;

@Service
public interface ICustomerService {
	
	public  List<Customer> findAll();
	public Optional<Customer> findById(Long id);
	
	public Customer save(Customer entity);
	public void deleteById(Long id);
	public Boolean existsById(Long id);
	public void deleteAll();
	public Customer newEntity();
}
