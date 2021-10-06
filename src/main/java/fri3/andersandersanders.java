package fri3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/andersandersanders")
public class andersandersanders extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String fruktType = request.getParameter("frukt");

		out.println(HTMLhead());
		int eple=0;
		int appelsin=0;
		int banan=0;
		
		if(fruktType.equals("eple")) {
			eple++;
		}else if(fruktType.equals("appelsin")) {
			appelsin++;
		}else if(fruktType.equals("banan")) {
			banan++;
		}
		
		out.print("<p>eple:"+eple+"</p>");
		out.print("<p>appelsin:"+appelsin+"</p>");
		out.print("<p>banan:"+banan+"</p>");
		
		
		
		
		out.println(HTMLlegs());

	}
	
	private String HTMLhead() {
		return
		"<!DOCTYPE html>"
		+"<html>"
		+"<head>"+"<meta charset=\"ISO-8859-1\">"
		+"<title>resultat</title>"
		+"</head>"
		+"<body>";
	}
	private String HTMLlegs() {
		return
		"<a href=\"http://localhost:8080/friopgpreoblig3/FavorittFrukt.html\">gå tilbake</a>"
		+"</body>"
		+"</html>";
	}

}
