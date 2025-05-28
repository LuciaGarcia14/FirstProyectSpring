package com.ayesa.project1.data.model;

import java.io.Serializable;
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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Users implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoIncrement
	private Long id;
	
	@Column(nullable = false, columnDefinition = "VARCHAR(200) CHECK((LENGTH(USERNAME) >= 3) AND (LENGTH(USERNAME) <=200))" )
	@NotNull
	@Size(min = 3, max = 200, message = "must have from 3 to 200 chars")
	private String username; 
	
	@Email
	private String email;
	
	@NotNull
	@Size(min = 9, max = 20, message = "must have from 9 to 20 chars")
	private String phoneNumber;
	
	@Column(nullable = false, columnDefinition = "VARCHAR(200) CHECK((LENGTH(FULLNAME) >= 3) AND (LENGTH(FULLNAME) <=200))" )
	@NotNull
	@Size(min = 3, max = 200, message = "must have from 3 to 200 chars")
	private String fullname;
	
	@Column(nullable = false, columnDefinition = "VARCHAR(200) CHECK((LENGTH(ADRESS) >= 3) AND (LENGTH(ADRESS) <=200))" )
	@NotNull
	@Size(min = 3, max = 200, message = "must have from 3 to 200 chars")
	private String adress;
	
	@Column(nullable = false, columnDefinition = "VARCHAR(100) CHECK((LENGTH(PASSWORD) >= 8) AND (LENGTH(PASSWORD) <=100))")
	@NotNull
	@Size(min = 8, max = 100, message = "Password must have between 8 and 100 characters")
	private String password;

}
