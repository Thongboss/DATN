package com.entities;

import com.entities.dtos.BillDto;
import com.entities.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bills")
@Builder
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codeBill")
    private String codeBill;
    @Column(name = "dateFounded")
    private Date dateFounded;
    @Column(name = "totalMoney")
    private float totalMoney;
    @Column(name = "note")
    private String note;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(table = "users_id", name = "ID")
    private User user;
    @Column(name = "payments")
    private String payments;
    @Column(name="phoneNumber")
    private String phoneNumber;
    @Column(name = "phoneNumber")
    private String address;

    public Bill toEntity(BillDto dto) {
        if (dto == null) {
            throw new RuntimeException("Entity is null");
        }
        return Bill.builder()
                .codeBill(dto.getCodeBill())
                .dateFounded(dto.getDateFounded())
                .totalMoney(dto.getTotalMoney())
                .note(dto.getNote())
                .status(dto.getStatus())
                .user(User.toEntity(dto.getUser()))
                .payments(dto.getPayments())
                .phoneNumber(dto.getPhoneNumber())
                .address(dto.getAddress())
                .build();
    }
}
