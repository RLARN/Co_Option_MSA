package com.cooption.requestService.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.cooption.requestService.vo.RequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooption.requestService.service.RequestService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/api/users")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @PostMapping("/addTask")
    public void createEvent(@RequestBody String eventInfoJson) throws GeneralSecurityException, IOException {

    	ObjectMapper mapper = new ObjectMapper();

    	RequestVO requestVO = new RequestVO();

    	try {
            requestVO = mapper.readValue(eventInfoJson, RequestVO.class);

            // 일정 생성
	    	//taskService.createEvent(taskVO);

	    	// 일정 DB 등록
	    	requestService.insertRequest(requestVO);

        } catch (Exception e) {
            e.printStackTrace();
        }

    	//System.out.println("eventVO : " + eventVO);
    	
    }

}