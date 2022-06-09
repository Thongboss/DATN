package com.entities.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bills")
@Builder
public class BillDetailModel {
    @Id
    @GeneratedValue
    @NotNull
    private int id;
    @NotNull
    private



}
