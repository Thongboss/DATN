package com.controller;

import com.entities.models.DanhMuc;
import com.repository.DanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") //Mọi truy xuất bên ngoài vào được
@RestController
public class DanhMucController {
	
	@Autowired
	DanhMucRepository danhMucRepository;
	
	@GetMapping("/danhmuc")
	public ResponseEntity<List<DanhMuc>> getAll(Model model){
		return ResponseEntity.ok(danhMucRepository.findAll());
	}
	
	@GetMapping("/danhmuc/{id}")
	public ResponseEntity<DanhMuc> getById(@PathVariable("id") Integer id){
//	Kiểm tra kết quả trả về có tồn tại hay không
		if (!danhMucRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(danhMucRepository.findById(id).get());
	}
	
	@PostMapping("/danhmuc")
	public ResponseEntity<DanhMuc> postDanhMuc(@RequestBody DanhMuc danhmuc){
//		Kiểm tra Id có tồn tại hay không
		if(danhMucRepository.existsById(danhmuc.getId())) {
			return ResponseEntity.badRequest().build();
		}
		danhMucRepository.save(danhmuc);
		return ResponseEntity.ok(danhmuc);
	}
	
	@PutMapping("/danhmuc/{id}")
	public ResponseEntity<DanhMuc> putDanhMuc(@PathVariable("id") Integer id,@RequestBody DanhMuc danhmuc){
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

