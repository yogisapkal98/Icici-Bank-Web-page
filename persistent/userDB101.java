package com.Icici_Bank.persistent;

import java.util.Date;

public class userDB101 {
	
	private Long uid;
	private String fname;
	private String lname;
	private String pancard;
	private String aadhar;
	private Long number;
	private String email;
	private String password;
	private branch101 branch_fk;
	private role101 rid_fk;
	private String isActive;
	private Long createBy;
	private Date createDate;
	private Long modifyBy;
	private Date modifyDate;
	private state101 sid_fk;
	private city101 cid_fk;
	
	
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public branch101 getBranch_fk() {
		return branch_fk;
	}
	public void setBranch_fk(branch101 branch_fk) {
		this.branch_fk = branch_fk;
	}
	public role101 getRid_fk() {
		return rid_fk;
	}
	public void setRid_fk(role101 rid_fk) {
		this.rid_fk = rid_fk;
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
	@Override
	public String toString() {
		return "userDB101 [uid=" + uid + ", fname=" + fname + ", lname="
				+ lname + ", pancard=" + pancard + ", aadhar=" + aadhar
				+ ", number=" + number + ", email=" + email + ", password="
				+ password + ", branch_fk=" + branch_fk + ", rid_fk=" + rid_fk
				+ ", isActive=" + isActive + ", createBy=" + createBy
				+ ", createDate=" + createDate + ", modifyBy=" + modifyBy
				+ ", modifyDate=" + modifyDate + ", sid_fk=" + sid_fk
				+ ", cid_fk=" + cid_fk + "]";
	}
	
}
