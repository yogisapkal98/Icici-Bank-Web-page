<%@page import="com.Icici_Bank.impl.AccountImpl"%>
<%@page import="com.Icici_Bank.bean.Account101Bean"%>
<%@page import="com.Icici_Bank.helper.AccountHelper"%>
<%@page import="com.Icici_Bank.util.HibernateConnection"%>
<%@page import="com.Icici_Bank.helper.UserHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%!public String ajaxCheck(HttpServletRequest request,HttpServletResponse response)
	{
		
		String data=null;
		String action=request.getParameter("action");
		if(action!=null && !"".equals(action))
		{
			if("getstate".equals(action))
			{
				 List state=null;
				 state=new UserHelper().getstate();
				 return HibernateConnection.tojson(state);
			}
			else if("getcity".equals(action))
			{
				List city=null;
				city=new UserHelper().getcity(request);
				return HibernateConnection.tojson(city);
			}
			else if("createAc".equals(action))
			{
				try{
				Account101Bean accountb=null;
				accountb=new AccountHelper().createAc(request);
				AccountImpl accountimpl= new AccountImpl();
				Boolean status=accountimpl.createAc(accountb);
				}
				catch (Exception e)
				{
					e.getMessage();
				}
				
			}
			else if("getbalance".equals(action))
			{
				//Double balance=0d;
				List balance=null;
				balance=new AccountHelper().getbalance(request);
				return HibernateConnection.tojson(balance); 
				
			}
			else if("deposite".equals(action))
			{
				AccountHelper acchelper=new AccountHelper();
				acchelper.deposite(request);
			}
			else if("withdraw".equals(action))
			{
				AccountHelper acchelper=new AccountHelper();
				acchelper.withdraw(request);
			}
		}
		return data;
	}%>
<%=ajaxCheck(request,response)%>