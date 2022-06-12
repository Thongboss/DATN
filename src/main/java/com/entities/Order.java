package com.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bills")
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_guid",unique = true)
    private String orderGuid;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_date")
    private Date updatedDate;
    @Column(name = "totalMoney")
    private Double totalMoney;
    @Column(name = "note")
    private String note;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdUser;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "order")
    private List<OrderDetail> orderDetails ;

}
