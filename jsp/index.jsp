<%@page import="com.Icici_Bank.dao.UserDao"%>
<%@page import="com.Icici_Bank.persistent.role101"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="java.util.ArrayList"%>
	<%@page import="java.util.List"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String contextpath=request.getContextPath();%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<%=contextpath%>/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=contextpath%>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=contextpath%>/js/script.js"></script>
<title>Index Page</title>
</head>

<%
	String msg = request.getParameter("msg");
	
%>
<body>
<%
		if(msg != null && !"".equals(msg))
		{
			%>
			<p>Highlight: <%=msg %></p>
			<%
		}
	%>
	<!--   wrap     -->

	<div class="wrap">

		<!--    header    -->
		<header id="header" class="clearfix"> <a href=" " id="logo"><img
			src="<%=contextpath%>/images/logo.png" ></a>

		<div class="widget-container widget_search">

			<span class="call"><span>+1 234</span> 567-8901</span><br /> <span
				class="adds">HELP & CONTACT</span>

		</div>

		<!--   navigation     --> 
		<nav class="navigation">
		<input id="contextpath" type="hidden" name="contextpath" value="<%=contextpath%>">
		<ul>
			<li><a href=" ">Home</a></li>
			<li><a href="#" onclick="popup.regshow();">Registration</a></li>
			<li><a href="#" onclick="popup.loginshow();">Log-in</a></li>
			<li><a href=" ">News</a></li>
			<li><a href=" "></a></li>
			<li><a href=" "></a>
			<li><a href=" ">Contacts</a></li>
		</ul>
		</nav>
	</header>
	
	<div class="main_wrapper">
		<div class="main_container" id="indexmain">
			<div class="slider">
				<div class="slide-img">
					<div class="slide">
						<!–– first slide ––>
						<img class="animation-img"
							src="<%=contextpath%>/images/slide3.jpg" alt="offer">
					</div>
					<div class="slide">
						<!–– second slide ––>
						<img class="animation-img"
							src="<%=contextpath%>/images/slide4.jpg" alt="offer">
					</div>
					<div class="slide">
						<!–– third slide ––>
						<img class="animation-img"
							src="<%=contextpath%>/images/slide5.jpg" alt="offer">
					</div>
					<div class="slide">
						<!–– fourth slide ––>
						<img class="animation-img"
							src="<%=contextpath%>/images/slide6.jpg" alt="offer">
					</div>
					<div class="slide">
						<!–– fifth slide ––>
						<img class="animation-img"
							src="<%=contextpath%>/images/slide3.jpg" alt="offer">
					</div>
					<div class="slide">
						<!–– sixth slide ––>
						<img class="animation-img"
							src="<%=contextpath%>/images/slide4.jpg"
							alt="offer">
					</div>
					<a class="prev" onclick="plusSlides(-1);">((</a> <a class="next"
						onclick="plusSlides(1);">))</a>
				</div>
				<br>
				<div style="text-align: center">
					<span class="dot" onclick="currentSlide(1)"></span> <span
						class="dot" onclick="currentSlide(2)"></span> <span class="dot"
						onclick="currentSlide(3)"></span> <span class="dot"
						onclick="currentSlide(4)"></span> <span class="dot"
						onclick="currentSlide(5)"></span>
				</div>
				<script>
				let slideIndex = 1;
				var timer = setInterval(plusSlides(1), 2500);
				showSlides(slideIndex);
				function plusSlides(n) {
				  showSlides(slideIndex += n);
				}

				function currentSlide(n) {
				  showSlides(slideIndex = n);
				}

				function showSlides(n) {
				  let i;
				  let slides = document.getElementsByClassName("slide");
				  let dots = document.getElementsByClassName("dot");
				  if (n > slides.length) {slideIndex = 1}    
				  if (n < 1) {slideIndex = slides.length}
				  for (i = 0; i < slides.length; i++) {
					slides[i].style.display = "none";  
				  }
				  for (i = 0; i < dots.length; i++) {
					dots[i].className = dots[i].className.replace(" active", "");
				  }
				  slides[slideIndex-1].style.display = "block";  
				  dots[slideIndex-1].className += " active";
				}
				</script>
			</div>
		</div>
	
	<div class="poster">
      <img src="<%=contextpath%>/images/poster1.jpg" alt="" class="posterimg" />
    </div>
    
    
	
	<footer> 
		<img src="<%=contextpath%>/images/logo.png" width="200px" height="60px" />
		<div style="width: 200px; display: flex; justify-content: space-between; align-items: center;">
		<img src="<%=contextpath%>/images/fb.png" width="24" height="24" /> 
		<img src="<%=contextpath%>/images/insta.png" width="24" height="24" /> 
		<img src="<%=contextpath%>/images/twitter.png" width="24" height="24" />
	</div>
	</footer>
	
	
	</div>
	
<!-- Login Pop up  -->

	<div class="popup" id="popup" onclick="popup.hidePopup();"></div>

	<div id="login" class="login-screen">
		<form id="loginform" action="<%=contextpath%>/CoController" method="post" name="loginform"
			 onsubmit="return loginvalidation.Loginformvalid();">
			<div class="title">
				<h1>
					<span>Log</span>in
				</h1>
			</div>

			<button id="close" class="loginbutton" type="reset"
				onclick="popup.loginoff();">&times;</button>

			<div class="">
				<div class="input-box">
					<p>What is your Email?</p>
					<input type="text" class="login-field" value=""
						placeholder="Email" id="loginname" name="email"
						autocomplete="off" oninput="loginvalidation.unamevalid()"
						onkeyup="loginvalidation.unamevalid()"
						onblur="loginvalidation.unamevalid()" ><br> <span
						class="error" style.color="#ff0000" id="unameerror"></span>
				</div>

				<div class="input-box">
					<p>What is your Password?</p>
					<input type="password" class="login-field" value=""
						placeholder="password" id="loginpass" name="password"
						onkeyup="loginvalidation.passvalid()" oninput="loginvalidation.passvalid()"
						onblur="loginvalidation.passvalid()"><br> <span
						class="error" style.color="#ff0000" id="passerror"></span>
				</div>
				<input type="hidden" name="action" value="login">
				<button type="submit" class="loginbutton">Login</button>
				<a class="login-link" href="#" onclick="popup.regshow();"> <span>New User</span> Register here..!</a>
		</form>
	</div>
	</div>

<!-- Register Popup -->

	<div id="reg" class="reg-screen">
		<form id="regform" action="<%=contextpath%>/CoController" method="post" name="regform"
			onsubmit="return validation.eachtrue()" >
			<h1><span>Sign</span>Up</h1>
			 
			<button id="close" type="reset" onclick="popup.hidePopup();">&times;</button>
			<p>Please fill in this form to create an account.</p>
			 
			<!--<span class="" style.color="#ff0000" id="" onchange="uname-error.setStyle('display','none');"></span>-->
			<hr>

			<div class="input-box">
				<p>What is your first name?</p>
				<input id="fname" type="text" placeholder="Enter Your First Name"
					name="fname" autocomplete="off" maxlength="10"
					onkeypress="return validation.restrict_number(event)"
					oninput="validation.fnamevalid();"
					ondrop="return false;" onpaste="return false;"
					onkeyup="validation.fnamevalid();" onblur="validation.fnamevalid();"><br>
				<span class="error" style.color="#ff0000" id="fname-error"
					onchange="fname-error.setStyle('display','none');"></span>
			</div>
			
			<div class="input-box">
				<p>What is your last name?</p>
				<input id="lname" type="text" placeholder="Enter Your Last Name"
					name="lname" autocomplete="off" maxlength="20"
					onkeypress="return validation.restrict_number(event)"
					oninput="validation.lnamevalid();"
					ondrop="return false;" onpaste="return false;"
					onkeyup="validation.lnamevalid();" onblur="validation.lnamevalid();"><br>
				<span class="error" style.color="#ff0000" id="uname-error"
					onchange="uname-error.setStyle('display','none');"></span>
			</div>
			
			<div class="input-box">
				<p>What is your Pancard number?</p>
				<input id="pancard" type="text" placeholder="Enter Your Pancard number"
					name="pancard" autocomplete="off" maxlength="10"
					onkeypress=" "
					oninput="validation.pancardvalid(); validation.avoidSpace(event);"
					ondrop="return false;" onpaste="return false;"
					onkeyup="validation.pancardvalid();" onblur="validation.pancardvalid();"><br>
				<span class="error" style.color="#ff0000" id="pancard-error"
					onchange="pancard-error.setStyle('display','none');"></span>
			</div>
			
			<div class="input-box">
				<p>What is your Aadhar number?</p>
				<input id="aadhar" type="text" placeholder="Enter Your Aadhar number"
					name="aadhar" autocomplete="off" maxlength="12"
					onkeypress="return validation.restrictalphabets(event)"
					oninput="validation.avoidSpace(event);"
					ondrop="return false;" onpaste="return false;"
					onkeyup="validation.aadharvalid();" onblur="validation.aadharvalid();"><br>
				<span class="error" style.color="#ff0000" id="aadhar-error"
					onchange="aadhar-error.setStyle('display','none');"></span>
			</div>
			

			<div class="input-box">
				<p>What is your Contact Number?</p>
				<input id="number" type="text" placeholder="Enter Your Contact No."
					name="number" autocomplete="off" maxlength="10" ondrop="return false;" onpaste="return false;"
					onkeypress="return validation.restrictalphabets(event)"
					onkeyup="validation.numbervalid()" oninput="validation.numbervalid()"
					onblur="validation.numbervalid()"><br> <span
					class="error" style.color="#ff0000" id="number-error"
					onchange="number-error.setStyle('display','none');"></span>
			</div>

			<div class="input-box">
				<p>What is your E-mail?</p>
				<input id="email" type="text" placeholder="Enter Your E-mail" ondrop="return false;" onpaste="return false;"
					name="email" autocomplete="off" onkeyup="validation.emailvalid()"
					onblur="validation.emailvalid()" oninput= "validate.setInfo();"><br> 
					<span class="error" style.color="#ff0000" id="email-error" onchange="email-error.setStyle('display','none');"></span>
			</div>
			
			<div class="input-box">
				<p>What is your State?</p>
				<select class="select" name="sid_fk" id="sid_fk" onclick="datacall.getcity()">
				</select>
				<br> <span
					class="error" style.color="#ff0000" id="sid-error"
					onchange="sid-error.setStyle('display','none');"></span>
			</div>
			
			
			<div class="input-box">
				<p>What is your City?</p>
				<select class="select" id="cid_fk" name="cid_fk" >
				</select>
				<br> <span
					class="error" style.color="#ff0000" id="cid-error"
					onchange="cid-error.setStyle('display','none');"></span>
			</div>
			
			
			<div class="input-box">
				<p>What is your Role?</p>
				<select class="dropdown" name="rid_fk" id="rid_fk" required>
          <%
			UserDao dao=new UserDao();
			List list=(List)dao.getrole();
			
			for(int i=0;i<list.size();i++)
			  { 
				role101 role=(role101)list.get(i);
				  
		 %>
           <option value="<%=role.getRid()%>" name="role"><%=role.getRname()%></option>
        <%
 		 }
  		%>
                </select>
                <br> <span
					class="error" style.color="#ff0000" id="rid-error"
					onchange="rid-error.setStyle('display','none');"></span>
			</div>
			

			<div class="input-box">
				<p>Type Password?</p>
				<input id="password" type="password" placeholder="Enter Your Password"
					name="password" onkeyup="validation.pwdvalid()" ondrop="return false;" onpaste="return false;"
					onblur="validation.pwdvalid()" oninput="validation.pwdvalid()"><br> <span
					class="error" style.color="#ff0000" id="pwd-error"
					onchange="pwd-error.setStyle('display','none');"></span>
			</div>
			<hr>

			<input type="hidden" name="action" value="registration">
			<button type="submit" class="registerbutton" name="submit" onclick="validation.checkTrueOnButton();">Register</button>
			<p>Already have an account? <a class="reg-link" href="#" onclick="popup.loginshow();">
				<span>Log in</span></a> .
			</p>
		</form>
	</div>
</body>
</html>