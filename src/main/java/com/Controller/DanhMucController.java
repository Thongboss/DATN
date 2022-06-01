package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Categories;
import com.repository.DanhMucRepository;

@CrossOrigin("*") //Mọi truy xuất bên ngoài vào được
@RestController
public class DanhMucController {
	
	@Autowired
	DanhMucRepository danhMucRepository;
	
	@GetMapping("/danhmuc")
	public ResponseEntity<List<Categories>> getAll(Model model){
		return ResponseEntity.ok(danhMucRepository.findAll());
	}
	
	@GetMapping("/danhmuc/{id}")
	public ResponseEntity<Categories> getById(@PathVariable("id") Integer id){
//	Kiểm tra kết quả trả về có tồn tại hay không
		if (!danhMucRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(danhMucRepository.findById(id).get());
	}
	
	@PostMapping("/danhmuc")
	public ResponseEntity<Categories> postDanhMuc(@RequestBody Categories danhmuc){
//		Kiểm tra Id có tồn tại hay không
		if(danhMucRepository.existsById(danhmuc.getId())) {
			return ResponseEntity.badRequest().build();
		}
		danhMucRepository.save(danhmuc);
		return ResponseEntity.ok(danhmuc);
	}
	
	@PutMapping("/danhmuc/{id}")
	public ResponseEntity<Categories> putDanhMuc(@PathVariable("id") Integer id,@RequestBody Categories danhmuc){
		if (!danhMucRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		danhMucRepository.save(danhmuc);
		return ResponseEntity.ok(danhmuc);
	}
	
	@DeleteMapping("/danhmuc/{id}")
	public ResponseEntity<Void> deleteDanhMuc(@PathVariable("id") Integer id){
		if (!danhMucRepository.existsById(id)) {
			return 	ResponseEntity.notFound().build();
		}
			danhMucRepository.deleteById(id);
			return ResponseEntity.ok().build();
	}
}

