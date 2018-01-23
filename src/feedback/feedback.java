package feedback;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public feedback() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String eno = request.getParameter("eno");
		String email = request.getParameter("email");
		String fb = request.getParameter("fb");
		
		
		
			try
			{
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://au-cdbr-sl-syd-01.cleardb.net/ibmx_e805ff56e1f40b3?user=bf1cfefdc18da7&password=5a321823");
			 String sql = "insert into feedback values ('"+name+"','"+eno+"','"+email+"','"+fb+"')";
			 
			 PreparedStatement ps = con.prepareStatement(sql);
			 int i = ps.executeUpdate();
			 
			 if(i > 0) {
				 response.sendRedirect("subfb.jsp");
			 }
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}

}
