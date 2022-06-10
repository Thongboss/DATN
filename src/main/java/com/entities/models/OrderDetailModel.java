package com.entities.models;
import com.entities.DetailProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bills")
@Builder
public class OrderDetailModel {
    @Id
    @GeneratedValue
    @NotNull
    private Long id;
    @NotNull
    private Long id_order;
    @NotNull
    private Long id_detailProduct;
    @NotNull
    private Long quantity;
    @NotNull
    private Long price;

}
