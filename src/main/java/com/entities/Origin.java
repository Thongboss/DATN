package com.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "origin")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@Getter
public class Origin {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "country_code", nullable = false, length = 60, unique = true)
    private String countryCode;

    @Column(name = "country_name", nullable = false)
    private String countryName;
}
