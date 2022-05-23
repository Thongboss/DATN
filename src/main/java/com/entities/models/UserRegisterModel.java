package com.entities.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class UserRegisterModel {
    private String username;

    private String password;

    private String fullname;

    private String email;
}
