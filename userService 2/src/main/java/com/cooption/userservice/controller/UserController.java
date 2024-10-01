package com.cooption.userservice.controller;

import com.cooption.userservice.service.UserService;
import com.cooption.userservice.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    
    // DB insert
    @GetMapping("/createUser")
    public void createUser() {
    	
    	
    	userService.createUser(null);
    	
    }

    // DB select
    @GetMapping("/selectUserList")
    public void selectUserList() {
    	
    	
    	userService.selectUserList(null);
    	
    }
    

    /*
    // DELETE 予定 참고용
    @GetMapping("/findAll/{id}")
    public ResponseEntity<List<UserVO>> getUser(@PathVariable Long id) {
    	List<UserVO> user = new ArrayList<UserVO>();
    	try {
        	user = userService.findAll();
        	System.out.println(user);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    */
}