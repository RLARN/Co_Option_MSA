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
    public void modifyTask(@RequestBody String taskInfoJson) throws GeneralSecurityException, IOException {

        ObjectMapper mapper = new ObjectMapper();

        try {

            TaskVO taskVO = new TaskVO();
            taskVO = mapper.readValue(taskInfoJson, TaskVO.class);

            // task 수정
            taskService.modifyTask(taskVO);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/selectTaskList")
    @ResponseBody
    public List<TaskVO> selectTaskList(@RequestBody String taskInfoJson) throws GeneralSecurityException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        TaskVO taskVO = mapper.readValue(taskInfoJson, TaskVO.class);

        List<TaskVO> taskList = taskService.selectTaskList(taskVO);
        return taskList;
    }

    @PostMapping("/getTaskCompletionRate")
    @ResponseBody
    public TaskVO  getTaskCompletionRate (@RequestBody String taskInfoJson) throws GeneralSecurityException, IOException {
    //일정 완료율 계산 후 return
        ObjectMapper mapper = new ObjectMapper();
        TaskVO taskVO = mapper.readValue(taskInfoJson, TaskVO.class);

        return taskService.getTaskCompletionRate(taskVO);
    }
    
    @PostMapping("/completeYNChange")
    public void completeYNChange(@RequestBody String taskInfoJson) throws GeneralSecurityException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        TaskVO taskVO = mapper.readValue(taskInfoJson, TaskVO.class);

        taskService.completeYNChange(taskVO);
    }
}