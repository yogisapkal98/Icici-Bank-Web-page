package com.Icici_Bank.helper;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.Icici_Bank.bean.Account101Bean;
import com.Icici_Bank.bean.Transaction101Bean;
import com.Icici_Bank.dao.UserDao;

public class AccountHelper {

	public Account101Bean createAc(HttpServletRequest request) throws Exception
	{	
		//String data=null;
		//Long sid_fk=Long.parseLong(request.getParameter("sid_fk"));

		Account101Bean acountbean= new Account101Bean();

		acountbean.setUid_fk(Long.parseLong(request.getParameter("Uid")));


		return acountbean;

	}

	public List getbalance(HttpServletRequest request)
	{
		//Long ac_no=Long.parseLong(request.getParameter("ac_no"));

		List Balance = null;

		try{
			Account101Bean acountbean= new Account101Bean();

			acountbean.setAc_no(Long.parseLong(request.getParameter("ac_no")));

			UserDao dao=new UserDao();
			Balance=dao.getbalance(acountbean);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Balance;

	}
	public void deposite(HttpServletRequest request)
	{
		try{
			Transaction101Bean transactionbean= new Transaction101Bean();
			transactionbean.setUser_ac_fk(Long.parseLong(request.getParameter("ac_no")));
			transactionbean.setTrans_amt(Long.parseLong(request.getParameter("amount")));
			
			UserDao dao=new UserDao();
			Integer Balance = dao.deposite(transactionbean);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void withdraw(HttpServletRequest request)
	{
		try{
			Transaction101Bean transactionbean= new Transaction101Bean();
			transactionbean.setUser_ac_fk(Long.parseLong(request.getParameter("ac_no")));
			transactionbean.setTrans_amt(Long.parseLong(request.getParameter("amount")));
			
			UserDao dao=new UserDao();
			Integer Balance = dao.withdraw(transactionbean);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}