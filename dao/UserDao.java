package com.Icici_Bank.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Icici_Bank.bean.Account101Bean;
import com.Icici_Bank.bean.Transaction101Bean;
import com.Icici_Bank.bean.userDB101bean;
import com.Icici_Bank.persistent.account101;
import com.Icici_Bank.persistent.role101;
import com.Icici_Bank.persistent.transaction101;
import com.Icici_Bank.persistent.userDB101;
import com.Icici_Bank.util.HibernateConnection;

public class UserDao {


	public List getrole()
	{

		List<role101> list =new ArrayList();
		try{
			Session session = HibernateConnection.getSession();

			Transaction t = session.beginTransaction();

			Query query=session.createQuery("from role101");

			list = query.list();

			Iterator<role101> itr=list.iterator();    
			while(itr.hasNext())
			{    
				role101 n=itr.next();
				System.out.println(" DATA : "+n);
				//System.out.println("Pk_roleID: "+n.getPk_roleID()+"Role: "+n.getRole());
			}
			t.commit();
			session.close();
			System.out.println("success");    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}



	public List getstate() {

		Session session = HibernateConnection.getSession();
		List statelist=null;
		try{
			String queryString="select sid, sname from state101";

			Query query=session.createQuery(queryString);

			statelist = query.list();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		finally
		{
			HibernateConnection.closeSession(session);
		}
		return statelist;
	}

	public List getcity(userDB101bean userbean) {
		Session session = HibernateConnection.getSession();
		List citylist=null;

		try{
			String queryString="select c.cid, c.cname from city101 c where c.sid_fk=:sid_fk";

			Query query=session.createQuery(queryString);
			query.setLong("sid_fk",userbean.getSid_fk());

			citylist = query.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		finally
		{
			HibernateConnection.closeSession(session);
		}
		return citylist;
	}

	@SuppressWarnings("unchecked")
	public List getuserApp()
	{
		List<userDB101> list =new ArrayList();
		try{
			Session session = HibernateConnection.getSession();

			//Transaction t = session.beginTransaction();

			Query query=session.createQuery("from userDB101 where isActive='N' ");

			list = query.list();

			Iterator<userDB101> itr=list.iterator();    
			while(itr.hasNext())
			{    
				userDB101 n=itr.next();
				System.out.println(" DATA : "+n);
			}  
			session.close();    
			System.out.println("success");    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return list;
	}

	public List getbalance(Account101Bean acountbean) {

		Session session = HibernateConnection.getSession();
		List result=null;
		//Double balance=null;
		try{
			String queryString="select a.balance from account101 a where a.ac_no=:ac_no";
			Query query=session.createQuery(queryString);
			query.setParameter("ac_no",acountbean.getAc_no());

			result = query.list();
			/*for (int i = 0; i < result.size(); i++) {
				balance =  (Double) result.get(i);
			}*/

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		finally
		{
			HibernateConnection.closeSession(session);
		}

		return result;
	}



	public Integer deposite(Transaction101Bean transactionbean) {

		Session session = HibernateConnection.getSession();
		Transaction t = session.beginTransaction();
		Integer update3=null;
		try{

			String queryString="select a.balance from account101 a where a.ac_no=:user_ac_no";
			Query query=session.createQuery(queryString);
			query.setParameter("user_ac_no",transactionbean.getUser_ac_fk());

			Long amount=(Long)(transactionbean.getTrans_amt());
			List result = query.list();
			Long balance = null;

			for (int i = 0; i < result.size(); i++) {
				balance =  (Long) result.get(i);
			}
			balance = balance+amount;
			transactionbean.setTrans_amt(balance);

			account101 acc=(account101) session.get(account101.class, transactionbean.getUser_ac_fk());
			acc.setBalance(balance);

			session.persist(acc);


			transaction101 transactionp=new transaction101();
			account101 accountno = (account101) session.get(account101.class, transactionbean.getUser_ac_fk() );
			transactionp.setUser_ac_fk(accountno);
			transactionp.setTrans_amt(amount);
			transactionp.setTrans_date(new Date());
			transactionp.setIsActive("Y");
			transactionp.setCreateBy(transactionbean.getUser_ac_fk());
			transactionp.setCreateDate(new Date());

			session.persist(transactionp);

			t.commit();
			//session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		finally
		{
			HibernateConnection.closeSession(session);
		}
		return update3;
	}

	public Integer withdraw(Transaction101Bean transactionbean) {

		Session session = HibernateConnection.getSession();
		Transaction t = session.beginTransaction();
		Integer update3=null;
		try{

			String queryString="select a.balance from account101 a where a.ac_no=:user_ac_no";
			Query query=session.createQuery(queryString);
			query.setParameter("user_ac_no",transactionbean.getUser_ac_fk());

			Long amount=(Long)(transactionbean.getTrans_amt());
			List result = query.list();
			Long balance = null;

			for (int i = 0; i < result.size(); i++) {
				balance =  (Long) result.get(i);
			}
			if(amount>balance)
			{
				throw new Exception();
			}

			balance = balance-amount;
			transactionbean.setTrans_amt(balance);

			account101 acc=(account101) session.get(account101.class, transactionbean.getUser_ac_fk());
			acc.setBalance(balance);

			session.persist(acc);


			transaction101 transactionp=new transaction101();
			account101 accountno = (account101) session.get(account101.class, transactionbean.getUser_ac_fk() );
			transactionp.setUser_ac_fk(accountno);
			transactionp.setTrans_amt(amount);
			transactionp.setTrans_date(new Date());
			transactionp.setIsActive("Y");
			transactionp.setCreateBy(transactionbean.getUser_ac_fk());
			transactionp.setCreateDate(new Date());

			session.persist(transactionp);

			t.commit();
			//session.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		finally
		{
			HibernateConnection.closeSession(session);
		}
		return update3;
	}

}

