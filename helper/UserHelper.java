package com.Icici_Bank.helper;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.Icici_Bank.persistent.userDB101;
import com.Icici_Bank.bean.userDB101bean;

import com.Icici_Bank.dao.UserDao;


public class UserHelper {

	public userDB101bean userRegisterHelper(HttpServletRequest request) throws Exception 
	{
		validateRegistration(request);

		/*String role=request.getParameter("role");*/
		userDB101bean userbean= new userDB101bean();


		userbean.setFname(request.getParameter("fname"));
		userbean.setLname(request.getParameter("lname"));
		userbean.setPancard(request.getParameter("pancard"));
		userbean.setAadhar(request.getParameter("aadhar"));
		userbean.setNumber(Long.parseLong(request.getParameter("number")));
		userbean.setEmail(request.getParameter("email"));
		userbean.setPassword(request.getParameter("password"));
		userbean.setRid_fk(Long.parseLong(request.getParameter("rid_fk")));
		userbean.setSid_fk(Long.parseLong(request.getParameter("sid_fk")));
		userbean.setCid_fk(Long.parseLong(request.getParameter("cid_fk")));


		return userbean;
	}

	void validateRegistration(HttpServletRequest request) throws Exception
	{
		/*String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String pancard = request.getParameter("pancard");
		String aadhar = request.getParameter("aadhar");
		String number = request.getParameter("number");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rid_fk = request.getParameter("rid_fk");
		String sid_fk = request.getParameter("sid_fk");
		String cid_fk = request.getParameter("cid_fk");*/

	}

	public userDB101 userLoginHelper(HttpServletRequest request) throws Exception
	{
		validateLogin(request);
		userDB101 user = new userDB101();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));

		return user;
	}
	void validateLogin(HttpServletRequest request) throws Exception
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if(email == null || "".equals(email) )
			throw new Exception("Name NOt found");

		if(password == null || "".equals(password))
			throw new Exception("Number NOt found");
	}

	public List getstate()
	{	
		String data=null;

		List state= new ArrayList();
		UserDao dao=new UserDao();
		state = dao.getstate();

		if(state!=null && state.size()>0)
		{
			return state;
		}

		return state;	
	}
	public List getcity(HttpServletRequest request)
	{	
		//String data=null;
		Long sid_fk=Long.parseLong(request.getParameter("sid_fk"));

		List city= new ArrayList();

		try{

			userDB101bean userbean= new userDB101bean();
			userbean.setSid_fk(Long.parseLong(request.getParameter("sid_fk")));

			UserDao dao=new UserDao();
			city = dao.getcity(userbean);

			if(city!=null && city.size()>0)
			{
				return city;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return city;

	}

}
