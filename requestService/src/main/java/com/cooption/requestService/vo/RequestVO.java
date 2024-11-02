package com.cooption.requestService.vo;

import lombok.Data;

import java.util.Arrays;
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

	private String userId;//수신자.

	private String[] arrUserId;
	private String[] arrUserSeq;

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
	public int getEventSeq() {
		return eventSeq;
	}
	public void setEventSeq(int eventSeq) {
		this.eventSeq = eventSeq;
	}
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	public int getTaskSeq() {
		return taskSeq;
	}
	public void setTaskSeq(int taskSeq) {
		this.taskSeq = taskSeq;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String[] getArrUserId() {
		return arrUserId;
	}
	public void setArrUserId(String[] arrUserId) {
		this.arrUserId = arrUserId;
	}
	public String[] getArrUserSeq() {
		return arrUserSeq;
	}
	public void setArrUserSeq(String[] arrUserSeq) {
		this.arrUserSeq = arrUserSeq;
	}
	@Override
	public String toString() {
		return "RequestVO [requestSeq=" + requestSeq + ", requestNm=" + requestNm + ", requestDesc=" + requestDesc
				+ ", requestSenderId=" + requestSenderId + ", completeYn=" + completeYn + ", requestType=" + requestType
				+ ", deleteYn=" + deleteYn + ", eventSeq=" + eventSeq + ", userSeq=" + userSeq + ", taskSeq=" + taskSeq
				+ ", userAppYn=" + userAppYn + ", userId=" + userId + ", arrUserId=" + Arrays.toString(arrUserId)
				+ ", arrUserSeq=" + Arrays.toString(arrUserSeq) + ", regDt=" + regDt + ", regId=" + regId + ", updDt="
				+ updDt + ", updId=" + updId + "]";
	}

}
