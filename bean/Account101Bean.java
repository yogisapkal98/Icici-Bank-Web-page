package com.Icici_Bank.bean;

public class Account101Bean {
	
	private Long ac_no;
	private Long balance;
	private Long uid_fk;
	
	public Account101Bean() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public Long getUid_fk() {
		return uid_fk;
	}

	public void setUid_fk(Long uid_fk) {
		this.uid_fk = uid_fk;
	}

	@Override
	public String toString() {
		return "Account101Bean [ac_no=" + ac_no + ", balance=" + balance
				+ ", uid_fk=" + uid_fk + "]";
	}

	
}
