import com.mysql.cj.protocol.Resultset;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/CourseList")
public class CourseList implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {



        PrintWriter out = servletResponse.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/course","root","vishwanj@2316");

            String SQl="SELECT  * from  Course_Management";
            Statement ps=connect.createStatement();
            ResultSet rs=ps.executeQuery(SQl);

            ResultSetMetaData rsmd=rs.getMetaData();
            int columnCount=rsmd.getColumnCount();
            out.print("<table>");
            out.print("<tr>");
            for(int i=1;i<=columnCount;i++)
            {
                out.print("<td>"+rsmd.getColumnName(i)+"</td>");
            }
            out.println("</tr>");
            while(rs.next()){
                out.print(("<tr><td>"+rs.getInt(1)+"</td></tr>")+("<tr><td>"+ rs.getString(2)+"</td></tr>")+("<tr><td>"+rs.getString(3)+"</td></tr>")+("<tr><td>"+rs.getInt(4)+"</td></tr>")+("<tr><td>"+rs.getString(5)+"</td></tr>")+("<tr><td>"+rs.getString(6) +"</td></tr>"));


            }
            //out.println("/<tr>");
            out.print("/<table>");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
}
