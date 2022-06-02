package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Product;
import com.repository.ProductRepository;

@RestController
public class ProductResources {

	@Autowired
	ProductRepository spRepository;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAll(Model model){
		return ResponseEntity.ok(spRepository.findAll());
	}
//	Hiển thị sp theo id
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getById(@PathVariable("id") Integer id){
//		Kiểm tra kết quả trả về có tồn tại hay không
		if (!spRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(spRepository.findById(id).get());
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> postSanPham(@RequestBody Product sanpham){
//		Kiểm tra Id có tồn tại hay không	
//		if (spRepository.existsById(sanpham.getId())) {
//			return ResponseEntity.badRequest().build();
//		}
		spRepository.save(sanpham);
		return ResponseEntity.ok(sanpham);
	}
//	Update sản phẩm
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> putsanPham(@PathVariable("id") Integer id, @RequestBody Product sanpham){
		if (!spRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		spRepository.save(sanpham);
		return ResponseEntity.ok(sanpham);
	}
	
//	Delete sản phẩm:
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Void> deleteSanPham(@PathVariable("id") Integer id){
		if (!spRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		spRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
