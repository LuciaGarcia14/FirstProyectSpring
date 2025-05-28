package com.ayesa.project1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;
import java.security.*;


@Controller
public interface IFamilyProductController {
	
	public String familyProductListGet(Principal principal,
			Model model,
			HttpServletRequest request);
	
	public String familyProductViewGet(
			Long id, Principal principal, Model model, HttpServletRequest request);
	
}
