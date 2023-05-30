<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int i = (int)request.getAttribute("result");
  if(i>0){%>
  Requested had been deleted;
  <%} else{ %>
  Something went wrong
  <%} %>
</body>
</html>