<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="main.java.com.ping23.HIPStar.controller.ConstellationServlet"%>

<%
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Constellation Lookup App</title>
</head>
<body>

<h1>Welcome to the Constellation Lookup App</h1>

<p>
Please enter an IAU Constellation Abbreviation
</p>

<form name='constellationForm' id='constellationForm' action='constellations' method='get'>
<p>
<input type='text' name='iau_con' id='iau_con'/>
</p>

<input type='submit' name='submit' id='submit' value='Go!' />

</form>

</body>
</html>