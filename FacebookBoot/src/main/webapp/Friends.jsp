<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.util.ArrayList"%>
    <%@page import="com.Facebook.FacebookBoot.entity.Facebookuser"%>
      <%@page import="com.Facebook.FacebookBoot.entity.FriendList"%>
    <%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">



</script>
<body>

<% ArrayList<Facebookuser> st =(ArrayList<Facebookuser>)request.getAttribute("result"); 
   String senderfriend = (String)request.getAttribute("sender");
       %>

  <% for(Facebookuser st2: st) {
	      
               if(!st2.getEmail().equals(senderfriend)){%>
		 	<form method=post action=AddFriend  id="form1">
						<label><%= st2.getName() %></label><br>
						<input type=hidden name="dost" value=<%= st2.getEmail() %>>
						<button type=submit value="Add Friend">Add Friend</button>
					</form>
					
				
		  
		<%} }%>


</body>
</html>