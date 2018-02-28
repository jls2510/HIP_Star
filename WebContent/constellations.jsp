<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="main.java.com.ping23.HIPStar.HeavenlyData"%>
<%@ page import="main.java.com.ping23.HIPStar.model.Constellation"%>
<%@ page import="java.util.List"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    // List<Constellation> constellations = (List<Constellation>) request.getAttribute("constellations");
    List<Constellation> constellations = HeavenlyData.getConstellations();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Constellation Lookup App</title>
</head>
<body>

<h1>Welcome to the Constellation List</h1>


<form name='constellationForm' id='constellationForm' action='doIt' method='get'>

<select name="constellation">
    <c:forEach items="${constellations}" var="constellation">
        <option value="${constellation.getID()}"><c:out value="${constellation.getName()}" /></option>
    </c:forEach>
</select>

<select name="constellation">
<%
for (Constellation con : constellations)
{
    int id = con.getID();
    String name = con.getName();
%>
    <option value="<%=id%>"><%=name %></option>
<%
}
%>
</select>


<input type='submit' name='submit' id='submit' value='Go!' />

</form>

</body>
</html>