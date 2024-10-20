package com.cooption.eventService.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cooption.eventService.vo.EventVO;
import com.cooption.eventService.vo.UserVO;


@Mapper
public interface EventMapper {

	public int insertEvent(EventVO eventVO);
	public int insertEventUserRel(EventVO eventVO);
	public EventVO getEvent(EventVO eventVO);
	public List<UserVO> getEventUser(EventVO eventVO);
}
