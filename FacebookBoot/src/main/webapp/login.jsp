<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String email = request.getAttribute("email").toString();
   boolean i = (boolean)request.getAttribute("value");
   
   if(i==true){
            ServletContext sc=getServletContext(); //calling servlet container
			sc.setAttribute("userid",email);       //sharing value of email with servlet container
			
			HttpSession ss=request.getSession(true); //creating session to share information bydefault session will be valid for 30 minutes
			ss.setAttribute("userid",email);%>
   
    <br> Welcome <%= email%> 
		 
		  <br><a href=Viewprofile>view Profile</a>
		  <br><a href=EditProfile>Edit Profile</a>
		  <br><a href=DeleteProfile>Delete Profile</a>
		  <br><a href=searchprofile.html>Search Profile</a>
		  <br><a href=ViewAllProfile>ViewAll Profile</a>
		  <br><a href=TimeLine>TimeLine</a>
		  <br><a href=Friends>People you may know</a>
		  <br><a href=FriendRequests>Friends Requests</a>
		  <br><a href=FriendList>Friends List</a>
		  <br><a href=Messages>Messages</a>
		 
		  <br><a href=logout>Logout</a>
		  <% }
      else{%>
		  	
			  <br><a href=loginpage.html>Try Again</a>
		<%} %>

</body>
</html>