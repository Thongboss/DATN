package com.entities.dtos;


import com.entities.Bill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BillDto {
    private String codeBill;

    private Date dateFounded;

    private float totalMoney;

    private String note;

    private String status;

    private UserDto user;

    private String payments;

    private String phoneNumber;

    private String address;

    public BillDto toDto(Bill entity) {
        if (entity == null) {
            throw new RuntimeException("Entity is null");
        }
        return BillDto.builder()
                .codeBill(entity.getCodeBill())
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
