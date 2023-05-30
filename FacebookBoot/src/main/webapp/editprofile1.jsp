<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% String name = request.getAttribute("msg").toString();
   int j =(int)request.getAttribute("result");%>
   
   <% 	if(j>0) {%>
			Hello <%= name%>
		   <br>Your profile has been edited successfully
		   <br>Want to login
		   <br><a href=loginpage.html>Continue...</a>

		<%}
		else {%>
			something went wrong
		<% }%>

</body>
</html>