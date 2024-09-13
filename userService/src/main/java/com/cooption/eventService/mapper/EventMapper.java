package com.cooption.eventService.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.cooption.eventService.vo.EventVO;


@Mapper
public interface EventMapper {

	public int insertEvent(EventVO eventVO);
	public int insertEventUserRel(EventVO eventVO);
}
