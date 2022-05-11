package com.Icici_Bank.impl;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Icici_Bank.bean.Account101Bean;
import com.Icici_Bank.persistent.account101;
import com.Icici_Bank.persistent.userDB101;
import com.Icici_Bank.util.HibernateConnection;

public class AccountImpl {

	Session session = HibernateConnection.getSession();

	public Boolean createAc(Account101Bean accountb)
	{
		Transaction transaction = session.beginTransaction();

		try{
			
			account101 accountp =new account101();
			
			accountp.setBalance(0L);
			accountp.setIsActive("Y");
			userDB101 user=(userDB101) session.get(userDB101.class, accountb.getUid_fk());
			accountp.setUid_fk(user);
			
			user.setIsActive("Y");
			
			user.setModifyBy(user.getUid());
			user.setModifyDate(new Date());
			Long ac_no=(Long) session.save(accountp);
			session.saveOrUpdate(accountp);
			session.saveOrUpdate(user);
			transaction.commit();

			session.close();


		}
		catch(Exception e)
		{
			HibernateConnection.closeSession(session);
			e.printStackTrace();
		}
		return true;
	}

}
