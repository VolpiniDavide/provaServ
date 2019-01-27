<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="it.onyx.Login.dao.UserDao" %>
<%@ page import="java.util.ArrayList" %>
<% ArrayList<UserDao> users = (ArrayList<UserDao>) request.getAttribute("users");%>


	<p> your first name : ${ firstName } </p>
	<p> your last name : ${ lastName } </p>
	<p> your email : ${ email } </p>
	<p> your phone number : ${ number } </p>
	<p> your password : ${ password } </p>
	<p> your id : ${ id } </p>
		
	<br>
	<br>
	<br>
	
	<table id="table_id" class="display">
    <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Telephone number</th>
            <th>id</th>
        </tr>
    </thead>
    <tbody>
        <%
        	if(users != null){
        
        	for(int i = 0; i<users.size(); i++ ){
        		
        		out.println("<tr>");
        		out.println("<td>"+users.get(i).getNome()+"</td>");
        		out.println("<td>"+users.get(i).getCognome()+"</td>");
        		out.println("<td>"+users.get(i).getEmail()+"</td>");
        		out.println("<td>"+users.get(i).getNum_telefono()+"</td>");
        		out.println("<td>"+users.get(i).getPassword()+"</td>");
        		out.println("<td>"+users.get(i).getId_cliente()+"</td>");
        		out.println("</tr>");
        	}
        	}
        
        %>
       
    </tbody>
</table>









<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf8" src="JS/tableScript.js"></script>
</body>
</html>