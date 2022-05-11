package com.Icici_Bank.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Icici_Bank.persistent.city101;
import com.Icici_Bank.persistent.role101;
import com.Icici_Bank.persistent.state101;
import com.Icici_Bank.persistent.userDB101;
import com.Icici_Bank.util.HibernateConnection;
import com.Icici_Bank.bean.RegistrationOutput;
import com.Icici_Bank.bean.userDB101bean;


public class UserImpl {
	
	Session session = HibernateConnection.getSession();
	
	Long rid=null;
	static Long acno;

	
	public RegistrationOutput registerUser(userDB101bean UserBean) 
	{
		Transaction transaction = session.beginTransaction();
		RegistrationOutput output = new RegistrationOutput();
		Long uid = null;

		try
		{
			userDB101 userP = new userDB101();
			
			userP.setFname(UserBean.getFname());
			userP.setLname(UserBean.getLname());
			userP.setPancard(UserBean.getPancard());
			userP.setAadhar(UserBean.getAadhar());
			userP.setNumber(UserBean.getNumber());
			userP.setEmail(UserBean.getEmail());
			userP.setPassword(UserBean.getPassword());
			
			/*branch101 branch=(branch101) session.get(branch101.class, UserBean.getBranch_fk());
			userP.setBranch_fk(branch);*/
			
			
			role101 role=(role101) session.get(role101.class, UserBean.getRid_fk());
			userP.setRid_fk(role);
			
			userP.setIsActive("N");
			
			state101 state=(state101) session.get(state101.class, UserBean.getSid_fk());
			userP.setSid_fk(state);
			
			city101 city=(city101) session.get(city101.class, UserBean.getCid_fk());
			userP.setCid_fk(city);
			
			userP.setCreateDate(new Date());
			
			//userP.setModifyDate(new Date());

			uid = (Long) session.save(userP);
			userP.setCreateBy(uid);
			//userP.setModifyBy(uid);
			
			session.saveOrUpdate(userP);
			transaction.commit();

			session.close();
			if(uid > 0)
			{
				output.setStatus(true);
				output.setMsg("Registration Successful with registration ID :  "+uid);
			}
			else
			{
				output.setStatus(false);
				output.setMsg("Registration failed");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			output.setStatus(false);
			output.setMsg(e.getMessage());
		}
		return output;
	}
	
	public RegistrationOutput loginUser(userDB101 userp)
	{
		//Transaction transaction = session.beginTransaction();
		RegistrationOutput output = new RegistrationOutput();
		


		try
		{
			Query query=session.createQuery(" select u.email, u.password, u.rid_fk, a.ac_no  from account101 a inner join a.uid_fk u where u.email=:email  and u.password=:password");

			query.setParameter("email", userp.getEmail());
			query.setParameter("password", userp.getPassword());
			
			//query.setParameter("rid_fk", userp.getRid_fk());

			List result=query.list();
			
			
			for(int i =0;i<result.size();i++)
			{
				Object [] obj = (Object[])result.get(i);
				for(int j=0;j<obj.length;j++)
				{
					System.out.println(obj[j]);
				}
				role101 r=(role101) obj[2];
				acno=(Long) obj[3];
				
				
				rid=r.getRid();
				
				System.out.println("");
			}
			

			//transaction.commit();
			session.close();
			
			if(result.size()>0)
			{
				output.setStatus(true);
				output.setMsg("Login Successfull...");
				output.setId(rid);
				output.setAc_no(acno);
			}
			else
			{
				output.setStatus(false);
				output.setMsg("Login failed");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			output.setStatus(false);
			output.setMsg(e.getMessage());
		}

		return output;
	}


}
