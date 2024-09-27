package com.cooption.requestService.service;


import com.cooption.requestService.vo.RequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooption.requestService.common.RequestCommon;
import com.cooption.requestService.mapper.RequestMapper;


@Service
public class RequestService {

    @Autowired
    private RequestMapper requestMapper;

    public void insertRequest(RequestVO requestVO) {

    	// 1 == create success、0 == create fail
    	int check = 0;

    	// test obj
    	//EventVO eventVO2 = new EventVO();

    	// RegId, UpdId, UserSeq => session에서 가져와서 설정
/*		requestVO.setrequestNm(requestVO.getrequestNm());
		requestVO.setrequestDesc(requestVO.getrequestDesc());
        requestVO.setrequestDate(requestVO.getrequestDate());
        requestVO.setCompleteYn(requestVO.getCompleteYn());
        requestVO.setrequestType(requestVO.getrequestType());
        requestVO.setDeleteYn(requestVO.getDeleteYn());*/

//		requestVO.setrequestNm("기술고문 고문");
//		requestVO.setrequestDesc("kimcmiMaster");
//		requestVO.setRequestDate(null);
//		RequestVO.setCompleteYn(RequestCommon.Request_COMM_CD_IS_COMPLETE_N);
//		RequestVO.setRequestType(RequestCommon.Request_COMM_CD_IS_COMPLETE_Y);
//		RequestVO.setDeleteYn(RequestCommon.Request_COMM_CD_IS_COMPLETE_Y);
//        RequestVO.setRegId("hammer");
//		RequestVO.setUpdId("hammer");

		check = requestMapper.insertRequest(requestVO);
		System.out.println("check : " + check);

		if (check == 0) {
	        throw new RuntimeException("create user fail");
	    }

		//int eventSeq = requestVO.getEventSeq();
	    //System.out.println("Generated eventSeq: " + eventSeq);

	    //check = requestMapper.insertEventUserRel(requestVO);

		if (check == 0) {
            throw new RuntimeException("create user fail");
        }
    }
}