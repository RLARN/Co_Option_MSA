package com.cooption.taskService.service;

import com.cooption.taskService.vo.TaskVO;
import org.springframework.beans.factory.annotation.Autowired;
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

    	TaskVO taskVO2 = new TaskVO();
    	// RegId, UpdId, UserSeq => session에서 가져와서 설정
/*		taskVO.setTaskNm(taskVO.getTaskNm());
		taskVO.setTaskDesc(taskVO.getTaskDesc());
        taskVO.setTaskDate(taskVO.getTaskDate());
        taskVO.setCompleteYn(taskVO.getCompleteYn());
        taskVO.setTaskType(taskVO.getTaskType());
        taskVO.setDeleteYn(taskVO.getDeleteYn());*/
    	taskVO2.setEventSeq(1);
		taskVO2.setTaskNm("teck");
		taskVO2.setTaskDesc("kimcmiMaster");
		//taskVO2.setTaskDate(null);
		taskVO2.setCompleteYn(taskCommon.TASK_COMM_CD_IS_COMPLETE_N);
		taskVO2.setTaskType(taskCommon.TASK_COMM_CD_IS_COMPLETE_N);
		taskVO2.setApprovedYn(taskCommon.TASK_COMM_CD_IS_COMPLETE_N);
		taskVO2.setDeleteYn(taskCommon.TASK_COMM_CD_IS_COMPLETE_N);
        taskVO2.setRegId("hammer");
		taskVO2.setUpdId("hammer");

		check = taskMapper.insertTask(taskVO2);
		System.out.println("check : " + check);

		if (check == 0) {
	        throw new RuntimeException("create user fail");
	    }

		int taskSeq = taskVO2.getTaskSeq();
	    System.out.println("Generated taskSeq: " + taskSeq);

	    //check = taskMapper.insertEventUserRel(taskVO);

		if (check == 0) {
            throw new RuntimeException("create user fail");
        }
    }
}