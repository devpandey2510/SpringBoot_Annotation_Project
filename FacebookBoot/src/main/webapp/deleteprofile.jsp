<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int i =(int)request.getAttribute("result"); %>

<% if(i>0) {%>
	profile deleted"
	<% try {
		Thread.sleep(5000);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	RequestDispatcher rd = getServletContext().getRequestDispatcher("/Registration.html");
	rd.forward(request, response);%>
<%} 
else { %>
	profile could not be deleted
<% }%>

</body>
</html>