package com.cooption.userservice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cooption.userservice.vo.UserVO;

@Mapper
public interface UserMapper {

	List<UserVO> selectUserList(UserVO userVO);
	int createUser(UserVO userVO);
	UserVO isValidUser(UserVO userVO);
}
