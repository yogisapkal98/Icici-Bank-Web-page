package com.Icici_Bank.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HibernateConnection {
	static SessionFactory sessionFactory;

	static 
	{
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
	}

	public static Session getSession() 
	{
		return sessionFactory.openSession();
	}
	
	public static void closeSession(Session session)
	{
		try{
			if(session!=null)
			{
				session.close();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String tojson(Object object)
	{
		if(object!=null)
		{
			Gson gson=new GsonBuilder().create();
			return gson.toJson(object);
			
		}
		else
		{
			return "0";
		}
	}

}
