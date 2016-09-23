<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<form action="registryData" method="POST">
		First Name: <input type="text" name="firstName"/><br/>
		Second Name: <input type="text" name="secondName"/><br/>
		City: <input type="text" name="city"/><br/>
		Post-code: <input type="text" name="postCode" placeholder="99-999"/><br/>
		Street: <input type="text" name="street"/><br/>
		Number: <input type="text" name="number"/><br/>
		<input type="submit" value="send!"/>
	</form>
</body>
</html>