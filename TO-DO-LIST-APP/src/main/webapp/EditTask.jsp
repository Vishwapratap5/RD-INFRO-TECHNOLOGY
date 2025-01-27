<%@ page import="java.sql.*" %>
<%@ page import="DB_Connection.Connections" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/EditTask.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Comic+Neue:ital,wght@0,300;0,400;0,700;1,300;1,400;1,700&display=swap" rel="stylesheet">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Tasks</title>
</head>
<body>
<a href="index.jsp" class="back-btn">Back to Home</a>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Task</th>
    <th>Description</th>
    <th>Time</th>
    <th>Action</th>
  </tr>
  </thead>
  <tbody>
  <%
    // Query to fetch tasks
    String query = "SELECT * FROM tasks";

    // Use try-with-resources for automatic resource management
    try (Connection conn = Connections.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {

      // Iterate through the result set
      while (rs.next()) {
  %>
  <tr>
    <td><%= rs.getInt("Task_ID") %></td>
    <td><%= rs.getString("Task_Name") %></td>
    <td><%= rs.getString("Task_Description") %></td>
    <td><%= rs.getString("Date_Time") %></td>

    <td>
      <button class="action-btn edit-btn">
        <a href="<%= request.getContextPath() %>/Delete.jsp">Update</a>

      </button>
      <button class="action-btn delete-btn">Delete</button>
    </td>
  </tr>
  <%
      }
    } catch (Exception e) {
      out.print("<tr><td colspan='5'>Error: " + e.getMessage() + "</td></tr>");
    }
  %>
  </tbody>
</table>
</body>
</html>
