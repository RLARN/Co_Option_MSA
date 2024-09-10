package com.example.userservice.controller;

import com.example.userservice.model.userVO;
import com.example.userservice.service.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class userController {

    @Autowired
    private userRepository userService;

    @GetMapping("/{id}")
    public userVO getUser(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<userVO> getAllUsers() {
        return userService.getAllUsers();
    }

}