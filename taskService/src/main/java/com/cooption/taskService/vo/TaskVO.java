package com.cooption.taskService.vo;

import lombok.Data;

import java.util.Date;

@Data
public class TaskVO {

    private int taskSeq;
    private int eventSeq;
	private int requestSeq;
    private String taskNm;
    private String taskDesc;
    private Date taskDate;
    private String completeYn;
    private String taskType;
    private String approvedYn;
    private String deleteYn;
    private Date regDt;
    private String regId;
    private Date updDt;
    private String updId;
	private String ownerUserSeq;
	private double completionRate;

	public int getTaskSeq() {
		return taskSeq;
	}
	public void setTaskSeq(int taskSeq) {
		this.taskSeq = taskSeq;
	}
	public int getEventSeq() {
		return eventSeq;
	}
	public void setEventSeq(int eventSeq) {
		this.eventSeq = eventSeq;
	}
	public String getTaskNm() {
		return taskNm;
	}
	public void setTaskNm(String taskNm) {
		this.taskNm = taskNm;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public Date getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(Date taskDate) {
		this.taskDate = taskDate;
	}
	public String getCompleteYn() {
		return completeYn;
	}
	public void setCompleteYn(String completeYn) {
		this.completeYn = completeYn;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public String getApprovedYn() {
		return approvedYn;
	}
	public void setApprovedYn(String approvedYn) {
		this.approvedYn = approvedYn;
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
	@Override
	public String toString() {
		return "TaskVO [taskSeq=" + taskSeq + ", eventSeq=" + eventSeq + ", taskNm=" + taskNm + ", taskDesc=" + taskDesc
				+ ", taskDate=" + taskDate + ", completeYn=" + completeYn + ", taskType=" + taskType + ", approvedYn="
				+ approvedYn + ", deleteYn=" + deleteYn + ", regDt=" + regDt + ", regId=" + regId + ", updDt=" + updDt
				+ ", updId=" + updId + "]";
	}

}
