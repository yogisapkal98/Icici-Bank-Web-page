package com.Icici_Bank.persistent;

import java.util.Date;

public class state101 {
	
	private Long sid;
	private String sname;
	private String isActive;
	private Long createBy;
	private Date createDate;
	private Long modifyBy;
	private Date modifyDate;
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public Long getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "state101 [sid=" + sid + ", sname=" + sname + ", isActive="
				+ isActive + ", createBy=" + createBy + ", createDate="
				+ createDate + ", modifyBy=" + modifyBy + ", modifyDate="
				+ modifyDate + "]";
	}
	
	

}
