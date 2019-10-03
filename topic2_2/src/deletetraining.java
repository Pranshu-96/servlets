

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deletetraining
 */
@WebServlet("/deletetraining")
public class deletetraining extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out=response.getWriter();
		
		try {
	    	Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/addtraining","root","mysql");
			PreparedStatement st=con.prepareStatement("delete from addtraining where trainingid=(?)");
			st.setString(1, request.getParameter("trainingid"));
			
			st.executeUpdate();
			
			st.close();
			con.close();
			out.println("<html><body><b>Successfully Deleted"+ "</b></body></html>");
			
		}catch(Exception p)
	    {
	    	out.print(p);
	    }
	}


}
