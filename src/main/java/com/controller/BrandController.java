package com.controller;

import com.entities.dtos.BrandDto;
import com.entities.dtos.ResponseDto;
import com.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class BrandController {

    @Autowired
    private BrandService service;

    @GetMapping("/brands/all")
    public ResponseDto getAll(){
        return service.getAll();
    }

    @PostMapping("/brands")
    public ResponseDto postBrand(@RequestBody BrandDto dto){
        return service.insert(dto);
    }

    @PutMapping("/brands/{id}")
    public ResponseDto putBrand(@PathVariable("id") Long id, @RequestBody BrandDto dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/brands/{id}")
    public ResponseDto deleteById(@PathVariable("id") Long id){

        return service.deleteById(id);
    }
}
