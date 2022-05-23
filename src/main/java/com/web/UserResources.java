package com.web;

import com.config.jwt.JwtUserLoginModel;
import com.entities.User;
import com.entities.dtos.ResponseDto;
import com.entities.dtos.UserDto;
import com.entities.models.UserModel;
import com.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserResources {

    private final IUserService userService;

    // autowired by constructor
    public UserResources(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseDto getAll(Pageable page) {
        Page<User> userPage = this.userService.findAll(page); // page use entity
        Page<UserDto> userDtosPage = userPage.map(user -> {
            return UserDto.toDto(user);
        });
        // convert qua userDto page
        return ResponseDto.of(userDtosPage, "Get all users");
    }

    @PostMapping
    public ResponseDto add(@RequestBody UserModel userModel) {
        return ResponseDto.of(this.userService.add(userModel), "Add new user");
    }

    @PostMapping("login")
    public ResponseDto login(@RequestBody JwtUserLoginModel userLoginModel) {
        System.out.println("login");
        return ResponseDto.of(this.userService.login(userLoginModel), userLoginModel.getUsername() + " Login");
    }
}
