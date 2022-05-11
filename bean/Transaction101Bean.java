package com.Icici_Bank.bean;

public class Transaction101Bean {
	
	private Long user_ac_fk;
	private Long payee_ac_fk;
	private Long trans_amt;
	
	
	public Long getUser_ac_fk() {
		return user_ac_fk;
	}
	public void setUser_ac_fk(Long user_ac_fk) {
		this.user_ac_fk = user_ac_fk;
	}
	public Long getPayee_ac_fk() {
		return payee_ac_fk;
	}
	public void setPayee_ac_fk(Long payee_ac_fk) {
		this.payee_ac_fk = payee_ac_fk;
	}
	public Long getTrans_amt() {
		return trans_amt;
	}
	public void setTrans_amt(Long trans_amt) {
		this.trans_amt = trans_amt;
	}
	@Override
	public String toString() {
		return "Transaction101Bean [user_ac_fk=" + user_ac_fk
				+ ", payee_ac_fk=" + payee_ac_fk + ", trans_amt=" + trans_amt
				+ "]";
	}


}
