package com.cooption.requestService.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;

import com.cooption.requestService.vo.EventVO;
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
    public void createTask() throws GeneralSecurityException, IOException {

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
    
    @PostMapping("/addEventRequest")
    //일정참가 요청
    public void addEventRequest(@RequestBody String eventInfoJson) throws GeneralSecurityException, IOException {

    	ObjectMapper mapper = new ObjectMapper();
    	RequestVO requestVO = new RequestVO();
    	EventVO eventVO = new EventVO();
    	
    	try {

            //이벤트 아이디 보낼꺼고
            //유저 정보를 배열로 보낼꺼다.
            //요청 Desc 보낼꺼다.

    		// eventseq취득하기 위해 파싱
            //List<Map<String, String>> userVO();
            List<Map<String, String>> chuga;
    		//eventVO = mapper.readValue(eventInfoJson, EventVO.class);
            //chuga = mapper.readValue(eventInfoJson, EventVO.class);
    		//eventVO.setEventSeq(1);
	    	requestService.insertEventRequest(requestVO, eventVO);


        } catch (Exception e) {
            e.printStackTrace();
        }

    	//System.out.println("eventVO : " + eventVO);
    	
    }

    @PostMapping("/requestTaskApproval")
    //task 요청 승인
    public void requestTaskApproval() throws GeneralSecurityException, IOException {

        //ObjectMapper mapper = new ObjectMapper();

        RequestVO requestVO = new RequestVO();

        try {

            // task 등록
            //requestService.insertTaskRequest(requestVO);
            requestService.requestTaskApproval(requestVO);


        } catch (Exception e) {
            e.printStackTrace();
        }

        //System.out.println("eventVO : " + eventVO);

    }

    @PostMapping("/requestTaskReject")
    //task 요청 거절
    public void requestTaskReject() throws GeneralSecurityException, IOException {

        //ObjectMapper mapper = new ObjectMapper();

        RequestVO requestVO = new RequestVO();

        try {

            // task 등록
            //requestService.insertTaskRequest(requestVO);
            requestService.requestTaskReject(requestVO);


        } catch (Exception e) {
            e.printStackTrace();
        }

        //System.out.println("eventVO : " + eventVO);

    }

    @PostMapping("/requestEventApproval")
    //이벤트 요청 승인
    public void requestEventApproval(@RequestBody String eventInfoJson) throws GeneralSecurityException, IOException {
        RequestVO requestVO = new RequestVO();
        try {
            requestService.requestEventApproval(requestVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @PostMapping("/requestEventReject")
    //이벤트 요청 거절
    public void requestEventReject(@RequestBody String eventInfoJson) throws GeneralSecurityException, IOException {
        RequestVO requestVO = new RequestVO();
        try {
            requestService.requestEventReject(requestVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/selectRequestList")
    @ResponseBody
    //요청 리스트 출럭
    public List<RequestVO> selectUserList(@RequestBody String eventInfoJson) throws GeneralSecurityException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        RequestVO requestVO = mapper.readValue(eventInfoJson, RequestVO.class);
        List<RequestVO> requestVOListList = requestService.selectRequestList(requestVO);
        return requestVOListList;
    }
    
}