<%@ page import="java.sql.*" %>
<%@ page import="DB_Connection.Connections" %>
<%@ page import="java.io.PrintWriter" %>
<%

    String taskId = request.getParameter("TaskName");
    PrintWriter pw=response.getWriter();

    if (taskId != null && !taskId.trim().isEmpty()) {
        try (Connection conn = Connections.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM tasks WHERE Task_ID = ?")) {


            pstmt.setInt(1, Integer.parseInt(taskId));


            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
              pw.print("Dleted Successfully..!");
            } else {
                pw.print("Dletetion failed..!");
            }
        } catch (Exception e) {
           pw.println(e.getMessage());
        }
    } else {
        pw.print("Invalid task!");
    }
%>
