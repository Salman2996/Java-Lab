

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class JDBCLogin
 */
@WebServlet("/JDBCLogin")
public class JDBCLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDBCLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "resource" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search=request.getParameter("search");
		int phno;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/lab9","root","root");
			stmt=conn.createStatement();
			String sql;
			try{
				phno=Integer.parseInt(search);
				sql="select * from tel_dir where phno="+phno;
				rs=stmt.executeQuery(sql);
			}catch(Exception e){
				sql="select * from tel_dir where name='"+search+"'";
				rs=stmt.executeQuery(sql);
			}
			if(rs.next()){
				out.println("<p>Phone Number:"+rs.getInt(1)+"</p><br>");
				out.println("<p>Name:"+rs.getString(2)+"</p><br>");
				out.println("<p>Address:"+rs.getString(3)+"</p><br>");
				out.println("<p>Company:"+rs.getString(4)+"</p><br>");
				out.println("<p>Pin Code:"+rs.getInt(5)+"</p><br>");
			}else
				out.println("<script>alert('No such contact!'); document.location='search.html';</script>");
			out.println("</body></html>");
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
