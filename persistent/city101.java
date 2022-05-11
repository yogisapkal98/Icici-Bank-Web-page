package com.Icici_Bank.persistent;

import java.util.Date;

public class city101 {
	
	private Long cid;
	private String cname;
	private state101 sid_fk;
	private String isActive;
	private Long createBy;
	private Date createDate;
	private Long modifyBy;
	private Date modifyDate;
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public state101 getSid_fk() {
		return sid_fk;
	}
	public void setSid_fk(state101 sid_fk) {
		this.sid_fk = sid_fk;
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
		return "city101 [cid=" + cid + ", cname=" + cname + ", sid_fk="
				+ sid_fk + ", isActive=" + isActive + ", createBy=" + createBy
				+ ", createDate=" + createDate + ", modifyBy=" + modifyBy
				+ ", modifyDate=" + modifyDate + "]";
	}
	
	
}
