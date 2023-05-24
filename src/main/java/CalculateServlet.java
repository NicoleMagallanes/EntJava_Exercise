import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculateServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve form inputs
		String employeeId = request.getParameter("employeeId");
		String employeeName = request.getParameter("employeeName");
		String salesCode = request.getParameter("salesCode");
		double salesAmount = Double.parseDouble(request.getParameter("salesAmount"));

		// Calculate gross earned amount based on sales code
		double grossEarned;
		if (salesCode.equalsIgnoreCase("A")) {
			grossEarned = 175 + (0.5 * salesAmount);
		} else if (salesCode.equalsIgnoreCase("B")) {
			grossEarned = 100 + (0.2 * salesAmount);
		} else {
			// Invalid sales code, handle appropriately (e.g., display error message)
			return;
		}

		// Calculate additional sales commission if sales amount is greater than 2500
		double commission = 0;
		if (salesAmount > 2500) {
			commission = 0.05 * salesAmount;
		}

		// Calculate take home pay
		double takeHomePay = grossEarned + commission;

		// Set response content type
		response.setContentType("text/html");

		// Write the output as HTML response
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Take Home Pay Calculation</title>");
		out.println("<style>");
		out.println("body { font-family: Arial, sans-serif; background-color: #F5F5F5; }");
		out.println("h1 { color: #333333; text-align: center; }");
		out.println("h2 { color: #666666; }");
		out.println("p { margin: 5px 0; }");
		out.println("strong { font-weight: bold; }");
		out.println("hr { border: none; border-top: 1px solid #CCCCCC; margin: 10px 0; }");
		out.println("a { color: #0000FF; text-decoration: none; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Take Home Pay</h1>");
		out.println("<h2>Total Result: </h2>");
		out.println("<fieldset>");
		out.println("<legend>Employee Information</legend>");
		out.println("<p><strong>Employee Id:</strong> " + employeeId + "</p>");
		out.println("<p><strong>Employee Name:</strong> " + employeeName + "</p>");
		out.println("</fieldset>");
		out.println("<fieldset>");
		out.println("<legend>Sales Information</legend>");
		out.println("<p><strong>Sales Code:</strong> " + salesCode + "</p>");
		out.println("<p><strong>Sales Amount:</strong> " + salesAmount + "</p>");
		out.println("</fieldset>");
		out.println("<hr>");
		out.println("<fieldset>");
		out.println("<p><strong>Take Home Pay:</strong> " + takeHomePay + "</p>");
		out.println("<p><strong>Gross Earned:</strong> " + grossEarned + "</p>");
		out.println("<p><strong>Sales Commission:</strong> " + commission + "</p>");
		out.println("<hr>");
		out.println("</fieldset>");
		out.println("<fieldset>");
		out.println("<button onclick=\"location.href='index.html'\">GO BACK</button>");
		out.println("</fieldset>");
		out.println("</body>");
		out.println("</html>");
	}
}
