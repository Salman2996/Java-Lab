<%@ page language="java" import="java.util.*, java.sql.*"
		 contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Details</title>
</head>
<body>
	<%
		int fno=Integer.parseInt(request.getParameter("fno"));
		String date=request.getParameter("date");
		Random r=new Random();
		int s=r.nextInt(500);
		String seat=Integer.toString(s);
		String custName=request.getParameter("custName");
		boolean h=false;
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/lab12","root","root");
			stmt=conn.createStatement();
			String sql="select * from flight where fno='"+fno+"'";
			rs=stmt.executeQuery(sql);
			while(rs.next())
				h=true;
			if(h){
				out.println("<p>Flight Number: "+fno+"</p>");
				out.println("<p>Date: "+date+"</p>");
				out.println("<p>Seat Number: "+seat+"</p>");
				out.println("<p>Customer Name: "+custName+"</p>");
				sql="insert into seat_reservation values("+fno+",'"+date+"','"+seat+"','"+custName+"')";
				stmt.executeUpdate(sql);
			}else
				out.println("<script> alert('Flight Number does not exist'); location='ReserveOnline.html';</script>");
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
	
	<a href="flightdetails.html">Click here for flight details</a>
</body>
</html>