<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

	<div id="header" class="centered">
		<h2>Web App database</h2>
	</div>
	<div id="rightHeader">
		Hello <b>${loginedUser.userName}</b>
		<br/>
		Search: <input type="text" name="search">
	</div>

</body>
</html>