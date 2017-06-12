<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tax</title>
</head>
<body>
<%
	String name = request.getParameter("name");
	String income = request.getParameter("income");
	String details = "";
	int i = Integer.parseInt(income);
	float tax = 0;
	if(i <= 100000){
		details = "Your tax bracket is between 0 and 1,00,0000. Tax = 0";
		tax = 0;
	}else if(i > 100000 && i <= 500000){
		details = "Your tax bracket is between 1,00,0001 and 5,00,000. Tax = 15%";
		tax += 0.15*i;
	}else if(i > 500000){
		details = "Your tax bracket is: 5,00,001+. Tax = 20%";
		tax += 0.20*i;
	}
%>

<h2>Hello, <%= name %>!</h2>
<h3>Your income is: <%= i %></h3>
<h3><%= details %>!</h3>
<h3>Your income tax is: <%= tax %></h3>
	
</body>
</html>