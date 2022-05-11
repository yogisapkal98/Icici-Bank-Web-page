package com.Icici_Bank.bean;

public class RegistrationOutput {
	
	private boolean status;
	private String msg;
	private Long id;
	private Long ac_no;
	
	public RegistrationOutput() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAc_no() {
		return ac_no;
	}

	public void setAc_no(Long ac_no) {
		this.ac_no = ac_no;
	}

	@Override
	public String toString() {
		return "RegistrationOutput [status=" + status + ", msg=" + msg
				+ ", id=" + id + ", ac_no=" + ac_no + "]";
	}
	
	
}
