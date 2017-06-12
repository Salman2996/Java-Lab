<%@ page language="java" import="java.util.*,java.text.DateFormat,java.text.SimpleDateFormat"  
			contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	ArrayList<String> placesOfWork = new ArrayList<String>();
	placesOfWork.add("Bangalore");
	placesOfWork.add("Mysore");
	placesOfWork.add("Pune");
	
	HashMap<String,String> users = new HashMap<String,String>();
	users.put("admin","admin");
	users.put("user","user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	if(!users.containsKey(username)){
		out.println("<script type=\"text/javascript\">");
		out.println("alert('User does not exist!');");
		out.println("location='Login.html';");
		out.println("</script>");
	}else{
		if(!users.get(username).equals(password)){
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Invalid password!');");
			out.println("location='Login.html';");
			out.println("</script>");
		}
	}
%>
</head>
<body>
	<h2>Welcome, <%= request.getParameter("username") %>!</h2>
	<h4>Today's date is: 
	<%
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		out.println(dateFormat.format(date)); //2016/11/16 12:08:43
	%>
	</h4>
	<form action="CalculateTax.jsp" method="POST">
        <p>Name:<input type="text" name="name"></p><br>
        <p>Place of Work:
        	<select name="workplace">
		  	<%
		  		for(String s : placesOfWork){
		  			out.print("<option value=\""+s+"\">");
		  			out.print(s);
		  			out.print("</option>");
		  		}
		  	%>
			</select></p><br>
			
        <p>Gender:
        	<select name="gender">
		  		<option value="male">Male</option>
		  		<option value="female">Female</option>
		  		<option value="other">Other</option>
			</select></p><br>
			
        <p>Annual Income:<input type="number" name="income"></p><br>
        <input type="submit" value="Calculate Tax" name="calc">
	</form>
</body>
</html>