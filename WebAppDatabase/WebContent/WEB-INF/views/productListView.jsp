<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WebApp Product list</title>
<link rel="stylesheet" type="text/css" href="css/style.css">	
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	<h4 class="error"> ${errorMessage}</h4>
	<h3>Product List</h3>
	<table>
		<tr>
			<th>Code</th>
			<th>Name</th>
			<th>Price</th>
			<th>edit</th>
			<th>delete</th>
		</tr>
		<c:forEach var="product" items="${productList}">
			<tr>
				<td>${product.code}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td><form action="editProduct?code=${product.code}">
					<input type="submit" value="edit">
				</form></td>
				<td><form action="deleteProduct?code=${product.code}">
					<input type="submit" value="delete">
				</form></td>
			</tr>
		</c:forEach>
	</table>
	<form action="createProduct">
		<input type="submit" value="create new">
	</form>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>