<%@ page import="com.example.dashboard.model.User" %>
<%@ page session="true" %>
<%
    User user = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<h2>Welcome, <%= user.getUsername() %>!</h2>
<p>This is your dashboard.</p>
<a href="login.jsp">Logout</a>
</body>
</html>