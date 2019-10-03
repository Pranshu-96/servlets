

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String userid=request.getParameter("username");
		String password=request.getParameter("password");
		
		ServletContext ctx = getServletContext();
		String Admin=ctx.getInitParameter("admin");
		String Pass=ctx.getInitParameter("pass");
		
		boolean flag=false;
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/topic3", Admin , Pass);
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from cred");
			while(rs.next()) {
				if(userid.equals(rs.getString(1))&&password.equals(rs.getString(2)))
				{
					
					flag=true;
					
					out.print("You are Loged In");
				}
			}
			if(flag==false) {
				out.print("invalid userid or password");
			}
	    }catch(Exception p)
	    {
	    	out.print(p);
	    }
	}

	

}
