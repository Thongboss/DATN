package com.entities;

import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Table(name = "brands")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@Getter
public class Brand {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "code", nullable = false, length = 60, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "note", length = 255)
    private String note;

    @Column(name = "status")
    private Boolean status = false;
}
