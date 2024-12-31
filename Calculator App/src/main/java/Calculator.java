import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Calculate")
public class Calculator extends GenericServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // Set the response content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // Get input parameters from the form
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");
        String operator = request.getParameter("Add");

        // Initialize result variable
        String result = "";

        try {
            // Parse the numbers
            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);
            // Perform calculations based on the selected operator
            int Result;
            switch (operator) {
                case "Addition  (+)":
                    Result = num1 + num2;
                    out.print( "Result: " + Result);
                    break;
                case "Substraction  (-)":
                    Result = num1 - num2;
                    out.print( "Result: " + Result);
                    break;
                case "Multiplication  (*)":
                    Result = num1 * num2;
                    out.print( "Result: " + Result);
                    break;
                case "Division (/)":
                    if (num2 != 0) {
                        Result = num1 / num2;
                        out.print( "Result: " + Result);
                    } else {
                        out.print( "Error: Division by zero is not allowed.");
                    }
                    break;
                case "Reminder (%)":
                    if (num2 != 0) {
                        Result = num1 % num2;
                        out.print( "Result: " + Result);
                    } else {
                        out.print( "Error: Division by zero is not allowed.");
                    }
                    break;
                default:
                   out.print("Error: Invalid operator.");
            }
        } catch (NumberFormatException e) {
            out.print("Error: Please enter valid numbers.");
        }
        request.setAttribute("calculationResult", result);

        // Forward the request back to the same page
        RequestDispatcher dispatcher = request.getRequestDispatcher("Result");
        dispatcher.forward(request, response);
    }
}
