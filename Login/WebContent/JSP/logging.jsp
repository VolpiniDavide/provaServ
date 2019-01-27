<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/logStyle.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="login">
		<form action="LogServlet">
		<input type = "text" name ="email" placeholder="email" id ="username"><br>
		<input type = "text" name ="password" placeholder ="password" id="password"><br>
		<input type="submit" value="invia" class="forgot">
		</form>
		<form action="JSP/registration.jsp">
		<a href="JSP/registration.jsp"> <button type="button" class="forgot">register !</button> </a>
		</form>
		</div>
		<p> ${errorMessage} </p>
		
		
		<div class="shadow"></div>
		
		

	
</body>
</html>