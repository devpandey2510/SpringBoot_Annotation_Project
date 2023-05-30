<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.Facebook.FacebookBoot.entity.Facebookuser" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Facebookuser fu2 =(Facebookuser)request.getAttribute("result");
   if(fu2!=null) {%>
		   <br> Your name is <%= fu2.getName()%>
		   <br> Your email is <%= fu2.getEmail()%>
		   <br> Your password is <%= fu2.getPassword()%>
		   <br> Your address is <%= fu2.getAddress()%>
		   <br> Want to login
		   <br><a href=loginpage.html>Continue...</a>
		<% }
		else {%>
			something went wrong
		<% }%>

</body>
</html>