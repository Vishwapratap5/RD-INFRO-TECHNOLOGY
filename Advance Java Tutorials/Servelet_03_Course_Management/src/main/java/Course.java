import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/course")
public class Course implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("inside Course Init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
            System.out.println("inside Course Service");

            String name = servletRequest.getParameter("name");
            String Course = servletRequest.getParameter("Course");
            String description = servletRequest.getParameter("description");
            String Duration = servletRequest.getParameter("Duration");
            String Description=servletRequest.getParameter("Description");
            int Fees=Integer.parseInt(servletRequest.getParameter("Fees"));
            String Operation=servletRequest.getParameter("Operation");

        PrintWriter out = servletResponse.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect= DriverManager.getConnection("jdbc:mysql://localhost:3306/course","root","vishwanj@2316");

            String SQl="Insert into  Course_Management(User_name,Course_name,Fees,Course_Duration,Course_Description) values (?,?,?,?,?)";
            PreparedStatement ps=connect.prepareStatement(SQl);
            ps.setString(1,name);
            ps.setString(2,Course);
            ps.setInt(3,Fees);
            ps.setString(5,Description);
            ps.setString(4,Duration);
            int AffectedRows=ps.executeUpdate();
            if(AffectedRows>0){
                out.println("Course Inserted");
            }else {
                out.println("Course Insertion Failed");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        out.println( "<a href='course'>Home</a>");
        out.println("<br>");
        out.println( "<a href='CourseList'>Show Courses Inserted</a>");
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {
        System.out.println("inside Course Destroy");
    }
}
