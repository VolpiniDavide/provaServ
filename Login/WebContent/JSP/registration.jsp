<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/logStyle.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="reg">
	<form action="${pageContext.request.contextPath}/RegServlet">
		<input type = "email" name ="email" placeholder ="email" ><br>
		<input type = "password" name ="password" placeholder="password"><br>
		<input type = "number" name ="number" placeholder="phone number"><br>
		<input type = "text" name ="firstName" placeholder="first name"><br>
		<input type = "text" name ="lastName" placeholder="last name"><br>
		<input type="submit" value="invia">
		<p> ${Message} </p>
		</form>
		</div>
		

</body>
</html>