package com.web;

import com.entities.ProductDetail;
import com.entities.dtos.ProductDetailDto;
import com.entities.dtos.ProductDto;
import com.entities.dtos.ResponseDto;
import com.entities.models.ProductDetailModel;
import com.entities.models.ProductModel;
import com.service.IProductDetailService;
import com.service.IProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("productsDetails")
public class ProductDetailResources {

    private final IProductDetailService productDetailService;

    public ProductDetailResources(IProductDetailService productService) {
        this.productDetailService = productService;
    }

    @GetMapping
    public ResponseDto getAll(Pageable page) {
        return ResponseDto.of(this.productDetailService.findAll(page).map(ProductDetailDto::toDto), "Get all products");
    }

    //	Hiển thị sp theo id
    @GetMapping("/{id}")
    public ResponseDto getProductDetail(@PathVariable("id") long id) {
//		Kiểm tra kết quả trả về có tồn tại hay không
        return ResponseDto.of(ProductDetailDto.toDto(this.productDetailService.findById(id)), "Get product id: " + id);
    }

    @PostMapping
    public ResponseDto createProductDetail(ProductDetailModel model) {
        model.setProductDetailId(null);
        return ResponseDto.of(this.productDetailService.add(model), "Add product");
    }

    //	Update sản phẩm
    @PutMapping("{id}")
    public ResponseDto updateProductDetail(@PathVariable("id") long id, ProductDetailModel model) {
        model.setProductDetailId(id);
        return ResponseDto.of(ProductDetailDto.toDto(this.productDetailService.update(model)), "Update product id: " + id);
    }

    //	Delete sản phẩm:
    @DeleteMapping("{id}")
    public ResponseDto deleteProductDetail(@PathVariable("id") long id) {
        return ResponseDto.of(this.productDetailService.deleteById(id), "Delete Product id: " + id);
    }

    @DeleteMapping("buck/{ids}")
    public ResponseDto deleteBulkProductDetails(@PathVariable List<Long> ids) {
        return ResponseDto.of(this.productDetailService.deleteByIds(ids), "Delete buck Products");
    }
}
