package com.entities;

import com.entities.dtos.OrderDetailDto;
import com.entities.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "billdetails")
@Builder
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;
    @ManyToOne
    private DetailProduct detailProduct;
    @JoinColumn(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "price")
    private Double price;


}
