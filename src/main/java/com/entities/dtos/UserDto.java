package com.entities.dtos;

import com.entities.Authority;
import com.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;

    private String username;

    private String fullname;

    private String email;

    private Date createdDate;

    private Boolean status = false;

    private String avatar;

    private String description;

    private Integer loginFailed = 0;

    private Set<Authority> authorityFilter;
    //Entity to Dto
    public static UserDto toDto(User entity) {
        if (entity == null) throw new RuntimeException("Entity is null");
        return UserDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .avatar(entity.getAvatar())
                .createdDate(entity.getCreatedDate())
                .build();
    }

}
