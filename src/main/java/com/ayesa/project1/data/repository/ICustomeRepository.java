package com.ayesa.project1.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayesa.project1.data.model.Customer;

@Repository
public interface ICustomeRepository extends JpaRepository<Customer, Long> {
	
	//SELECT * FROM WHERE FULLNAME = XXX OR PHONENUMBER = YYY;
	List<Customer> findByFullnameOrPhoneNumber(String fullname, String phoneNumber);
}
