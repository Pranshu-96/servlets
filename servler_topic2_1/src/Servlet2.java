

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/sks")
public class Servlet2 extends HttpServlet {


    

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
//		HttpSession session=request.getSession(false);
//		if(session!=null) {
//			String name=(String)session.getAttribute("user");
			out.print("welcome to admin");
//		}
//		response.sendRedirect("Servlet3");
//		
	}

}
