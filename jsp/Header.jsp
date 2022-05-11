<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<%=contextpath%>/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=contextpath%>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=contextpath%>/js/script.js"></script>
</head>
<body>
<!--    header    -->
		<header id="header" class="clearfix"> <a href=" " id="logo"><img
			src="<%=contextpath%>/images/logo.png" ></a>

		<div class="widget-container widget_search">

			<span class="call"><span>+1 234</span> 567-8901</span><br /> <span
				class="adds">HELP & CONTACT</span>

		</div>

		<!--   navigation     --> 
		<nav class="navigation">
		<ul>
			<li><a href=" ">Home</a></li>
			<li><a class="username"><% out.println(session.getAttribute("email")); %></a></li>
			<li><a href="<%=contextpath%>/LogoutController" class="logout">LOGOUT</a></li>
			<li><a href=" "></a>
		</ul>
		</nav>
	</header>
</body>
</html>