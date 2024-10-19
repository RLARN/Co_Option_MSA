package com.cooption.userservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooption.userservice.mapper.UserMapper;
import com.cooption.userservice.vo.UserVO;

import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	/* 参考用
	public List<UserVO> findAll() {
		List<UserVO> user = userMapper.findAll();
        if (user == null) {
            throw new RuntimeException("User not found with ID: ");
        }
        return user;
    }
	*/
	public void createUser(UserVO userVO) {
		
/*		// test obj
		UserVO userVO2 = new UserVO();
		
		userVO2.setUpdId("hammer");
		userVO2.setUserId("hammer");
		userVO2.setUserPwd("hammer");
		userVO2.setUserName("hammer");
		userVO2.setUserMail("hammer");
		//userVO2.setDeleteYn("N");		//sql default
		//userVO2.setRegDt(null);		//sql now
		userVO2.setRegId("hammer");
		//userVO2.setUpdDt(null);		//sql now
		userVO2.setUpdId("hammer");
		*/
		// 後にuserVO2 -> userVO修正必要
		int check = userMapper.createUser(userVO);
        
		// 1 == create success、0 == create fail
		System.out.println("check : " + check);
		
		if (check == 0) {
            throw new RuntimeException("create user fail");
        }
    }
	
	// 유저 선택
	public List<UserVO> selectUserList(UserVO userVO) {

		List<UserVO> userList = userMapper.selectUserList(userVO);
		return userList;

	}
	
	public UserVO isValidUser(UserVO userVO) {

		UserVO vo = userMapper.isValidUser(userVO);
		return vo;
	}

	public UserVO selectUser(UserVO userVO) {

		userVO = userMapper.selectUser(userVO);
		return userVO;
	}

	public List<UserVO> selectEventUserList(String eventSeq) {

		List<UserVO> userList = userMapper.selectEventUserList(eventSeq);
		return userList;
	}

	public List<UserVO> selectNonEventUserList(UserVO userVO) {

		List<UserVO> userList = userMapper.selectNonEventUserList(userVO);
		return userList;
	}
}