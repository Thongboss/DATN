package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Products")
public class Product {
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name = "product_name",length =255, nullable = false)
	private String productName;
	
	@Column(name = "description",length =255, nullable = true)
	private String description;
}
