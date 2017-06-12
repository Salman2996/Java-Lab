<%@ page language="java" import="java.sql.*"
		 contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Details</title>
</head>
<body>
	<%
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String fday=request.getParameter("fday");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/lab12","root","root");
			stmt=conn.createStatement();
			String sql="select * from flight where weekdays='"+fday+"'";
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				out.println("<p>Flight Number: "+rs.getString(1)+"</p>");
				out.println("<p>Flight Name: "+rs.getString(2)+"</p>");
				out.println("<p>Weekdays: "+rs.getString(3)+"</p>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	%>
</body>
</html>