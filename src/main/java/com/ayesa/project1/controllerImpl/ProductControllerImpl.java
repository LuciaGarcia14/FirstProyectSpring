package com.ayesa.project1.controllerImpl;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ayesa.project1.controller.IProductController;
import com.ayesa.project1.services.IFamilyProductService;
import com.ayesa.project1.services.IProductService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.java.Log;

@Controller
@Log
public class ProductControllerImpl implements IProductController {

    private final IProductService service;
    private final IFamilyProductService familyProductService;
    
   public ProductControllerImpl(IProductService service, IFamilyProductService familyProductService) {
		super();
		this.service = service;
		this.familyProductService = familyProductService;
	}

    @Override
    @GetMapping("/productListGet")
    public String productListGet(
            Principal principal,
            Model model,
            HttpServletRequest request) {

        log.info("TRAZA: entrando en productListGet");

        model.addAttribute("productList", service.findAll());

        return "productList"; 
    }
}


