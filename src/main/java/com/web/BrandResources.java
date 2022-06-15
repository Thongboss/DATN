package com.web;

import com.entities.dtos.BrandDto;
import com.entities.dtos.ResponseDto;
import com.entities.models.BrandModel;
import com.service.IBrandService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("brands")
public class BrandResources {

    private final IBrandService brandService;

    public BrandResources(IBrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseDto getAll(Pageable page) {
        return ResponseDto.of(this.brandService.findAll(page).map(b-> BrandDto.toDto(b)), "Get all brands");
    }

    @GetMapping("{id}")
    public ResponseDto getBrand(@PathVariable long id) {
        return ResponseDto.of(BrandDto.toDto(this.brandService.findById(id)), "Get brand id: " + id);
    }

    @PostMapping
    private ResponseDto createBrand(@RequestBody BrandModel model) {
        model.setBrandId(null);
        return ResponseDto.of(BrandDto.toDto(this.brandService.add(model)), "Add brand");
    }

    @PutMapping("{id}")
    public ResponseDto updateBrand(@PathVariable long id, @RequestBody BrandModel model) {
        model.setBrandId(id);
        return ResponseDto.of(BrandDto.toDto(this.brandService.update(model)), "Update brand id: " + id);
    }

    @DeleteMapping("{id}")
    public ResponseDto deleteBrand(@PathVariable long id) {
        return ResponseDto.of(this.brandService.deleteById(id), "Delete brand id: " + id);
    }

    @DeleteMapping("buck/{ids}")
    public ResponseDto deleteBrands(@PathVariable List<Long> ids) {
        return ResponseDto.of(this.brandService.deleteByIds(ids), "Delete brands ids: " + ids);
    }

}
