

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession session=request.getSession();
		Date createTime=new Date(session.getCreationTime());
		Date lastAccessTime= new Date(session.getLastAccessedTime());
		
		String title="Welcome back";
		Integer visitCount=new Integer(0);
		String visitCountKey=new String("visitCount");
		String userIDKey=new String("user ID");
		String userID=new String("ABCD");
		
		if(session.isNew()) {
			title="Welcome new User";
			session.setAttribute(userIDKey, userID);
		}else {
			visitCount=(Integer)session.getAttribute(visitCountKey);
			visitCount=visitCount+1;
			userID=(String)session.getAttribute(userIDKey);
		}
		session.setAttribute(visitCountKey, visitCount);
		
		out.print(title);
		
	}

	

}
