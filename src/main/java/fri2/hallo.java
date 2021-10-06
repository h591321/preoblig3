package fri2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hallo")
public class hallo extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println( "<head>"+"<meta charset=\"ISO-8859-1\">");
		out.println("<title>Hallo name</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<p>Hallo "+request.getParameter("name")+"!</p>");
		
		
		out.println("<a href=\"http://localhost:8080/friopgpreoblig3/navn.html\">gå tilbake</a>");
		out.println("</body>");
		out.println("</html>");		

	}



}
