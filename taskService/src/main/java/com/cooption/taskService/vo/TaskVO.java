package com.cooption.taskService.vo;

import lombok.Data;

import java.util.Date;

@Data
public class TaskVO {

    private int taskSeq;
    private int eventSeq;
    private String taskNm;
    private String taskDesc;
    private Date taskDate;
    private String completeYn;
    private String taskType;
    private String deleteYn;

    private Date regDt;
    private String regId;
    private Date updDt;
    private String updId;


}
