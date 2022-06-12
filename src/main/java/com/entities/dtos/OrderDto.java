package com.entities.dtos;


import com.entities.Orders;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderDto {
    private String codeOrder;

    private Date dateFounded;

    private Float totalMoney;

    private String note;

    private String status;

    private UserDto user;

    private String payments;

    private String phoneNumber;

    private String address;

    public OrderDto toDto(Orders entity) {
        if (entity == null) {
            throw new RuntimeException("Entity is null");
        }
        return OrderDto.builder()
                .codeOrder(entity.getCodeOrder())
                .dateFounded(entity.getDateFounded())
                .totalMoney(entity.getTotalMoney())
                .note(entity.getNote())
                .status(entity.getStatus())
                .user(UserDto.toDto(entity.getUser()))
                .payments(entity.getPayments())
                .phoneNumber(entity.getPhoneNumber())
                .address(entity.getAddress())
                .build();
    }
}
