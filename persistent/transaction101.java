package com.Icici_Bank.persistent;

import java.util.Date;

public class transaction101 {
	
	private Long tid;
	private account101 user_ac_fk;
	private account101 payee_ac_fk;
	private Long trans_amt;
	private Date trans_date;
	private String isActive;
	private Long createBy;
	private Date createDate;
	private Long modifyBy;
	private Date modifyDate;
	
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	public account101 getUser_ac_fk() {
		return user_ac_fk;
	}
	public void setUser_ac_fk(account101 user_ac_fk) {
		this.user_ac_fk = user_ac_fk;
	}
	public account101 getPayee_ac_fk() {
		return payee_ac_fk;
	}
	public void setPayee_ac_fk(account101 payee_ac_fk) {
		this.payee_ac_fk = payee_ac_fk;
	}
	public Long getTrans_amt() {
		return trans_amt;
	}
	public void setTrans_amt(Long trans_amt) {
		this.trans_amt = trans_amt;
	}
	public Date getTrans_date() {
		return trans_date;
	}
	public void setTrans_date(Date trans_date) {
		this.trans_date = trans_date;
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
		return "transaction101 [tid=" + tid + ", user_ac_fk=" + user_ac_fk
				+ ", payee_ac_fk=" + payee_ac_fk + ", trans_amt=" + trans_amt
				+ ", trans_date=" + trans_date + ", isActive=" + isActive
				+ ", createBy=" + createBy + ", createDate=" + createDate
				+ ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate + "]";
	}
	
	

}
