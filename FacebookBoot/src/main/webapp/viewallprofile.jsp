<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.ArrayList"%>
    <%@page import="com.Facebook.FacebookBoot.entity.Facebookuser"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% ArrayList<Facebookuser> st =(ArrayList<Facebookuser>)request.getAttribute("result"); %>

  <% for(Facebookuser st2: st) {%>
			
		   <br>Name is <%= st2.getName() %> 
		   <br>Email is <%= st2.getEmail() %>
		   <br>Address is <%= st2.getAddress() %>
		  
		<%} %>

</body>
</html>