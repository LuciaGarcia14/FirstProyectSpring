package com.ayesa.project1.controller;

import java.security.Principal;

import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletRequest;

public interface ICustomerController {
	public String customerListGet(Principal principal,
			Model model,
			HttpServletRequest request);

}
