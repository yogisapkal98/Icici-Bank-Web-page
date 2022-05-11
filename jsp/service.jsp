<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String contextpath = request.getContextPath();%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Service page</title>
<link href="<%=contextpath%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrap">
		<%@include file="Header.jsp"%>
		<br>
		<!-- grid section starts-->
		<input id="contextpath" type="hidden" name="contextpath" value="<%=contextpath%>">
		<div id="grids">
			<div class="grid-container">
				<div class="grid-item">
					<h3 class="grid-text" >BALANCE</h3>
					<div id="1">
						<p id="balance" class="small">Your balance is:</p>
						<p id="bal"></p>
						<button id="balance2" name="balance" value="<%=session.getAttribute("ac_no")%>" onclick="datacall.getbalance();">
							<span style="color: blue">Show Balance</span>
						</button>
					</div>
				</div>
				<div class="grid-item">
					<h3 class="grid-text" >DEPOSIT</h3>
					<div id="2">
						<input type="number" placeholder="Enter amt to deposit"
							id="deposit2" name="deposit2" />
						<button onclick="datacall.deposite();">
							<span style="color: blue">Deposit</span>
						</button>
						<p id="deposite"></p>
					</div>
				</div>
				<div class="grid-item">
					<h3 class="grid-text" >WITHDRAW</h3>
					<div id="3">
						<input type="number" placeholder="Enter amt to deposit"
							id="withdraw2" name="withdraw2" />
						<button onclick="datacall.withdraw();">
							<span style="color: blue">Withdraw</span>
						</button>
						<p id="withdraw"></p>
					</div>
				</div>
				<div class="grid-item">
					<h3 class="grid-text">TRANSFER</h3>
					<div id="4">
						<select name="payee" id="payee">
							<option value=""></option>
						</select>
						<button>
							<span style="color: red" id="myBtn">Add Payee</span>
						</button>
						<input type="number" placeholder="Enter amt to Transfer"
							id="transfer" name="transfer" />
						<button>
							<span style="color: red" id="myBtn">Transfer</span>
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- grid section ends -->

		<%@include file="Footer.jsp"%>
	</div>
</body>
</html>