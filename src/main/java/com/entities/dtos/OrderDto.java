package com.entities.dtos;

import com.entities.Order;
import com.entities.models.OrderDetailModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    private String orderGuid;
    private Double totalMoney;
    private String note;
    private String status;
    private String paymentMethod;
    private String phoneNumber;
    private String address;
    private List<OrderDetailDto> orderDetails;
    private Date createdDate;
    private Date updatedDate;
    private String DeliveryCode;

    private static OrderDto toDto(Order entity) {
        if (entity == null) {
            return null;
        }
        return OrderDto.builder()
                .id(entity.getId())
                .orderGuid(entity.getOrderGuid())
                .totalMoney(entity.getTotalMoney())
                .note(entity.getNote())
                .status(entity.getStatus())
                .paymentMethod(entity.getPaymentMethod())
                .phoneNumber(entity.getPhoneNumber())
                .address(entity.getAddress())
                .orderDetails(entity.getOrderDetails().stream().map(OrderDetailDto::toDto).collect(Collectors.toList()))
                .createdDate(entity.getCreatedDate())
                .updatedDate(entity.getUpdatedDate())
                .DeliveryCode(entity.getDeliveryCode())
                .build();
    }

}
