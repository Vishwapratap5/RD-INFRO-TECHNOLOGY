package Servelets;

import DB_Connection.Connections;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/AddTask")
public class TO_DO_Service extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Taking inputs from user

        String task = request.getParameter("TaskName");
        String description = request.getParameter("Description");
        String date_time = request.getParameter("date&time");

        //created the connection between the DB:Tasks
        Connection con= Connections.getConnection();
        String query="insert into Tasks(Task_Name,Task_Description,Date_Time) values(?,?,?)";
        try {
            PreparedStatement pr=con.prepareStatement(query);
            pr.setString(1,task);
            pr.setString(2,description);
            pr.setString(3,date_time);


            int rowsAffected = pr.executeUpdate();
            if (rowsAffected > 0) {

                response.getWriter().println("Task added successfully!");
            } else {

                response.getWriter().println("Failed to add the task.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
