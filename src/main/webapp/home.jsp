<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@page import="javax.print.attribute.standard.RequestingUserName"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${message}<br>
	<%-- <%request.getSession().getAttribute("username"); % --%>
	Welcome ${username}
	<br>
	Already Register Login Here.....
	<a href="login.jsp">Login</a>
	<br>
	<a href="register.jsp">Register</a>&nbsp;&nbsp;&nbsp;<a href="aboutus.jsp">About Us</a><br>
	<form action="Logout">
		<input type="submit" value="Log-out">

	</form>
</body>
</html>