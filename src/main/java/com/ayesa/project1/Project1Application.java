package com.ayesa.project1;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ayesa.project1.data.model.Customer;
import com.ayesa.project1.data.model.FamilyProduct;
import com.ayesa.project1.data.model.Product;
import com.ayesa.project1.data.model.Users;
import com.ayesa.project1.services.ICustomerService;
import com.ayesa.project1.services.IFamilyProductService;
import com.ayesa.project1.services.IProductService;
import com.ayesa.project1.services.IUserService;

import lombok.extern.java.Log;

@SpringBootApplication
@Log
public class Project1Application {

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}
	
	@Bean
	CommandLineRunner runner(
		ICustomerService customerService,
		IFamilyProductService familyProductService,
		IProductService productService,
		IUserService userService
		)
	{
		return args -> {
			log.info("TRAZA: INICIO CARGA DATOS");
			//
			customerService.deleteAll();
			customerService.save(new Customer(null, "Ana Sanchez", "ana@gmail.com", "1238965655", "1234567812345678", LocalDate.now().plusYears(1)));
			customerService.save(new Customer(null, "Pepe Perez", "pepe@gmail.com", "45665156151", "5678123456781234", LocalDate.now().plusYears(2)));
			customerService.save(new Customer(null, "Juan Gonzalez", "juan@gmail.com", "789551515515", "9012345678123456", LocalDate.now().plusYears(3)));
			log.info("Tabla Customer contiene: " 
					+ customerService.findAll());
			//
			//
			familyProductService.deleteAll();
			familyProductService.save(new FamilyProduct(null, "ALIMENTACION", null));
			familyProductService.save(new FamilyProduct(null, "ELECTRONICA", null));
			familyProductService.save(new FamilyProduct(null, "TEXTIL", null));
			familyProductService.save(new FamilyProduct(null, "JOYERIA", null));
			familyProductService.save(new FamilyProduct(null, "PERFUMERIA", null));
			log.info("Tabla FamilyProduct contiene: " 
					+ familyProductService.findAll());
			//
			productService.deleteAll();
			productService.save(new Product(null, "Limones", "https://mdbootstrap.com/img/new/ecommerce/horizontal/084.jpg", 10.50, 100, 1, 0.0, familyProductService.findById(1L).get()));
			productService.save(new Product(null, "Almendras", "https://mdbootstrap.com/img/new/ecommerce/horizontal/085.jpg", 21.00, 200, 2, 10.0, familyProductService.findById(1L).get()));
			productService.save(new Product(null, "Pimientos", "https://mdbootstrap.com/img/new/ecommerce/horizontal/086.jpg", 5.50, 300, 3, 20.0, familyProductService.findById(1L).get()));
			productService.save(new Product(null, "Colonia", "https://mdbootstrap.com/img/new/ecommerce/horizontal/087.jpg", 50.00, 400, 4, 30.0, familyProductService.findById(5L).get()));
			productService.save(new Product(null, "Vestido", "https://mdbootstrap.com/img/new/ecommerce/horizontal/088.jpg", 70.50, 500, 5, 50.0, familyProductService.findById(3L).get()));
			productService.save(new Product(null, "Zapatos", "https://mdbootstrap.com/img/new/ecommerce/horizontal/089.jpg", 100.50, 600, 1, 100.0, familyProductService.findById(3L).get()));
			log.info("Tabla Product contiene: " 
					+ productService.findAll());
			//		
			
			//
			userService.deleteAll();
			userService.save(new Users(null, "Lolita14", "lolita@gmail.com", "6658489655565", "Lola Sanchez Carril", "Avd. Reino Unido", "123456789"));
			userService.save(new Users(null, "pedrito16", "pedrito@gmail.com", "565156511565", "Pedro Sanchez Muñoz", "Avd. De la paz", "123456789"));
			userService.save(new Users(null, "LuisGF", "luis@gmail.com", "5216545621654", "Luis Garcia Martin", "Avd. Montequinto", "123456789"));
			log.info("Tabla Customer contiene: " 
					+ userService.findAll());
			
			log.info("TRAZA: FIN CARGA DATOS");

		};
	}

}
