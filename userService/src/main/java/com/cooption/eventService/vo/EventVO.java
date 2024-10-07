package com.cooption.eventService.vo;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EventVO {

	private int eventSeq;
	private String eventNm;
	private String eventDesc;
	private Date eventStartDate;
	private Date eventEndDate;
	private String completeYn;
	private String deleteYn;
	private Date regDt;
	private String regId;
	private Date updDt;
	private String updId;

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	private String eid;
	
	// test
	private String summary;
	private String description;
    private Date start;
    private Date end;
	
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
	public Date getEventStartDate() {
		return eventStartDate;
	}
	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}
	public Date getEventEndDate() {
		return eventEndDate;
	}
	public void setEventEndDate(Date eventEndDate) {
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "EventVO [eventSeq=" + eventSeq + ", eventNm=" + eventNm + ", eventDesc=" + eventDesc
				+ ", eventStartDate=" + eventStartDate + ", eventEndDate=" + eventEndDate + ", completeYn=" + completeYn
				+ ", deleteYn=" + deleteYn + ", regDt=" + regDt + ", regId=" + regId + ", updDt=" + updDt + ", updId="
				+ updId + ", summary=" + summary + ", description=" + description + ", start=" + start + ", end=" + end
				+ ", userSeq=" + userSeq + "]";
	}
	

}
