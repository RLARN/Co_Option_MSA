package com.cooption.requestService.mapper;


import com.cooption.requestService.vo.RequestVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface RequestMapper {

    int insertRequest(RequestVO requestVO);

    void modifyRequest(RequestVO requestVO);

    int insertTaskRequestRel(RequestVO requestVO);

    void modifyTaskRequestRel(RequestVO requestVO);

    int insertUserRequestRel(RequestVO requestVO);

    void modifyUserRequestRel(RequestVO requestVO);
    
    // 일정 요청 프로세스
    int insertEventRequestRel(RequestVO requestVO);
    
    void requestEventApproval(RequestVO requestVO);
    
    void requestEventReject(RequestVO requestVO);

    List<RequestVO> selectRequestList(RequestVO requestVO);
}
