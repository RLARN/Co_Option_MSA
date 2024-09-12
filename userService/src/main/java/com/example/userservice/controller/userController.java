package com.example.userservice.controller;

import com.example.userservice.model.userVO;
import com.example.userservice.service.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/api/users")
public class userController {

    @Autowired
    private userRepository userService;

    @PostMapping("/createEvent")
    public void createEvent() throws GeneralSecurityException, IOException {
        userService.createEvent();
        System.out.println();
    }
    @GetMapping("/{id}")
    public userVO getUser(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<userVO> getAllUsers() {
        return userService.getAllUsers();
    }

}