package com.cooption.requestService.vo;

import lombok.Data;

import java.util.Date;

@Data
public class RequestVO {

    private int requestSeq;
    private String requestNm;
    private String requestDesc;
    private String requestSenderId;
    private String completeYn;
    private String requestType;
    private String deleteYn;

    private int userSeq;
    private String userAppYn;

    private Date regDt;
    private String regId;
    private Date updDt;
    private String updId;


}
