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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coOption")
public class LoginController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String loginRequest, HttpServletRequest request) throws GeneralSecurityException, IOException{
        
    	ObjectMapper mapper = new ObjectMapper();
    	UserVO parsinguserVO = mapper.readValue(loginRequest, UserVO.class);
    	UserVO userVO = userService.isValidUser(parsinguserVO);
    	// 로그인 처리 로직
        if (userVO == null) {  // 유효한 사용자 확인
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("아이디 또는 비밀번호가 잘못되었습니다.");
        }else {
        	
        	// 로그인 성공 처리
	        HttpSession session = request.getSession();
	        session.setAttribute("userId", userVO.getUserId());
	        session.setAttribute("userName", userVO.getUserName());
	
	        return ResponseEntity.ok("로그인 성공");
        	
        }

        
    }
}