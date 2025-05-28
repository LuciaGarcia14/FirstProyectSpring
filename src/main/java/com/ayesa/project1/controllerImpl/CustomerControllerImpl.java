package com.ayesa.project1.controllerImpl;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ayesa.project1.controller.ICustomerController;
import com.ayesa.project1.services.ICustomerService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.java.Log;

@Controller
@Log
public class CustomerControllerImpl implements ICustomerController {
	
	private final ICustomerService service;
    
	public CustomerControllerImpl(ICustomerService service) {
		super();
		this.service = service;
	}

	@Override
	@GetMapping("/customerListGet")
	public String customerListGet(
			Principal principal,
			Model model,
			HttpServletRequest request) {

		log.info("TRAZA: entrando en customerListGet");

		model.addAttribute("customerList", service.findAll());

		return "customerList"; 
	}
}


