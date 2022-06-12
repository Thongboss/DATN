package com.entities;

import com.entities.dtos.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bills")
@Builder
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codeOrder",unique = true)
    private String codeOrder;
    @Column(name = "dateFounded")
    private Date dateFounded;
    @Column(name = "totalMoney")
    private Float totalMoney;
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
    @Column(name = "address")
    private String address;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "detailProduct")
    List<OrderDetail> billDetailList ;

    public Orders toEntity(OrderDto dto) {
        if (dto == null) {
            throw new RuntimeException("Entity is null");
        }
        return Orders.builder()
                .codeOrder(dto.getCodeOrder())
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
