

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class validate
 */
@WebServlet("/validate")
public class validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String user="";
		String passw="";
		
		
		Cookie cookies[]=request.getCookies();
		
		for(Cookie c:cookies) {
			if(c.getName().equals("username")) {
				user=c.getValue();
			}
			else if(c.getName().equals("pass")) {
				passw=c.getValue();
			}
		}
		System.out.println(user+"sadas"+passw);
		
		boolean flag=false;
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/topic3", "root" , "mysql");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from cred");
			while(rs.next()) {
				if(user.equals(rs.getString(1))&&passw.equals(rs.getString(2)))
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
