package com.ayesa.project1.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayesa.project1.data.model.Users;



public interface IUsersRepository extends JpaRepository<Users, Long>{

}
