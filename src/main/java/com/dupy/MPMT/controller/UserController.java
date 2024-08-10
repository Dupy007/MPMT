package com.dupy.MPMT.controller;

import com.dupy.MPMT.exception.EntityNotFoundException;
import com.dupy.MPMT.model.User;
import com.dupy.MPMT.service.UserService;
import com.dupy.MPMT.utils.Func;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    private User user;

    @GetMapping("/user")
    public List<User> users(@RequestHeader(HttpHeaders.AUTHORIZATION) String auth) {
        Func.canAcces(userService, auth);
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User user(@PathVariable int id, @RequestHeader(HttpHeaders.AUTHORIZATION) String auth) {
        Func.canAcces(userService, auth);
        user = userService.find(id);
        if (user != null) {
            return user;
        }
        throw new EntityNotFoundException();
    }


}
