package com.ayesa.project1.data.model;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//@Table(name = "MyCustomer") //le dará el nombre que quieras a la tabla
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoIncrement
	private Long id;
	
	@Column(name = "FULLNAME", nullable = false, columnDefinition = "VARCHAR(200) CHECK((LENGTH(FULLNAME) >= 3) AND (LENGTH(FULLNAME) <=200))" )
	@NotNull
	@Size(min = 3, max = 200, message = "must have from 3 to 200 chars")
	private String fullname; //camel case 
	
	@Email
	private String email;
	
	@NotNull
	@Size(min = 9, max = 20, message = "must have from 9 to 20 chars")
	private String phoneNumber;
	
	@Column(nullable = false, columnDefinition = "CHAR(16)")
	@Size(min = 16, max = 16, message = "must have 16 digits")
	private String creditCardNumber;
	
	@DateTimeFormat
	private LocalDate creditCardExpiry;
	
}
