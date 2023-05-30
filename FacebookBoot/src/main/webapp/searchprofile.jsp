<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.*"%>
    <%@page import="com.Facebook.FacebookBoot.entity.Facebookuser"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% ArrayList<Facebookuser> st =(ArrayList<Facebookuser>)request.getAttribute("result");

      if(st!=null){ 

           for(Facebookuser st2: st) {%>
			
		   <br>Name is <%= st2.getName() %> 
		   <br>Email is <%= st2.getEmail() %>
		   <br>Address is <%= st2.getAddress() %>
		  <% 	}  
      
        }  
      else{%>
		<br>Person with such name does not exist or check case sensivity
		<%} %>
 
</body>
</html>