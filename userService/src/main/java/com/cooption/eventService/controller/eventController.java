package com.cooption.eventService.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooption.eventService.service.EventService;
import com.cooption.eventService.vo.EventVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/coOption")
public class eventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/createEvent")
    public void createEvent(@RequestBody String eventInfoJson) throws GeneralSecurityException, IOException {

    	ObjectMapper mapper = new ObjectMapper();

    	EventVO eventVO = new EventVO();
    	
    	try {
            eventVO = mapper.readValue(eventInfoJson, EventVO.class);
            
            // 일정 생성
	    	eventService.createEvent(eventVO);
	
	    	// 일정 DB 등록
	    	eventService.insertEvent(eventVO);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    	System.out.println("eventVO : " + eventVO);
    	
    	
    	
    }

    @PostMapping("/addEventUserRel")
    public void addEventUserRel(@RequestBody EventVO eventVO) throws GeneralSecurityException, IOException{
    	eventService.addEventUserRel(eventVO);
    }
    
}