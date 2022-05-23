package com.entities.models;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class UserModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String password;

	private String fullname;

	private String email;

	private Date createdDate;

	private Boolean status = true;

	private String avatar;

	private String description;

	private Integer loginFailed = 0;

	private List<Integer> authority;
}