package com.cooption.taskService.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.cooption.taskService.vo.TaskVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooption.taskService.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/api/users")
public class taskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/addTask")
    public void createTask() throws GeneralSecurityException, IOException {

    	ObjectMapper mapper = new ObjectMapper();

    	TaskVO taskVO = new TaskVO();

    	try {
            //taskVO = mapper.readValue(taskInfoJson, TaskVO.class);

            // 일정 생성
	    	//taskService.createEvent(taskVO);

	    	// 일정 DB 등록
	    	taskService.insertTask(taskVO);

        } catch (Exception e) {
            e.printStackTrace();
        }

    	//System.out.println("eventVO : " + eventVO);
    	
    }

}