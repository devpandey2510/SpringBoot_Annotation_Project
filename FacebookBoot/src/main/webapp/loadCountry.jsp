<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="com.Facebook.FacebookBoot.entity.Country"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  List<Country> n = (List<Country>)request.getAttribute("result"); %>
<select>

<%for(Country cc: n){ %>
<option><%= cc.getCountryName()%></option> <%} %>

</select>

</body>
</html>