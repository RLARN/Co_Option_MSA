package com.cooption.taskService.service;


import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    public int insertTask(TaskVO taskVO) {

    	// 1 == create success、0 == create fail
    	int check = 0;

		check = taskMapper.insertTask(taskVO);
		System.out.println("check : " + check);

		if (check == 0) {
	        throw new RuntimeException("create user fail");
	    }

		int taskSeq = taskVO.getTaskSeq();
	    System.out.println("Generated taskSeq: " + taskSeq);
		return taskSeq;
	    //check = taskMapper.insertEventUserRel(taskVO);

    }
	public void modifyTask(TaskVO taskVO) {
		taskMapper.modifyTask(taskVO);
	}

	public List<TaskVO> selectTaskList(TaskVO taskVO) {
		
		//공유 task 인지 개인 task 인지 타입 받아야함.
		//공유 task 이면 eventSeq 만 조건에 넣고

		TaskVO taskSearchVO = new TaskVO();

		taskSearchVO.setEventSeq(taskVO.getEventSeq());
		taskSearchVO.setApprovedYn("Y");

		if (taskVO.getTaskType().equals("share")){//공유 task 가져오기
			taskSearchVO.setOwnerUserSeq(null);

		} else {
			taskSearchVO.setOwnerUserSeq(taskVO.getOwnerUserSeq());//개인 task 가져오기

		}

		List<TaskVO> taskList = taskMapper.selectTaskList(taskSearchVO);
		return taskList;
	}
	
	public void completeYNChange(TaskVO taskVO) {
		taskMapper.completeYNChange(taskVO);
	}
}