package com.ayesa.project1.controller;

import java.security.Principal;

import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletRequest;

public interface IProductController {
	
	public String productListGet(Principal principal,
			Model model,
			HttpServletRequest request);
}
