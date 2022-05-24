package com.entities;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "authorities")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class Authority implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "authority_name", nullable = false, length = 20, unique = true)
    private String authorityName;

}
