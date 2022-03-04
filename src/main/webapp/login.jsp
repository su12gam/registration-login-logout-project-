<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

 <script type="text/javascript">
 	function validate(form) {
		var userName = form.userName.value;
		var password = form.password.value;
		var specialCharacters = /^[a-zA-Z0-9!@#$%^&*]{6,16}$/;
		alert(userName + " - " + password);
		if (userName == "" || userName.length < 4) {
			document.getElementById("nameErr").innerHTML = "<b>Person Name Is Required and should contain minimum 5 characters</b>";
			return false;
		}
		if (password == "" || password.length < 4) {
			document.getElementById("passErr").innerHTML = "<b>Password Is Required</b>";
			return false;
		} else if (!specialCharacters.test(password)) {
			document.getElementById("passErr").innerHTML = "<b>Please Provide With Atleast One Special Characters";
			return false;
		}
	} 
</script> 
<style type="text/css">
body {
	background-color: #ffccff;
	text-align: center;
}
table{
text-align: center;
table-layout: fixed;
t
}
</style>
</head>
<body>
	<h2>LOGIN ACCOUNT</h2>
	<div>
		<fieldset>

			<form action="Login" method="post" onsubmit="return validate(this)">
				<table cellpadding="4" cellspacing="5">
					<tr>
						<td><%=request.getAttribute("errorMessage")%></td>
					</tr>
					<tr>
						<td>Enter the name :</td>
						<td><input type="text" name="userName" id="userName" required></td>
						 <td><span style="color: red" id="nameErr"></span></td>
					</tr>
					<tr>
						<td>Enter the password :</td>
						<td><input type="password" name="password" id="password"></td>
						 <td><span style="color: red" id="passErr"></span></td>
					</tr>
					<tr>
						<td><input type="submit" value="login"></td>
						<td><a href="#">Forget Password?</a> &nbsp;&nbsp; <a
							href="register.jsp">Create new Account</a></td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>
</body>
</html>