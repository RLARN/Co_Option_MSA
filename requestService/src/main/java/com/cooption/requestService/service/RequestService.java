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

		TaskVO taskVO = new TaskVO();
		taskVO.setApprovedYn(RequestCommon.REQUEST_COMM_CD_IS_COMPLETE_N);//요청 미승인 상태

		//TASK 등록
		int taskSeq = taskServiceClient.createTask(taskVO);

		System.out.println("#@##@@@@@@@"+taskSeq);
		requestVO.setRequestNm("kimchiRequest");//가데이터
		requestVO.setTaskSeq(taskSeq);//태스크 등록하고 받아온 값.

		int requestSeq = requestMapper.insertRequest(requestVO);//request MST 등록
		requestVO.setRequestSeq(requestSeq);

		insertTaskRequestRel(requestVO);//task - request 관계 테이블 등록

		requestVO.setUserSeq(3);//임의값.
		requestVO.setUserAppYn("");//임의값

		int check = requestMapper.insertUserRequestRel(requestVO);//user - request 유저 관계 테이블 등록


    }

	public void requestTaskApproval(RequestVO requestVO){

		//TASK 승인 프로세스
		TaskVO taskVO = new TaskVO();
		taskVO.setTaskSeq(1);//받아와야됨
		taskVO.setApprovedYn(RequestCommon.REQUEST_COMM_CD_IS_COMPLETE_Y);
		taskServiceClient.modifyTask(taskVO);//task수정

		requestVO.setUserSeq(3);//받아와야됨
		requestVO.setRequestSeq(1);//받아와야됨
		requestVO.setUserAppYn(RequestCommon.REQUEST_COMM_CD_IS_COMPLETE_Y);
		requestMapper.modifyUserRequestRel(requestVO);
	}

	public void requestTaskReject(RequestVO requestVO){

		//TASK 거절프로세스
		//TaskVO taskVO = new TaskVO();
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 일정 요청 프로세스
	
	public void insertEventRequest(RequestVO requestVO, EventVO eventVO) {

		requestVO.setEventSeq(eventVO.getEventSeq());
		requestVO.setRequestNm("123");//가데이터
		requestVO.setUserSeq(10);
		
		requestMapper.insertRequest(requestVO);//request MST 등록
		
		int requestSeq = requestVO.getRequestSeq();
		requestVO.setRequestSeq(requestSeq);
		
		requestMapper.insertEventRequestRel(requestVO);//event - request 관계 테이블 등록
		
		// userseq리스트로 받아서 등록
		requestMapper.insertUserRequestRel(requestVO);//user - request 유저 관계 테이블 등록

    }
	
	
	/*
	 * 일정 승인 프로세스 (REQUEST_USER_REL 승인으로 수정, EVENT_USER_REL 해당 유저 등록)
	 */
	public void requestEventApproval(RequestVO requestVO){
		
		EventVO eventVO = new EventVO();
		eventVO.setEventSeq(1);
		eventVO.setUserSeq(10);

		requestVO.setUserSeq(10);
		requestVO.setRequestSeq(10);
		
		System.out.println("requestVOrequestVOrequestVO : " + requestVO.getEventSeq() + " : " + requestVO.getRequestSeq());
		
		requestMapper.requestEventApproval(requestVO);
		eventServiceClient.addEventUserRel(eventVO);
	}
	
	
	public void requestEventReject(RequestVO requestVO){
		requestVO.setUserSeq(10);
		requestVO.setRequestSeq(10);
		requestMapper.requestEventReject(requestVO);
		
	}


    public List<RequestVO> selectRequestList(RequestVO requestVO) {
		List<RequestVO> requestVOList = new ArrayList<RequestVO>();
		requestVOList = requestMapper.selectRequestList(requestVO);

		return requestVOList;
    }
}