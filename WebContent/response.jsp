<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
    String constellationFullname = (String) request.getAttribute("constellationFullname");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Constellation Lookup App</title>
</head>
<body>

	<h1>Welcome to the Constellation Lookup App</h1>

	<p>The full constellation name is: <%=constellationFullname%></p>

	<a href="con_lookup.jsp">Do Another Lookup</a>
</body>
</html>