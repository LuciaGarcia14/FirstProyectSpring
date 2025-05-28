package com.ayesa.project1.data.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@NotNull
	@Column(nullable = false, columnDefinition = "VARCHAR(200) CHECK((LENGTH(description) >= 3) AND (LENGTH(description) <=200)) " )
	@Size(min = 3, max = 200, message = "must have from 3 to 200 chars")
	private String description;
	
	@Size(min = 5, max = 200, message = "must have from 5 to 200 chars")
	@Column(columnDefinition = "VARCHAR(200) CHECK((LENGTH(URL) >= 5) AND (LENGTH(URL) <=200))" )
	private String url;
	
	@DecimalMax(value = "999.99", message = "must value less or equal to 999.99")
	@DecimalMin(value = "0", message = "must value greater or equial to 0")
	@NotNull
	@Column(columnDefinition = "DECIMAL(5,2) DEFAULT 0 CHECK((PRICE >= 0) AND (PRICE <= 99999))")
	private Double price;
	
	@NotNull
	@Max(value = 99999, message = "must value less or equal to 99999")
	@Min(value = 0, message = "must value greater or equal to 0")
	@Column(columnDefinition = "INT NOT NULL DEFAULT 0 CHECK((STOCK >= 0) AND (STOCK <= 99999))")
	private Integer stock;
	
	
	@NotNull
	@Max(value = 5, message = "must value less or equal to 5")
	@Min(value = 1, message = "must value greater or equal to 1")
	@Column(columnDefinition = "INT NOT NULL DEFAULT 3 CHECK((valuation >= 1) AND (valuation <= 5))")
	private Integer valuation;
	
	
	@NotNull
	@DecimalMax(value = "100.0", message = "must value less or equal to 100.0")
	@DecimalMin(value = "0", message = "must value greater or equal to 0")
	@Column(columnDefinition = "DECIMAL(5,2)  NOT NULL DEFAULT 0 CHECK((discount >= 0) AND (discount <= 100.00))")
	private Double discount;
	
	@ToString.Exclude
	@ManyToOne //(fetch = FetchType.EAGER) 
	private FamilyProduct familyProduct;
}
