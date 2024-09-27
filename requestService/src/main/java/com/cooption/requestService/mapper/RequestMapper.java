package com.cooption.requestService.mapper;


import com.cooption.requestService.vo.RequestVO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface RequestMapper {

    int insertRequest(RequestVO requestVO);
}
