import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Calculate")
public class Calculator extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set response content type
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            // Parse inputs
            int num1 = Integer.parseInt(req.getParameter("num1"));
            int num2 = Integer.parseInt(req.getParameter("num2"));
            String operator = req.getParameter("Opt");

            String result;

            // Perform operation
            switch (operator) {
                case "Addition  (+)":
                    result = "Result: " + (num1 + num2);
                    break;
                case "Substraction  (-)":
                    result = "Result: " + (num1 - num2);
                    break;
                case "Multiplication  (*)":
                    result = "Result: " + (num1 * num2);
                    break;
                case "Division (/)":
                    if (num2 == 0) {
                        result = "Error: Division by zero is not allowed.";
                    } else {
                        result = "Result: " + (num1 / (float) num2);
                    }
                    break;
                case "Reminder (%)":
                    if (num2 == 0) {
                        result = "Error: Modulus by zero is not allowed.";
                    } else {
                        result = "Result: " + (num1 % num2);
                    }
                    break;
                default:
                    result = "Error: Invalid operator.";
                    break;
            }

//            // Output result to client
//            out.println("<html><body>");
//            out.println("<h1>Calculator Result</h1>");
//            out.println("<p>" + result + "</p>");
//            out.println("</body></html>");
            req.setAttribute("result", result);
          //  RequestDispatcher rq=req.getRequestDispatcher("Result.jsp");
          //  rq.forward(req, resp);

        } catch (NumberFormatException e) {
            out.println("<html><body>");
            out.println("<h1>Error</h1>");
            out.println("<p>Invalid input. Please enter valid numbers.</p>");
            out.println("</body></html>");
        } finally {
            out.close();
        }
    }
}
