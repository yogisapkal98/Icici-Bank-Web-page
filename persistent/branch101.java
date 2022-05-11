package com.Icici_Bank.persistent;

import java.util.Date;

public class branch101 {
	
	private Long ifsc;
	private String bname;
	private String baddress;
	private state101 sid_fk;
	private city101 cid_fk;
	private String isActive;
	private Long createBy;
	private Date createDate;
	private Long modifyBy;
	private Date modifyDate;
	public Long getIfsc() {
		return ifsc;
	}
	public void setIfsc(Long ifsc) {
		this.ifsc = ifsc;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBaddress() {
		return baddress;
	}
	public void setBaddress(String baddress) {
		this.baddress = baddress;
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
		return "branch101 [ifsc=" + ifsc + ", bname=" + bname + ", baddress="
				+ baddress + ", sid_fk=" + sid_fk + ", cid_fk=" + cid_fk
				+ ", isActive=" + isActive + ", createBy=" + createBy
				+ ", createDate=" + createDate + ", modifyBy=" + modifyBy
				+ ", modifyDate=" + modifyDate + "]";
	}
	
	
	
}
