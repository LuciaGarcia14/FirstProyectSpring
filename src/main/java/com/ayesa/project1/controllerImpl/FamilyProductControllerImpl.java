package com.ayesa.project1.controllerImpl;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ayesa.project1.controller.IFamilyProductController;
import com.ayesa.project1.services.IFamilyProductService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.java.Log;

@Controller
@Log
public class FamilyProductControllerImpl implements IFamilyProductController  {
	
	private IFamilyProductService service;
	 
	public FamilyProductControllerImpl(IFamilyProductService service) {
		super();
		this.service = service;
	}
 
	@Override
	@GetMapping("/familyProductListGet")
	public String familyProductListGet(
			Principal principal,
			Model model,
			HttpServletRequest request) {
		System.out.println("TRAZA: entrando en familyProductListGet");
		log.info("TRAZA: entrando en familyProductListGet");
 
		model.addAttribute("familyProductList", service.findAll());
 
		return "familyProductList";
	}
	
	@Override
	@GetMapping("/familyProductViewGet/{id}")
	public String familyProductViewGet(
			@PathVariable(name= "id") Long id,
			Principal principal,
			Model model,
			HttpServletRequest request) {
		
		log.info("TRAZA: entrando en familyProductViewGet");
		model.addAttribute("familyProduct", service.findById(id).get());
		
		return "familyProductViewGet";
	}

	
	
}