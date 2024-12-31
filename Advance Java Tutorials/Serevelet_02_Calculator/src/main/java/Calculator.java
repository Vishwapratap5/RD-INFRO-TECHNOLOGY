import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")
public class Calculator implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Present in init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
            System.out.println("Present in service");
            int num1=Integer.parseInt(servletRequest.getParameter("num1"));
            int num2=Integer.parseInt(servletRequest.getParameter("num2"));
            String operation=servletRequest.getParameter("operation");

            String result=switch (operation)
            {
                case "+" ->Integer.toString(num1+num2);
                case "-" ->Integer.toString(num1-num2);
                case "*" ->Integer.toString(num1*num2);
                case "/" ->Integer.toString(num1/num2);
                case "%" ->Integer.toString(num1%num2);
                default -> "Invalid operation";
            };

        PrintWriter out=servletResponse.getWriter();
       out.println(result);
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {
                System.out.println("Present in destroy");
    }
}
