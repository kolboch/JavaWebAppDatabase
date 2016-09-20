<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.IOException" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Outer jsp file</title>
</head>
<body>
	<%!
		private boolean areYouCrazy(String name){
			if(name.equals("Janusz")){
				return true;
			}
			else{
				return false;
			}
		}
	
		public void namesCrazinessTest(JspWriter stream){
			try{
				stream.println("Testing names: Janusz, Krzysztof." + "<br/>");
				stream.println("Is Janusz Crazy?: " + areYouCrazy("Janusz") + "<br/>");
				stream.println("Is Krzysztof Crazy?: " + areYouCrazy("Krzysztof"));
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	%>
	<h3>This is simple test of names.</h3>
	<% namesCrazinessTest(out); %>
	<br/>
	<h5>Shocked with the results?!</h5>
</body>
</html>