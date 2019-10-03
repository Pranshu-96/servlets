

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class input
 */
@WebServlet("/input")
public class input extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int input=Integer.parseInt(request.getParameter("input"));
		//System.out.println(input+"asdfwsf");
		if(input<10) {
			response.sendRedirect("servlet1");
		}
		else if(input>=10&&input<99) {
			response.sendRedirect("servlet2");
		}
		else {
			response.sendRedirect("error");
		}
	}



}
