<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WebApp Create product</title>
<link rel="stylesheet" type="text/css" href="css/style.css">	
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	<h3>Create new product!</h3>
	<div class="centerDiv">
	<form method="post" action="doCreateProduct">	
		<h4 class="error">${errorMessage}</h4>
		<table>
			<tr>
				<th>Code</th>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<tr>
				<td>
					<input type="text" name="code" value="${product.code}">
				</td>
				<td>
					<input type="text" name="name" value="${product.name}">
				</td>
				<td>
					<input type="text" name="price" value="${product.price}">
				</td>
			</tr>
			<tr>
				<td></td>
				<td style="text-align:center">
					<input type="submit" value="Submit">
				</td>		
			</tr>
		</table>	
	</form>
	</div>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>