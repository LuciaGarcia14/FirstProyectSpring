package com.ayesa.project1.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ayesa.project1.data.model.Customer;
import com.ayesa.project1.data.repository.ICustomeRepository;
import com.ayesa.project1.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	private ICustomeRepository repo;
	
	public CustomerServiceImpl(ICustomeRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	@Override
	public List<Customer> findAll() {
		return this.repo.findAll();
	}

	@Override
	public Optional<Customer> findById(Long id) {
		return this.repo.findById(id);
	}

	@Override
	public Customer save(Customer customer) {
		return this.repo.save(customer);
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
	public Customer newEntity() {
		Customer customer = new Customer();
		customer.setFullname("Desconocido");
		return customer;
	}

}
