

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String userid=request.getParameter("username");
		String password=request.getParameter("password");
		String usertype=request.getParameter("usertype");
		//System.out.println(userid+password+usertype);
		boolean flag=false;
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","mysql");
			Statement stmt=con.createStatement();

			ResultSet rs=stmt.executeQuery("select * from emp");
			
		if(usertype.equals("A")) {
			while(rs.next()) 
			{

				if(userid.equals(rs.getString(1))&&password.equals(rs.getString(2)))
				{
					flag=true;
					response.sendRedirect("admin");
				}
			}
			if(flag==false) {
				out.print("invalid userid or password or usertype");
			}
		}
		else if(usertype.contentEquals("E")) {
			while(rs.next()) 
			{

				if(userid.equals(rs.getString(1))&&password.equals(rs.getString(2)))
				{
					flag=true;
					response.sendRedirect("emp");
				}
			}
			if(flag==false) {
				out.print("invalid userid or password or usertype");
			}
		}
		
	    }catch(Exception p)
	    {
	    	out.print(p);
	    }
	}

}
