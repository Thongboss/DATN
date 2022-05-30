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
@Table(name = "SanPham")
public class SanPham {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name = "Tensp",length =255, nullable = false)
	private String Tensp;
	
	@Column(name = "Ghichu",length =255, nullable = true)
	private String Ghichu;
	
	@Column(name = "Trangthai",length =255, nullable = false)
	private String Trangthai;
	
	
	
}
