package com.cooption.taskService.service;


import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Date;

import com.cooption.taskService.vo.TaskVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.cooption.taskService.common.taskCommon;
import com.cooption.taskService.mapper.TaskMapper;


@Service
public class TaskService {

    @Autowired
    private TaskMapper taskMapper;

    public void insertTask(TaskVO taskVO) {

    	// 1 == create success、0 == create fail
    	int check = 0;

    	// test obj
    	//EventVO eventVO2 = new EventVO();

    	// RegId, UpdId, UserSeq => session에서 가져와서 설정
/*		taskVO.setTaskNm(taskVO.getTaskNm());
		taskVO.setTaskDesc(taskVO.getTaskDesc());
        taskVO.setTaskDate(taskVO.getTaskDate());
        taskVO.setCompleteYn(taskVO.getCompleteYn());
        taskVO.setTaskType(taskVO.getTaskType());
        taskVO.setDeleteYn(taskVO.getDeleteYn());*/

		taskVO.setTaskNm("기술고문 고문");
		taskVO.setTaskDesc("kimcmiMaster");
		taskVO.setTaskDate(null);
		taskVO.setCompleteYn(taskCommon.TASK_COMM_CD_IS_COMPLETE_N);
		taskVO.setTaskType(taskCommon.TASK_COMM_CD_IS_COMPLETE_Y);
		taskVO.setDeleteYn(taskCommon.TASK_COMM_CD_IS_COMPLETE_Y);
        taskVO.setRegId("hammer");
		taskVO.setUpdId("hammer");

		check = taskMapper.insertTask(taskVO);
		System.out.println("check : " + check);

		if (check == 0) {
	        throw new RuntimeException("create user fail");
	    }

		int eventSeq = taskVO.getEventSeq();
	    System.out.println("Generated eventSeq: " + eventSeq);

	    //check = taskMapper.insertEventUserRel(taskVO);

		if (check == 0) {
            throw new RuntimeException("create user fail");
        }
    }
	public void modifyTask(TaskVO taskVO) {

	}
}