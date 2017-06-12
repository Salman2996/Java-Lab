

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String acc = "";
		for(String s : request.getParameterValues("accessories"))
			acc += s+",";
		acc = acc.substring(0, acc.length()-1);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab8", "root", "root");
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO tshirt(accessories,tagline,type,colour) VALUES(\""+acc+
					"\",\""+request.getParameter("tagline")+
					"\",\""+request.getParameter("pocket")+
					"\",\""+request.getParameter("color")+"\")";
			//System.out.println(sql);
			stmt.executeUpdate(sql);
			PrintWriter out=response.getWriter();
			out.println("<html><body><table>");
			out.println("<tr><th>Order No</th>"
					+ "<th>Accessories</th>"
					+ "<th>Tagline</th>"
					+ "<th>Type</th>"
					+ "<th>Colour</th></tr>");
			sql="SELECT * FROM tshirt";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				out.println("<tr><td>"+rs.getString(1)+"</td>"
						+ "<td>"+rs.getString(2)+"</td>"
						+ "<td>"+rs.getString(3)+"</td>"
						+ "<td>"+rs.getString(4)+"</td>"
						+ "<td>"+rs.getString(5)+"</td></tr>");
			}
			out.println("</table></body></html>");
			//out.println("<script>alert('Success!'); document.location='/Lab_8/TShirt.jsp';</script></body></html>");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
