package com.cooption.requestService.service;


import com.cooption.requestService.client.TaskServiceClient;
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
}