<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>控制台</title>

<%
    if(session.getAttribute("username") == null) {
    	response.sendRedirect("../login.html");
    }
%>


</head>
<body>
	这是控制台
</body>
</html>