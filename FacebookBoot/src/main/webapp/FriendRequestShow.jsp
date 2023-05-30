<%@page import="com.Facebook.FacebookBoot.entity.FriendList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<FriendList> fl =(List<FriendList>) request.getAttribute("result"); 
     for(FriendList fl1: fl){
    	 String name =fl1.getSt().getName();
    	 long id = fl1.getFriendId();  %>
    	 <br><form method= post action=ConfirmRequests>
    	 <br><p><%= name %></p>
    	 <br><input type=hidden name="senderid" value=<%= id %>>
    	 <br><button type="submit" >Confirm</button>
    	 </form>
    	 <form action="DeleteRequest">
    	  <br><input type=hidden name="senderid" value=<%= id %>>
    	 <br><button type="submit">Delete</button>
    	 </form>
    	 
    	 
     <% }%>

</body>
</html>