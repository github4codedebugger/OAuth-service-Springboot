package com.auth.controller;

import com.auth.controller.dto.UserDto;
import com.auth.entity.AuthUser;
import com.auth.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oauth/users")
public class UserController {

    @Autowired
    private AuthUserService authUserService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthUser register(@RequestBody UserDto userDto) {
        return authUserService.register(userDto);
    }

}
