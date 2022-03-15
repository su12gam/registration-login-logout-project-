<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function validate(form) {
		var userName = form.userName.value;
		var password = form.password.value;
		var specialCharacters = '/^[a-zA-Z0-9!@#$%^&*]{6,16}$/';
		var address = form.address.value;
		var emailId = form.emailId.value;
		var contactNo = form.contactNo.value;
		var phone = "0/91)?[7-9][0-9]{9}";
		var correct='/^[A-Za-z]+$/^';

		alert(userName + " - " + password);
		if (userName == "" || userName.length < 4) {
			document.getElementById("nameErr").innerHTML = "<b>Person Name Is Required and should contain minimum 5 characters</b>";
			return false;
		}
		if (password == "" || password.length < 4) {
			document.getElementById("passwordErr").innerHTML = "<b>Password Is Required</b>";
			return false;
		} else if (!specialCharacters.test(password)) {
			document.getElementById("passwordErr").innerHTML = "<b>Please Provide With Atleast One Special Characters";
			return false;
		}
		if (address == "" || address.length > 10) {
			document.getElementById("addressErr").innerHTML = "<b>Addres should not contain more than 10 characters</b>";
			return false;
		}else if(!correct.test(address)){
			document.getElementById("addressErr").innerHTML = "<b>Addres should contain only Alphabet</b>";
			return false;
		}
		if (!contactNo.test(phone)) {
			document.getElementById("contactErr").innerHTML = "<b>Follow proper pattern to add contact number</b>";
			return false;
		}
	}
</script>
<style type="text/css">
body {
	background-color: #ffb3b3;
	text-align: center;
}
</style>
</head>
<body>
	<fieldset>
		${RegisterError}
		<form action="Reg" method="post" onsubmit="return validate(this)">
			<table>
				<tr>
					<td>Enter User Name :</td>
					<td><input type="text" id="userName" name="userName"></td>
					<td><span style="color: red" id="nameErr"></span></td>
				</tr>
				<tr>
					<td>Enter Password :</td>
					<td><input type="password" id="password" name="password"></td>	
					<td><span style="color: red" id="passwordErr"></span></td>
				</tr>
				<tr>
					<td>Enter Address :</td>
					<td><input type="text" id="address" name="address"></td>
					<td><span style="color: red" id="addressErr"></span></td>
				</tr>
				<tr>
					<td>Enter Email Id :</td>
					<td><input type="email" id="emailId" name="emailId"></td>
				</tr>
				<tr>
					<td>Enter Contact Number :</td>
					<td><input type="tel" id="contactNo" name="contactNo"></td>
					<td><span style="color: red" id="contactErr"></span></td>
				</tr>
				<tr>
					<td><a href="login.jsp" >Click here to login</a></td>
					<td><input type="submit" value="Save"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>