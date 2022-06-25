package com.entities;

import javax.persistence.*;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name = "product_name",length =255, nullable = false)
	private String productName;
	
	@Column(name = "description",length =255, nullable = true)
	private String description;

	@Column(name = "status",length =100, nullable = true)
	private String status;

	@Column(name="price", nullable = false)
	private Double price;

	@Column(name="quantity", nullable = false)
	private Long quantity;

	@Column(name = "image", nullable = false)
	private String image;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	@ManyToOne
	@JoinColumn(name = "unit_id")
	private Unit unit;

	@ManyToOne
	@JoinColumn(name = "weight_id")
	private Weight weight;
}
