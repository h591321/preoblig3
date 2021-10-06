package fri1;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TemperaturServlet")
public class TemperaturServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		double userInput;
		String userInputFormat, convertedOutput = null;
		
		PrintWriter out = response.getWriter();
		String converterType = request.getParameter("converter");
		DecimalFormat formatter = new DecimalFormat("#0.0");
		out.println(HTMLhead());
		
		
		try {
			userInput = Double.parseDouble(request.getParameter("num"));
			userInputFormat = formatter.format(userInput);

			
				if (converterType.equals("f2c") && isValidNumber(userInput, converterType)) {
					convertedOutput = formatter.format((userInput - 32) * 5 / 9) + "°C";
					userInputFormat += "°F";

				} else if (converterType.equals("c2f") && isValidNumber(userInput, converterType)) {
					convertedOutput = formatter.format((userInput * 9 / 5) + 32) + "°F";
					userInputFormat += "°C";
				}else {
					Double.parseDouble("send to catch"); //dette er en cheeky løsning
				}
				out.println("<p>Temperaturomregning resultat</p>");
				out.println("<p>" + userInputFormat + "=" + convertedOutput + "</p>");

		} catch (NumberFormatException e) {
			out.println(
			"<p>Ugyldig brukerinput. " 
			+ "Temperaturen må være et tall (lik eller over det absoulutte nullpunkt</p>");
		}

		out.println(HTMLlegs());
		
		
	}

	private boolean isValidNumber(double inn, String parameter) {
		if(parameter.equals("f2c")&&inn>=-459.67) {return true;}
		else {return parameter.equals("c2f")&&inn>=-273.15;}
		
	}
	private String HTMLhead() {
		return
		"<!DOCTYPE html>"
		+"<html>"
		+"<head>"+"<meta charset=\"ISO-8859-1\">"
		+"<title>Kvittering</title>"
		+"</head>"
		+"<body>";
	}
	private String HTMLlegs() {
		return
		"<a href=\"http://localhost:8080/friopgpreoblig3/temp.html\">gå tilbake</a>"
		+"</body>"
		+"</html>";
	}


}
