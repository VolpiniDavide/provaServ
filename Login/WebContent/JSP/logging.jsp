<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
		<form action="LogServlet">
		enter email : <input type = "text" name ="email" value="email"><br>
		enter password : <input type = "text" name ="password" value ="password"><br>
		<input type="submit" value="invia">
		</form>
		
		<p> ${errorMessage} </p>
	
	
</body>
</html>