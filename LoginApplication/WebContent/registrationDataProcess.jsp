<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Processing data</title>
</head>
<body>
	<jsp:useBean id="regData" class="dto.RegisterData" scope="request">
		<!-- 
		<jsp:setProperty property="firstName" name="regData"></jsp:setProperty>
		<jsp:setProperty property="secondName" name="regData"></jsp:setProperty>
		<jsp:setProperty property="city" name="regData"></jsp:setProperty>
		<jsp:setProperty property="postCode" name="regData"></jsp:setProperty>
		<jsp:setProperty property="street" name="regData"></jsp:setProperty>
		<jsp:setProperty property="number" name="regData"></jsp:setProperty>  long form of setting data to object-->
		<jsp:setProperty property="*" name="regData"></jsp:setProperty> <!--  short form -->
	</jsp:useBean>
	Hello <jsp:getProperty property="firstName" name="regData"/> <jsp:getProperty property="secondName" name="regData"/>!<br/>
	City: <jsp:getProperty property="city" name="regData"/><br/>
	post code: <jsp:getProperty property="postCode" name="regData"/><br/>
	Street: <jsp:getProperty property="street" name="regData"/><br/>
	Number: <jsp:getProperty property="number" name="regData"/><br/>
</body>
</html>