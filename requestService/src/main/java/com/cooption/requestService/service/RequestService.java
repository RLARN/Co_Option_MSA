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

import java.util.ArrayList;
import java.util.List;


@Service
public class RequestService {

    @Autowired
    private RequestMapper requestMapper;

	@Autowired
	private TaskServiceClient taskServiceClient;  // Feign Client 주입
	
	@Autowired
	private EventServiceClient eventServiceClient;  // Feign Client 주입

	public void insertTaskRequest(RequestVO requestVO) {

		//TASK 요청프로세스
		TaskVO taskVO = new TaskVO();
		taskVO.setApprovedYn(RequestCommon.REQUEST_COMM_CD_IS_COMPLETE_N);//요청 미승인 상태
		taskVO.setTaskNm(requestVO.getRequestNm());
		taskVO.setTaskDesc(requestVO.getRequestDesc());
		taskVO.setOwnerUserSeq(String.valueOf(requestVO.getUserSeq()));//요청 받는 사람
		taskVO.setEventSeq(requestVO.getEventSeq());

		//TASK 등록
		int taskSeq = taskServiceClient.createTask(taskVO);
		requestVO.setTaskSeq(taskSeq);//태스크 등록하고 받아온 값.

		int requestSeq = requestMapper.insertRequest(requestVO);//request MST 등록
		requestVO.setRequestSeq(requestSeq);

		insertTaskRequestRel(requestVO);//task - request 관계 테이블 등록
		requestVO.setUserAppYn("");//초기값.

		int check = requestMapper.insertUserRequestRel(requestVO);//user - request 유저 관계 테이블 등록

    }

	public void requestTaskApproval(RequestVO requestVO){

		//TASK 승인 프로세스
		TaskVO taskVO = new TaskVO();
		taskVO.setTaskSeq(requestVO.getTaskSeq());
		taskVO.setApprovedYn(RequestCommon.REQUEST_COMM_CD_IS_COMPLETE_Y);
		taskServiceClient.modifyTask(taskVO);//task수정

		requestVO.setUserAppYn(RequestCommon.REQUEST_COMM_CD_IS_COMPLETE_Y);
		requestMapper.modifyUserRequestRel(requestVO);
	}

	public void requestTaskReject(RequestVO requestVO){

		//TASK 거절프로세스
		requestVO.setUserAppYn(RequestCommon.REQUEST_COMM_CD_IS_COMPLETE_N);
		requestMapper.modifyUserRequestRel(requestVO);
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

	public void insertEventRequest(RequestVO requestVO) {

		//일정 등록 프로세스
		requestMapper.insertRequest(requestVO);//request MST 등록
		int requestSeq = requestVO.getRequestSeq();//DB에서 가져온 값.

		System.out.println("requestSeq : " + requestSeq);

		requestMapper.insertEventRequestRel(requestVO);//event - request 관계 테이블 등록
		requestMapper.insertUserRequestRel(requestVO);//user[] - request 유저 관계 테이블 등록

    }

	public void requestEventApproval(RequestVO requestVO){

		//일정 승인 프로세스 (REQUEST_USER_REL 승인으로 수정, EVENT_USER_REL 해당 유저 등록)
		EventVO eventVO = new EventVO();
		eventVO.setEventSeq(requestVO.getEventSeq());
		eventVO.setUserSeq(requestVO.getUserSeq());
		
		System.out.println("EventSeq : " + requestVO.getEventSeq() + " //  RequestSeq  : " + requestVO.getRequestSeq());
		
		requestMapper.requestEventApproval(requestVO);
		eventServiceClient.addEventUserRel(eventVO);
	}
	
	
	public void requestEventReject(RequestVO requestVO){
		requestMapper.requestEventReject(requestVO);
	}


    public List<RequestVO> selectRequestList(RequestVO requestVO) {

		List<RequestVO> requestVOList = new ArrayList<RequestVO>();
		requestVOList = requestMapper.selectRequestList(requestVO);

		return requestVOList;
    }
}