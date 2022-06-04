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

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserResources {

    private final IUserService userService;

    // autowired by constructor
    public UserResources(IUserService userService) {
        this.userService = userService;
    }

    @Transactional
    @GetMapping
    public ResponseDto getAll(Pageable page) {
        Page<User> userPage = this.userService.findAll(page); // page use entity
        Page<UserDto> userDtosPage = userPage.map(user -> {
            return UserDto.toDto(user);
        });
        // convert qua userDto page
        return ResponseDto.of(userDtosPage, "Get all users");
    }

    @Transactional
    @GetMapping("{id}")
    public ResponseDto getUser(@PathVariable long id) {
        return ResponseDto.of(UserDto.toDto(this.userService.findById(id)), "Get user id: " + id);
    }

    @GetMapping("my-profile")
    public ResponseDto getMyProfile(){
        return ResponseDto.of(UserDto.toDto(this.userService.getMyProfile()), "Get my profile");
    }

    @PostMapping
    public ResponseDto add(@RequestBody UserModel userModel) {
        return ResponseDto.of(UserDto.toDto(this.userService.add(userModel)), "Add new user");
    }

    @Transactional
    @PutMapping("{id}")
    public ResponseDto update(@PathVariable long id, @RequestBody UserModel userModel) {
        userModel.setId(id);
        return ResponseDto.of(this.userService.update(userModel), "Update user id: " + id);
    }

    @DeleteMapping("{id}")
    public ResponseDto delete(@PathVariable long id) {
        return ResponseDto.of(this.userService.deleteById(id), "Delete user id: " + id);
    }
    @DeleteMapping("buck/{ids}")
    public ResponseDto deleteBuck(@PathVariable List<Long> ids) {
        return ResponseDto.of(this.userService.deleteByIds(ids), "Delete users ids: " + ids);
    }


    @PostMapping("login")
    public ResponseDto login(@RequestBody JwtUserLoginModel userLoginModel) {
        return ResponseDto.of(this.userService.login(userLoginModel), userLoginModel.getUsername() + " Login");
    }
}
