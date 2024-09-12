package com.example.userservice.service;


import com.example.userservice.model.userVO;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Service
public class userRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createEvent() throws IOException, GeneralSecurityException {
        InputStream oriJson = new ClassPathResource("googleSA.json").getInputStream();
        //InputStream keyFile = ResourceUtils.getURL("classpath:" + oriJson).openStream();
        GoogleCredential credential = GoogleCredential.fromStream(oriJson).createScoped(Arrays.asList(CalendarScopes.CALENDAR)).createDelegated("cooptiongooglesa@test2-385601.iam.gserviceaccount.com");
        NetHttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
        Calendar service = new Calendar.Builder(transport, JacksonFactory.getDefaultInstance(), credential).setApplicationName("app 이름").build();

        String calendarId = "2b785f150767e0395fddf90330cbda151ae7e2bd4d9368866d453bf5f3c16761@group.calendar.google.com";

        Event event = new Event()
                .setSummary("test") // 일정 이름
                .setDescription("teststst"); // 일정 설명

        DateTime startDateTime = new DateTime("2022-05-18T09:00:00-07:00");
        EventDateTime start = new EventDateTime()
                .setDateTime(startDateTime)
                .setTimeZone("Asia/Seoul");
        event.setStart(start);
        DateTime endDateTime = new DateTime("2022-05-19T09:00:00-07:00");
        EventDateTime end = new EventDateTime()
                .setDateTime(endDateTime)
                .setTimeZone("Asia/Seoul");
        event.setEnd(end);

        event = service.events().insert(calendarId, event).execute();
        System.out.printf("Event created: %s\n", event.getHtmlLink());

        System.out.println("");
    }

    public userVO getUserById(String id) {
        String sql = "SELECT * FROM user WHERE login_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());
    }

    public List<userVO> getAllUsers() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    private static class UserRowMapper implements RowMapper<userVO> {
        @Override
        public userVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            userVO userVO = new userVO();
            userVO.setLogin_id(rs.getString("login_id"));
            //user.setName(rs.getString("name"));
            //user.setEmail(rs.getString("email"));
            return userVO;
        }
    }
}