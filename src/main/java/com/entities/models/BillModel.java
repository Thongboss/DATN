package com.entities.models;

import com.entities.Bill;
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
public class BillModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codeBill;
    @NotNull
    private Date dateFounded;
    @NotNull
    private float totalMoney;

    private String note;
    @NotNull
    private String status;
    @NotNull
    private Bill id_User;
    @NotNull
    private String payments;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String address;

}
