package com.cooption.requestService.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.cooption.requestService.vo.RequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cooption.requestService.service.RequestService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/coOption")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @PostMapping("/addTaskRequest")
    //여기로 테스크 요청이 들어온다
    public void createEvent() throws GeneralSecurityException, IOException {

    	//ObjectMapper mapper = new ObjectMapper();

    	RequestVO requestVO = new RequestVO();

    	try {

            // task 등록
	    	requestService.insertTaskRequest(requestVO);


        } catch (Exception e) {
            e.printStackTrace();
        }

    	//System.out.println("eventVO : " + eventVO);
    	
    }

}