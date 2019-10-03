

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String userid=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		boolean flag=false;
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "mysql");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from users");
			while(rs.next()) {
				if(userid.equals(rs.getString(1))&&password.equals(rs.getString(2)))
				{
					
					flag=true;
					
					response.sendRedirect("sks");
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
