package com.cooption.requestService.service;


import com.cooption.requestService.client.EventServiceClient;
import com.cooption.requestService.client.TaskServiceClient;
import com.cooption.requestService.vo.EventVO;
import com.cooption.requestService.vo.RequestVO;
import com.cooption.requestService.vo.TaskVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooption.requestService.common.RequestCommon;
import com.cooption.requestService.mapper.RequestMapper;


@Service
public class RequestService {

    @Autowired
    private RequestMapper requestMapper;

	@Autowired
	private TaskServiceClient taskServiceClient;  // Feign Client 주입

	@Autowired
	private EventServiceClient eventServiceClient;
	
	public void insertTaskRequest(RequestVO requestVO) {

		TaskVO taskVO = new TaskVO();
		taskVO.setApprovedYn(RequestCommon.REQUEST_COMM_CD_IS_COMPLETE_N);//요청 미승인 상태

		//TASK 등록
		taskServiceClient.createTask(taskVO);

		insertRequest(requestVO);//request MST 등록
		insertTaskRequestRel(requestVO);//task - request 관계 테이블 등록
		insertUserRequestRel(requestVO);//user - request 유저 관계 테이블 등록

    }

	public void requestTaskApproval(RequestVO requestVO){

		//TASK 승인 프로세스
		TaskVO taskVO = new TaskVO();
		taskServiceClient.modifyTask(taskVO);//task에 추가
		
		modifyUserRequestRel(requestVO);
	}

	public void requestTaskReject(RequestVO requestVO){

		//TASK 거절프로세스
		TaskVO taskVO = new TaskVO();
		modifyUserRequestRel(requestVO);
		
	}

	public void insertRequest(RequestVO requestVO){
		int check = requestMapper.insertRequest(requestVO);
	}

	public void insertTaskRequestRel(RequestVO requestVO){
		int check = requestMapper.insertTaskRequestRel(requestVO);
	}

	public void modifyRequest(RequestVO requestVO){
		requestMapper.modifyRequest(requestVO);
	}

	public void modifyTaskRequestRel(RequestVO requestVO){
		requestMapper.modifyTaskRequestRel(requestVO);
	}

	public void insertUserRequestRel(RequestVO requestVO){
		int check = requestMapper.insertUserRequestRel(requestVO);
	}

	public void modifyUserRequestRel(RequestVO requestVO){

		
		requestMapper.modifyUserRequestRel(requestVO);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 일정 요청 프로세스
	
	public void insertEventRequest(RequestVO requestVO, EventVO eventVO) {

		requestVO.setEventSeq(eventVO.getEventSeq());
		
		requestMapper.insertRequest(requestVO);//request MST 등록
		requestMapper.insertEventRequestRel(requestVO);//event - request 관계 테이블 등록
		
		// userseq리스트로 받아서 등록
		requestMapper.insertUserRequestRel(requestVO);//user - request 유저 관계 테이블 등록

    }
	
	
	/*
	 * 일정 승인 프로세스 (REQUEST_USER_REL 승인으로 수정, EVENT_USER_REL 해당 유저 등록)
	 */
	public void requestEventApproval(RequestVO requestVO){
		
		EventVO eventVO = new EventVO();
		eventVO.setEventSeq(requestVO.getEventSeq());
		eventVO.setUserSeq(requestVO.getUserSeq());

		requestMapper.requestEventApproval(requestVO);
		eventServiceClient.addEventUserRel(eventVO);
	}
	
	
	public void requestEventReject(RequestVO requestVO){

		requestMapper.requestEventReject(requestVO);
		
	}
	
}