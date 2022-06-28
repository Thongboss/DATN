package com.web;

import java.util.List;

import com.entities.dtos.ProductDto;
import com.entities.dtos.ResponseDto;
import com.entities.models.ProductFilterModel;
import com.entities.models.ProductModel;
import com.repository.specifications.ProductSpecification;
import com.service.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Product;

@RestController
public class ProductResources {

    private final IProductService productService;

    public ProductResources(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseDto getAll(Pageable page) {
        return ResponseDto.of(this.productService.findAll(page).map(ProductDto::toDto), "Get all products");
    }

    //	Hiển thị sp theo id
    @GetMapping("/products/{id}")
    public ResponseDto getProduct(@PathVariable("id") long id) {
//		Kiểm tra kết quả trả về có tồn tại hay không
        return ResponseDto.of(ProductDto.toDto(this.productService.findById(id)), "Get product id: " + id);
    }

    @PostMapping("/products")
    public ResponseDto createProduct(@RequestBody ProductModel model) {
        model.setId(null);
        return ResponseDto.of(this.productService.add(model), "Add product");
    }

    //	Update sản phẩm
    @PutMapping("/products/{id}")
    public ResponseDto updateProduct(@PathVariable("id") Long id, @RequestBody ProductModel model) {
        model.setId(id);
        return ResponseDto.of(ProductDto.toDto(this.productService.update(model)), "Update product id: " + id);
    }

    //	Delete sản phẩm:
    @DeleteMapping("/products/{id}")
    public ResponseDto deleteProduct(@PathVariable("id") long id) {
        return ResponseDto.of(this.productService.deleteById(id), "Delete Product id: " + id);
    }

    @DeleteMapping("/products/buck/{ids}")
    public ResponseDto deleteBulkProducts(@PathVariable List<Long> ids) {
        return ResponseDto.of(this.productService.deleteByIds(ids), "Delete buck Products");
    }

    @PostMapping("products/filter")
    public ResponseDto filter(@RequestBody ProductFilterModel model, Pageable page) {
        Page<Product> productPage = this.productService.findAll(page, ProductSpecification.filter(model));
        return ResponseDto.of(productPage.map(ProductDto::toDto), "Filter products");
    }
    @GetMapping("/{id}")
    public ResponseDto getAll(@PathVariable Long id) {
        return ResponseDto.of(this.productService.getAllByCategory(id), "Get all products by category");
    }
}
