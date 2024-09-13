package com.cooption.eventService.vo;

import java.util.Date;

import lombok.Data;

@Data
public class EventVO {

	private int eventSeq;
	private String eventNm;
	private String eventDesc;
	private String eventStartDate;
	private String eventEndDate;
	private String completeYn;
	private String deleteYn;
	private Date regDt;
	private String regId;
	private Date updDt;
	private String updId;
	
	// UserVO userSeq
	private int userSeq;
	
	public int getEventSeq() {
		return eventSeq;
	}
	public void setEventSeq(int eventSeq) {
		this.eventSeq = eventSeq;
	}
	public String getEventNm() {
		return eventNm;
	}
	public void setEventNm(String eventNm) {
		this.eventNm = eventNm;
	}
	public String getEventDesc() {
		return eventDesc;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	public String getEventStartDate() {
		return eventStartDate;
	}
	public void setEventStartDate(String eventStartDate) {
		this.eventStartDate = eventStartDate;
	}
	public String getEventEndDate() {
		return eventEndDate;
	}
	public void setEventEndDate(String eventEndDate) {
		this.eventEndDate = eventEndDate;
	}
	public String getCompleteYn() {
		return completeYn;
	}
	public void setCompleteYn(String completeYn) {
		this.completeYn = completeYn;
	}
	public String getDeleteYn() {
		return deleteYn;
	}
	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
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
	public int getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}
	@Override
	public String toString() {
		return "EventVO [eventSeq=" + eventSeq + ", eventNm=" + eventNm + ", eventDesc=" + eventDesc
				+ ", eventStartDate=" + eventStartDate + ", eventEndDate=" + eventEndDate + ", completeYn=" + completeYn
				+ ", deleteYn=" + deleteYn + ", regDt=" + regDt + ", regId=" + regId + ", updDt=" + updDt + ", updId="
				+ updId + ", userSeq=" + userSeq + "]";
	}
}
