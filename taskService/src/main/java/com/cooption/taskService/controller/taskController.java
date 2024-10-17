package com.cooption.taskService.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.cooption.taskService.vo.TaskVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cooption.taskService.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/coOption")
public class taskController {

    @Autowired
    private TaskService taskService;


    @PostMapping("/addTask")
    public int createTask(@RequestBody String infoJson) throws GeneralSecurityException, IOException {

        ObjectMapper mapper = new ObjectMapper();

        TaskVO taskVO = new TaskVO();
        taskVO = mapper.readValue(infoJson, TaskVO.class);

        // 일정 DB 등록
        return taskService.insertTask(taskVO);

        //System.out.println("eventVO : " + eventVO);

    }

    @PostMapping("/modifyTask")
    public void modifyTask(@RequestBody TaskVO taskVO) throws GeneralSecurityException, IOException {

        ObjectMapper mapper = new ObjectMapper();

        //  TaskVO taskVO = new TaskVO();

        try {
            //taskVO = mapper.readValue(taskInfoJson, TaskVO.class);

            // 일정 생성
            //taskService.createEvent(taskVO);

            // 일정 DB 등록
            taskService.modifyTask(taskVO);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ApprovedYn : " + taskVO.getApprovedYn());
        //System.out.println("eventVO : " + eventVO);

    }

    @PostMapping("/selectTaskList")
    @ResponseBody
    public List<TaskVO> selectTaskList(@RequestBody String eventInfoJson) throws GeneralSecurityException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        TaskVO taskVO = mapper.readValue(eventInfoJson, TaskVO.class);

        List<TaskVO> taskList = taskService.selectTaskList(taskVO);
        return taskList;
    }
}