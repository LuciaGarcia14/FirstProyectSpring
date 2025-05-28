package com.ayesa.project1.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ayesa.project1.data.model.Customer;
import com.ayesa.project1.data.model.Users;
import com.ayesa.project1.data.repository.IUsersRepository;
import com.ayesa.project1.services.IUserService;

@Service
public class UsersServiceImpl implements IUserService {
	
	private IUsersRepository repo;
	
	public UsersServiceImpl(IUsersRepository repo) {
		super();
		this.repo = repo;
	}
	
	@Override
	public List<Users> findAll() {
		return this.repo.findAll();
	}

	@Override
	public Optional<Users> findById(Long id) {
		// TODO Auto-generated method stub
		return this.repo.findById(id);
	}

	@Override
	public Users save(Users users) {
		return this.repo.save(users);
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
	public Users newEntity() {
		Users users = new Users();
		users.setFullname("Desconocido");
		return users;
	}

}
