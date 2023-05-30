<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.Facebook.FacebookBoot.entity.Facebookuser"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Facebookuser st = (Facebookuser)request.getAttribute("result"); %>
            <br><h1> Edit page</h1> 
		   <br> <form method=post action=EditeProfile1>
		   <br> Name:<input type=text name=nm value= <%= st.getName()%>>
		   <br> Email:<input type=text name=em value=<%= st.getEmail()%> disabled>
		   <br> Password:<input type=text name=pw value=<%= st.getPassword()%>>
		   <br>  Address:<input type=text name=adrs value=<%= st.getAddress() %>>
		   <br> <input type=submit name=btn value=update >
		   </form>
</body>
</html>