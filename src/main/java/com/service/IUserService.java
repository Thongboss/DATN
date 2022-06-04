package com.service;

import com.config.jwt.JwtLoginResponse;
import com.config.jwt.JwtUserLoginModel;
import com.entities.User;
import com.entities.models.UserModel;
import com.entities.models.UserRegisterModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface IUserService extends IBaseService<User, UserModel, Long> {

    Page<User> findAll(Specification specs, Pageable page);

    List<User> findAll(Specification specs);

    Page<User> search(String q, Pageable page);

    User findByUsername(String username);

    User registerAccount(UserRegisterModel userRegisterModel);

    boolean forgotPassword(String username);
    boolean resetPassword(String resetToken, String newPassword);
    boolean tokenFilter(String token, HttpServletRequest req);
    JwtLoginResponse login(JwtUserLoginModel userLogin);

    User getMyProfile();
}
