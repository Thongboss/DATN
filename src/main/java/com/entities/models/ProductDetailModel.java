package com.entities.models;

import com.entities.ProductDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetailModel {
    private Long productDetailId;

    @NotNull
    private Long productParent;
    @NotNull
    private Double oldPrice;
    @NotNull
    private Double newPrice;

    @NotNull
    private MultipartFile image;

    private Integer productRemain = 0;
    @NotNull
    private Long category;
    @NotNull
    private Long brand;
    @NotNull
    private Long country;
    @NotNull
    private Long unit;
    @NotNull
    private Long weight;

    public static ProductDetail toEntity(ProductDetailModel model){
        if(model == null) throw new RuntimeException("ProductDetailModel is null");
        return ProductDetail.builder()
                .productDetailId(model.getProductDetailId())
                .oldPrice(model.getOldPrice())
                .newPrice(model.getNewPrice())
                .build();
    }
}
