package com.Icici_Bank.controller;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Icici_Bank.bean.RegistrationOutput;
import com.Icici_Bank.bean.userDB101bean;
import com.Icici_Bank.helper.UserHelper;
import com.Icici_Bank.impl.UserImpl;
import com.Icici_Bank.persistent.account101;
import com.Icici_Bank.persistent.userDB101;



/**
 * Servlet implementation class CoController
 */
public class CoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserHelper userhelper = new UserHelper();
		UserImpl userimpl = new UserImpl();
		String contextPath = request.getContextPath();
		
		String action = request.getParameter("action");
		
		if(action != null && !"".equals(action) && "registration".equals(action))
		{
			try
			{
				userDB101bean userbean= userhelper.userRegisterHelper(request);
				RegistrationOutput output = userimpl.registerUser(userbean);
				if(output.isStatus())
				{
					response.sendRedirect(contextPath+"/jsp/index.jsp?msg="+output.getMsg());
					
				}
				else
				{
					response.sendRedirect(contextPath+"/jsp/index.jsp?msg="+output.getMsg());
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				response.sendRedirect(contextPath+"/jsp/index.jsp?msg="+e.getMessage());
			}
		}
		
		if(action != null && !"".equals(action) && "login".equals(action))
		{
			try
			{
				userDB101 userp = userhelper.userLoginHelper(request);
				RegistrationOutput output = userimpl.loginUser(userp);
				//account101 accountp=new account101();
				
				HttpSession session=request.getSession();
				session.setAttribute("userp", userp);
				//session.setAttribute("accountp", accountp);

				if(output.isStatus() && output.getId()==3)
				{
					session.setAttribute("email", userp.getEmail());
					
					RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/admin.jsp");
					dispatcher.forward(request, response);
				}
				else if(output.isStatus() && output.getId()==2)
				{
					session.setAttribute("email", userp.getEmail());
					session.setAttribute("ac_no", output.getAc_no());
					
					RequestDispatcher dispatcher=request.getRequestDispatcher("jsp/service.jsp");
					dispatcher.forward(request, response);
					//response.sendRedirect(contextPath+"/jsp/admin.jsp?msg="+output.getMsg());
				}
				else
				{
					response.sendRedirect(contextPath+"/jsp/index.jsp?msg="+output.getMsg());
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				response.sendRedirect(contextPath+"index.jsp?msg="+e.getMessage());
			}
		}
		
	}

}
