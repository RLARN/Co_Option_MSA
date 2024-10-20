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
    public void createUser(@RequestBody String userInfoJson) throws GeneralSecurityException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        UserVO userVO = mapper.readValue(userInfoJson, UserVO.class);
    	userService.createUser(userVO);
    	
    }

    @PostMapping("/selectUserList")//전체 유저리스트 출력.
    @ResponseBody
    public List<UserVO> selectUserList(@RequestBody String userInfoJson) throws GeneralSecurityException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.readValue(userInfoJson, UserVO.class);
        UserVO userVO = new UserVO();

        List<UserVO> userList = userService.selectUserList(userVO);
        return userList;
    }
    @PostMapping("/selectUser")//userId 받아오면 user 전체 정보 출력
    @ResponseBody
    public UserVO selectUser(@RequestBody String userInfoJson) throws GeneralSecurityException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        UserVO userVO = new UserVO();
        userVO = mapper.readValue(userInfoJson, UserVO.class);
        userVO = userService.selectUser(userVO);

        return userVO;
    }

    @PostMapping("/selectEventUserList")//EventSeq 받아오면 해당 이벤트에 참가한 유저 리스트 출력
    @ResponseBody
    public List<UserVO> selectEventUserList(@RequestBody String eventSeq) throws GeneralSecurityException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        List<UserVO> userList = userService.selectEventUserList(eventSeq);

        return userList;
    }

    @PostMapping("/selectNonEventUserList")//EventSeq 받아오면 해당 이벤트에 참가 안한 유저 리스트 출력
    @ResponseBody
    public List<UserVO> selectNonEventUserList(@RequestBody String userInfoJson) throws GeneralSecurityException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        UserVO userVO = mapper.readValue(userInfoJson, UserVO.class);
        List<UserVO> userList = userService.selectNonEventUserList(userVO);

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