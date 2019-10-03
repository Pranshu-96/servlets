

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class addtraining
 */
@WebServlet("/addtraining")
public class addtraining extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		try {
	    	Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/addtraining","root","mysql");
//			Statement stmt=con.createStatement();
			PreparedStatement st=con.prepareStatement("insert into addtraining values(?,?,?,?,?,?,?)");
			st.setString(1, request.getParameter("trainingid"));
			st.setString(2, request.getParameter("trainingname"));
			st.setString(3, request.getParameter("startdate"));
			st.setString(4, request.getParameter("enddate"));
			st.setString(5, request.getParameter("trainingmode"));
			st.setString(6, request.getParameter("BU"));
			st.setString(7, request.getParameter("CID"));
			
			st.executeUpdate();
			
			st.close();
			con.close();
			out.println("<html><body><b>Successfully Inserted"+ "</b></body></html>");
			

//			ResultSet rs=stmt.executeQuery("insert into addtraining(trainingid ,trainingname ,startdate ,enddate ,trainingmode ,BU ,CID)values(trainingid ,trainingname ,startdate ,enddate ,trainingmode ,BU ,CID" );
//			
		}catch(Exception p)
	    {
	    	out.print(p);
	    }
	}

	

}
