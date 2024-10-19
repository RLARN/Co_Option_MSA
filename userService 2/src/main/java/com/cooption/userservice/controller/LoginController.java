package com.cooption.userservice.controller;

import com.cooption.userservice.service.UserService;
import com.cooption.userservice.vo.UserVO;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/coOption")
public class LoginController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody String loginRequest, HttpServletRequest request) throws GeneralSecurityException, IOException{
        
    	Map<String, String> responseBody = new HashMap<>();
    	ObjectMapper mapper = new ObjectMapper();
    	UserVO parsinguserVO = mapper.readValue(loginRequest, UserVO.class);
    	UserVO userVO = userService.isValidUser(parsinguserVO);
    	// 로그인 처리 로직
        if (userVO == null) {  // 유효한 사용자 확인
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
        }else {

            responseBody.put("userId", userVO.getUserId());
            responseBody.put("userName", userVO.getUserName());

            return ResponseEntity.ok(responseBody);
        }

        
    }
}