<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int i = (int)request.getAttribute("result"); %>

	Captcha value<input type=text value=<%= i %> id=c3 disabled>
		<button type=button onclick=loadCaptcha()>Refresh</button>
		<br>Enter the captcha value<input type=text id=cc1>
		<button type=button onclick=ValidateCaptcha()>Validate</button>
		
</body>
</html>