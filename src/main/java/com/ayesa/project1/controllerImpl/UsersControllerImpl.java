package com.ayesa.project1.controllerImpl;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ayesa.project1.controller.IUsersController;
import com.ayesa.project1.services.IUserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.java.Log;

@Controller
@Log
public class UsersControllerImpl implements IUsersController{

	private final IUserService service;
    
	public UsersControllerImpl(IUserService service) {
		super();
		this.service = service;
	}

	@Override
	@GetMapping("/usersListGet")
	public String usersListGet(
			Principal principal,
			Model model,
			HttpServletRequest request) {

		log.info("TRAZA: entrando en usersListGet");

		model.addAttribute("usersList", service.findAll());

		return "usersList"; 
	}
}
