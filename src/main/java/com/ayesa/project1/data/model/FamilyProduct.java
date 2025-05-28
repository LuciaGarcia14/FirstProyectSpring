package com.ayesa.project1.data.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class FamilyProduct implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(nullable = false, columnDefinition = "VARCHAR(200) CHECK((LENGTH(name) >= 1) AND (LENGTH(name) <=200)) " )
	@Size(min = 1, max = 200, message = "must have from 1 to 200 chars")
	private String name;

	@ToString.Exclude
	@OneToMany(mappedBy = "familyProduct") //FetchType.LAZY
	private List<Product> productList;
	
	
	
}

