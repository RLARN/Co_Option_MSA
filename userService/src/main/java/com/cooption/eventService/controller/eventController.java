package com.cooption.eventService.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooption.eventService.service.EventService;
import com.cooption.eventService.vo.EventVO;
import com.cooption.eventService.vo.UserVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.calendar.model.Event;

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
	    	Event event = eventService.createEvent(eventVO);	    	
	    	eventVO.setEid(event.getHtmlLink().split("=")[1]);
	    	
	    	// 일정 DB 등록
	    	eventService.insertEvent(eventVO);

        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    	System.out.println("eventVO : " + eventVO);
    }

    @PostMapping("/updateEvent")
    public void updateEvent(@RequestBody String eventInfoJson) throws GeneralSecurityException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        EventVO eventVO = new EventVO();

        try {
            eventVO = mapper.readValue(eventInfoJson, EventVO.class);
            // 일정 수정
            eventService.updateEvent(eventVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @PostMapping("/deleteEvent")
    public void deleteEvent(@RequestBody String eventInfoJson) throws GeneralSecurityException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        EventVO eventVO = new EventVO();

        try {
            eventVO = mapper.readValue(eventInfoJson, EventVO.class);
            // 일정 수정
            eventService.deleteEvent(eventVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/addEventUserRel")
    public void addEventUserRel(@RequestBody EventVO eventVO) throws GeneralSecurityException, IOException{
    	eventService.addEventUserRel(eventVO);
    }
    
    @PostMapping("/getEvent")
    public EventVO getEvent(@RequestBody String eventInfoJson) throws GeneralSecurityException, IOException{
    	ObjectMapper mapper = new ObjectMapper();
        EventVO eventVO = new EventVO();

        try {
            eventVO = eventService.getEvent(mapper.readValue(eventInfoJson, EventVO.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return eventVO;
    }
    
    @PostMapping("/getEventUser")
    public List<UserVO> getEventUser(@RequestBody String eventInfoJson) throws GeneralSecurityException, IOException{
    	ObjectMapper mapper = new ObjectMapper();
    	List<UserVO> userlist = new ArrayList<UserVO>();
    	EventVO eventVO = new EventVO();

        try {
        	eventVO = mapper.readValue(eventInfoJson, EventVO.class);
        	userlist = eventService.getEventUser(eventVO);
        	
        	for(UserVO user : userlist) {
        		System.out.println(user);
        	}
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return userlist;
    }
}