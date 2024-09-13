package com.cooption.eventService.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooption.eventService.service.EventService;
import com.cooption.eventService.vo.EventVO;

@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/api/users")
public class eventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/createEvent")
    public void createEvent() throws GeneralSecurityException, IOException {

    	EventVO eventVO = new EventVO();
    	// 일정 생성
    	eventService.createEvent(eventVO);

    	// 일정 DB 등록
    	eventService.insertEvent(null);
    }

}