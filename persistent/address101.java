package com.Icici_Bank.persistent;

import java.util.Date;

public class address101 {
	
	private Long addid;
	private userDB101 uid_fk;
	private String address;
	private state101 sid_fk;
	private city101 cid_fk;
	private String isActive;
	private Long createBy;
	private Date createDate;
	private Long modifyBy;
	private Date modifyDate;
	public Long getAddid() {
		return addid;
	}
	public void setAddid(Long addid) {
		this.addid = addid;
	}
	public userDB101 getUid_fk() {
		return uid_fk;
	}
	public void setUid_fk(userDB101 uid_fk) {
		this.uid_fk = uid_fk;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public state101 getSid_fk() {
		return sid_fk;
	}
	public void setSid_fk(state101 sid_fk) {
		this.sid_fk = sid_fk;
	}
	public city101 getCid_fk() {
		return cid_fk;
	}
	public void setCid_fk(city101 cid_fk) {
		this.cid_fk = cid_fk;
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
		return "address101 [addid=" + addid + ", uid_fk=" + uid_fk
				+ ", address=" + address + ", sid_fk=" + sid_fk + ", cid_fk="
				+ cid_fk + ", isActive=" + isActive + ", createBy=" + createBy
				+ ", createDate=" + createDate + ", modifyBy=" + modifyBy
				+ ", modifyDate=" + modifyDate + "]";
	}

}
