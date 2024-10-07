package com.cooption.eventService.service;


import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.cooption.eventService.common.eventCommon;
import com.cooption.eventService.mapper.EventMapper;
import com.cooption.eventService.vo.EventVO;
import com.cooption.eventService.vo.UserVO;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;

@Service
public class EventService {

	@Autowired
	private EventMapper eventMapper;
	
    public void createEvent(EventVO eventVO) throws IOException, GeneralSecurityException {

        // Google 계정 인증 정보를 읽어오기 위한 입력 스트림을 생성
        InputStream oriJson = new ClassPathResource(eventCommon.GOOGLE_COMM_CD_IS_SA).getInputStream();

        // 입력 스트림을 사용하여 GoogleCredential 객체를 생성하고,
        // Calendar API를 사용하기 위한 권한을 설정하고,
        // 특정 서비스 계정으로 위임 설정
        GoogleCredential credential = GoogleCredential.fromStream(oriJson)
                .createScoped(Arrays.asList(CalendarScopes.CALENDAR))  // Calendar API 권한 설정
                .createDelegated(eventCommon.GOOGLE_COMM_CD_IS_GOOGLE_ID);  // 위임할 서비스 계정 설정

        // 신뢰할 수 있는 HTTP 트랜스포트 객체를 생성
        NetHttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();

        // Calendar API 서비스를 설정하기 위한 Calendar 객체를 생성
        Calendar service = new Calendar.Builder(transport, JacksonFactory.getDefaultInstance(), credential)
                .setApplicationName("app 이름")  // 애플리케이션 이름 설정
                .build();

        // Google Calendar의 특정 캘린더 ID를 설정
        String calendarId = eventCommon.GOOGLE_COMM_CD_IS_CALENDAR_ID;

        // 새로운 이벤트 객체를 생성하고, 이벤트의 제목과 설명을 설정
        Event event = new Event()
                .setSummary("test")  // 이벤트 제목
                .setDescription("teststst");  // 이벤트 설명

        // 이벤트의 시작 날짜와 시간을 설정
        DateTime startDateTime = new DateTime("2022-05-18T09:00:00-07:00");
        EventDateTime start = new EventDateTime()
                .setDateTime(startDateTime)
                .setTimeZone("Asia/Seoul");  // 시간대를 'Asia/Seoul'로 설정
        event.setStart(start);

        // 이벤트의 종료 날짜와 시간을 설정
        DateTime endDateTime = new DateTime("2022-05-19T09:00:00-07:00");
        EventDateTime end = new EventDateTime()
                .setDateTime(endDateTime)
                .setTimeZone("Asia/Seoul");  // 시간대를 'Asia/Seoul'로 설정
        event.setEnd(end);

        // 설정한 캘린더 ID에 새로운 이벤트를 삽입
        event = service.events().insert(calendarId, event).execute();

        // 생성된 이벤트의 HTML 링크를 출력
        System.out.printf("Event created: %s\n", event.getHtmlLink());

        // 공백 줄을 출력 (디버깅 또는 보기 편하게)
        System.out.println("");
    }

    public void insertEvent(EventVO eventVO) {

    	// 1 == create success、0 == create fail
    	int check = 0;
    	
    	// test obj
    	//EventVO eventVO2 = new EventVO();

    	// RegId, UpdId, UserSeq => session에서 가져와서 설정
    	
    	

		eventVO.setEventNm(eventVO.getSummary());
		eventVO.setEventDesc(eventVO.getDescription());
		eventVO.setEventStartDate(eventVO.getStart());
		eventVO.setEventEndDate(eventVO.getEnd());
		//eventVO2.setCompleteYn("N");
		//eventVO2.setDeleteYn("N");
		//eventVO2.setRegDt(null); sql now
		eventVO.setRegId("hammer");
		//eventVO2.setUpdDt(null); sql now
		eventVO.setUpdId("hammer");
		eventVO.setUserSeq(10);
		
		
		
		check = eventMapper.insertEvent(eventVO);
		System.out.println("check : " + check);

		if (check == 0) {
	        throw new RuntimeException("create user fail");
	    }
		

		int eventSeq = eventVO.getEventSeq();
	    System.out.println("Generated eventSeq: " + eventSeq);

	    check = eventMapper.insertEventUserRel(eventVO);

		if (check == 0) {
            throw new RuntimeException("create user fail");
        }
    }
    public void updateEvent(EventVO eventVO) throws IOException, GeneralSecurityException {
        InputStream oriJson = new ClassPathResource(eventCommon.GOOGLE_COMM_CD_IS_SA).getInputStream();
        GoogleCredential credential = GoogleCredential.fromStream(oriJson)
                .createScoped(Arrays.asList(CalendarScopes.CALENDAR))
                .createDelegated(eventCommon.GOOGLE_COMM_CD_IS_GOOGLE_ID);

        NetHttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
        Calendar service = new Calendar.Builder(transport, JacksonFactory.getDefaultInstance(), credential)
                .setApplicationName("app 이름")
                .build();

        String calendarId = eventCommon.GOOGLE_COMM_CD_IS_CALENDAR_ID;
        Event event = service.events().get(calendarId, eventVO.getEid()).execute();

        event.setSummary(eventVO.getSummary())
                .setDescription(eventVO.getDescription())
                .setStart(new EventDateTime()
                        .setDateTime(new DateTime(eventVO.getEventStartDate()))
                        .setTimeZone("Asia/Seoul"))
                .setEnd(new EventDateTime()
                        .setDateTime(new DateTime(eventVO.getEventEndDate()))
                        .setTimeZone("Asia/Seoul"));

        service.events().update(calendarId, eventVO.getEid(), event).execute();
        System.out.printf("Event updated: %s\n", event.getHtmlLink());
    }
    // 일정 승인 프로세스
    public void addEventUserRel(EventVO eventVO) {
    	int check = eventMapper.insertEventUserRel(eventVO);
    	
    	if (check == 0) {
	        throw new RuntimeException("create event user rel fail");
	    }
    }
}