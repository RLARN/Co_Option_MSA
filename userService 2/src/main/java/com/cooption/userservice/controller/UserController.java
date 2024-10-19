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

@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/coOption")
public class UserController {

    @Autowired
    private UserService userService;
    
    
    // DB insert
    @PostMapping("/createUser")
    public void createUser(@RequestBody String eventInfoJson) throws GeneralSecurityException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        UserVO userVO = mapper.readValue(eventInfoJson, UserVO.class);
        userService.createUser(userVO);
    	
    }

    @GetMapping("/selectUserList")
    @ResponseBody
    public List<UserVO> selectUserList() throws GeneralSecurityException, IOException {

        //ObjectMapper mapper = new ObjectMapper();
        UserVO userVO = new UserVO();//mapper.readValue(userInfoJson, UserVO.class);

        List<UserVO> userList = userService.selectUserList(userVO);
        return userList;
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