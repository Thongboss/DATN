package com.controller;

import com.entities.models.CTSanPhamModel;
import com.repository.CTSanPhamRepository;
import com.service.CTSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") //Mọi truy xuất bên ngoài vào được
@RestController
public class CTSanPhamController {

    @Autowired
    CTSanPhamRepository ctSanPhamRepository;


    @GetMapping("/ct-sanpham")
    public ResponseEntity<List<CTSanPhamModel>> getAll(Model model){
        return ResponseEntity.ok(ctSanPhamRepository.findAll());
    }

    @GetMapping("/ct-sanpham/{id}")
    public ResponseEntity<CTSanPhamModel> getById(@PathVariable("id") Integer id){
//	Kiểm tra kết quả trả về có tồn tại hay không
        if (!ctSanPhamRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ctSanPhamRepository.findById(id).get());
    }

    @PostMapping("/ct-sanpham")
    public ResponseEntity<CTSanPhamModel> postCTSanPham(@RequestBody CTSanPhamModel ctSanPham){
//		Kiểm tra Id có tồn tại hay không
        if(ctSanPhamRepository.existsById(ctSanPham.getId())) {
            return ResponseEntity.badRequest().build();
        }
        ctSanPhamRepository.save(ctSanPham);
        return ResponseEntity.ok(ctSanPham);
    }

    @PutMapping("/ct-sanpham/{id}")
    public ResponseEntity<CTSanPhamModel> putCTSanPham(@PathVariable("id") Integer id,@RequestBody CTSanPhamModel ctSanPham){
        if (!ctSanPhamRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ctSanPhamRepository.save(ctSanPham);
        return ResponseEntity.ok(ctSanPham);
    }

    @DeleteMapping("/ct-sanpham/{id}")
    public ResponseEntity<Void> deleteCTSanPham(@PathVariable("id") Integer id){
        if (!ctSanPhamRepository.existsById(id)) {
            return 	ResponseEntity.notFound().build();
        }
        ctSanPhamRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
