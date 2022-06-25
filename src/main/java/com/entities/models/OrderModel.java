package com.entities.models;

import com.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderModel {
    private Long id;
    private String orderGuid;
    private String note;
    @NotNull
    @NotBlank
    private String paymentMethod;
    @NotNull
    @NotBlank
    private String phoneNumber;
    @NotNull
    @NotBlank
    private String address;

    private String DeliveryCode;

    @NotNull
    private List<OrderDetailModel> orderDetails;

    public Order toEntity(OrderModel model) {
        if (model == null) {
            throw new RuntimeException("Entity is null");
        }
        return Order.builder()
                .id(model.getId())
                .orderGuid(model.getId() != null ? model.getOrderGuid() : UUID.randomUUID().toString())
                .note(model.getNote())
                .paymentMethod(model.getPaymentMethod())
                .phoneNumber(model.getPhoneNumber())
                .address(model.getAddress())
                .DeliveryCode(model.getDeliveryCode())
                .build();
    }

}
