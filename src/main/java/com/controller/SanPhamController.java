package com.controller;

import com.entities.models.ProductModel;
import com.repository.ProductRepository;

import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") //Mọi truy xuất bên ngoài vào được
@RestController
public class SanPhamController {

	@Autowired
    ProductRepository spRepository;

	@Autowired
	ProductService sanPhamService;

	@GetMapping("/sanpham")
	public ResponseEntity<List<ProductModel>> getAll(Model model){
		return ResponseEntity.ok(spRepository.findAll());
	}
//	Hiển thị sp theo id
	@GetMapping("/sanpham/{id}")
	public ResponseEntity<ProductModel> getById(@PathVariable("id") Integer id){
//		Kiểm tra kết quả trả về có tồn tại hay không
		if (!spRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(spRepository.findById(id).get());
	}

	@GetMapping("/sanpham/{danhMucId}")
	public ResponseEntity<List<ProductModel>> getByDanhMuc(@PathVariable("id") Integer id){
//		Kiểm tra kết quả trả về có tồn tại hay không
		List<ProductModel> danhSachSanPham = sanPhamService.getByCategory(id);
		if (danhSachSanPham.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(danhSachSanPham);
	}
	
	@PostMapping("/sanpham")
	public ResponseEntity<ProductModel> postSanPham(@RequestBody ProductModel sanpham){
//		Kiểm tra Id có tồn tại hay không	
		if (spRepository.existsById(sanpham.getId())) {
			return ResponseEntity.badRequest().build();
		}
		spRepository.save(sanpham);
		return ResponseEntity.ok(sanpham);
	}
//	Update sản phẩm
	@PutMapping("/sanpham/{id}")
	public ResponseEntity<ProductModel> putsanPham(@PathVariable("id") Integer id, @RequestBody ProductModel sanpham){
		if (!spRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		spRepository.save(sanpham);
		return ResponseEntity.ok(sanpham);
	}
	
//	Delete sản phẩm:
	@DeleteMapping("/sanpham/{id}")
	public ResponseEntity<Void> deleteSanPham(@PathVariable("id") Integer id){
		if (!spRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		spRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
