<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WebApp Login page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	<div class="container">	
		<p class="error">${errorMessage}</p>
		<h4>Log in to access data</h4>
		<form method="post" action="doLogin">
			<p>
				<label for="log">login:</label>
				<input id="log" type="text" name="login"> <br/>
			</p>
			<p>
				<label for="pass">password:</label>
				<input id="pass" type="password" name="password"> <br/>
			</p>
			<p>
				<label for="remember">Remember me!</label>
				<input id="remember" type="checkbox" name="remember" value="Y">
			</p>
			<p>
				<label></label>
				<input type="submit" value="Submit">
			</p>
		</form>
	</div>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>