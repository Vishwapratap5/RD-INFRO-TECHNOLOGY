<%--
  Created by IntelliJ IDEA.
  User: revan
  Date: 11-01-2025
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<%
   String Ans=(String) request.getAttribute("result");
%>
<%=
    Ans
%>
  <button type="button" value="back"><a href="index.jsp">BACK</a></button>
</body>
</html>
