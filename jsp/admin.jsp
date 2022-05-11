<%@page import="com.Icici_Bank.persistent.userDB101"%>
<%@page import="java.util.List"%>
<%@page import="com.Icici_Bank.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String contextpath = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin page</title>
<link href="<%=contextpath%>/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=contextpath%>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=contextpath%>/js/script.js"></script>
</head>
<body>
	<div class="wrap">
		<%@include file="Header.jsp"%>
		<br>

		<%
			UserDao dao = new UserDao();
			List list = (List) dao.getuserApp();
		%>
		<input id="contextpath" type="hidden" name="contextpath"
			value="<%=contextpath%>">
		<div align="center">
			<table border='1' width='100%'>
				<thead>
					<tr>
						<td>First Name</td>
						<td>Last Name</td>
						<td>Pan Card</td>
						<td>Aadhar Number</td>
						<td>Email</td>
						<td>Activate</td>
					</tr>
				</thead>

				<%
					for (int i = 0; i < list.size(); i++) {
						userDB101 userp = (userDB101) list.get(i);

						out.print("<tbody>");
						out.print("<tr>");
						out.print("<td>" + userp.getFname() + "</td>");
						out.print("<td>" + userp.getLname() + "</td>");
						out.print("<td>" + userp.getPancard() + "</td>");
						out.print("<td>" + userp.getAadhar() + "</td>");
						out.print("<td>" + userp.getEmail() + "</td>");

						Long Uid = (userp.getUid());

						out.print("<td><button id='Uid' type='submit' name='Uid' value="
								+ Uid + " placeholder='Activate' onclick='datacall.createAc()'>Activate</button></td>");

						out.print("</tr>");
						out.print("</tbody>");
					}
				%>

			</table>
		</div>
		

		<%@include file="Footer.jsp"%>
	</div>
</body>
</html>