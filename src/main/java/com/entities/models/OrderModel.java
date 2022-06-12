package com.entities.models;

import com.entities.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codeOder;
    @NotNull
    private Date dateFounded;
    @NotNull
    private Float totalMoney;

    private String note;
    @NotNull
    private String status;
    @NotNull
    private Orders id_User;
    @NotNull
    private String payments;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String address;

}
