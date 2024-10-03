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
    private int eventSeq;
    private int userSeq;
    private int taskSeq;
    private String userAppYn;

    private Date regDt;
    private String regId;
    private Date updDt;
    private String updId;

	public int getRequestSeq() {
		return requestSeq;
	}

	public void setRequestSeq(int requestSeq) {
		this.requestSeq = requestSeq;
	}

	public String getRequestNm() {
		return requestNm;
	}

	public void setRequestNm(String requestNm) {
		this.requestNm = requestNm;
	}

	public String getRequestDesc() {
		return requestDesc;
	}

	public void setRequestDesc(String requestDesc) {
		this.requestDesc = requestDesc;
	}

	public String getRequestSenderId() {
		return requestSenderId;
	}

	public void setRequestSenderId(String requestSenderId) {
		this.requestSenderId = requestSenderId;
	}

	public String getCompleteYn() {
		return completeYn;
	}

	public void setCompleteYn(String completeYn) {
		this.completeYn = completeYn;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserAppYn() {
		return userAppYn;
	}

	public void setUserAppYn(String userAppYn) {
		this.userAppYn = userAppYn;
	}

	public Date getRegDt() {
		return regDt;
	}

	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public Date getUpdDt() {
		return updDt;
	}

	public void setUpdDt(Date updDt) {
		this.updDt = updDt;
	}

	public String getUpdId() {
		return updId;
	}

	public void setUpdId(String updId) {
		this.updId = updId;
	}

	public int getEventSeq() {
		return eventSeq;
	}

	public void setEventSeq(int eventSeq) {
		this.eventSeq = eventSeq;
	}
    
    
}
