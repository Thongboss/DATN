package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products")
public class Product {
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name = "name",length =255, nullable = false)
	private String name;
	
	@Column(name = "note",length =255, nullable = true)
	private String note;
	
	@Column(name = "status",length =255, nullable = false)
	private String status;
	
	
	
}
