package com.Icici_Bank.persistent;

import java.util.Date;

public class account101 {
	
	private Long ac_no;
	private Long balance;
	private userDB101 uid_fk;
	private String isActive;
	private Long createBy;
	private Date createDate;
	private Long modifyBy;
	private Date modifyDate;
	public Long getAc_no() {
		return ac_no;
	}
	public void setAc_no(Long ac_no) {
		this.ac_no = ac_no;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	public userDB101 getUid_fk() {
		return uid_fk;
	}
	public void setUid_fk(userDB101 uid_fk) {
		this.uid_fk = uid_fk;
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
		return "account101 [ac_no=" + ac_no + ", balance=" + balance
				+ ", uid_fk=" + uid_fk + ", isActive=" + isActive
				+ ", createBy=" + createBy + ", createDate=" + createDate
				+ ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate + "]";
	}
	
	
}
