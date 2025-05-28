package com.ayesa.project1.services;

import java.util.List;
import java.util.Optional;

import com.ayesa.project1.data.model.Users;



public interface IUserService {
	public  List<Users> findAll();
	public Optional<Users> findById(Long id);
	
	public Users save(Users entity);
	public void deleteById(Long id);
	public Boolean existsById(Long id);
	public void deleteAll();
	public Users newEntity();
}
