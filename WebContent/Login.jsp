<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style type="text/css">
body {
font-family: arial;
background-color: #8fb4c9;}
h1 {
color: rgb(255,255,255);}
input {
    width: 133px;
    }
</style>



</head>
<body>

<%
String user="";
if(request.getAttribute("Usuario")!=null)
user="EL USUARIO NO EXISTE";
%>

<form method="post" action = "servletLogin">
<h1>Bienvenido a Banco Golden Age</h1>

Usuario:     <input type="text" name="txtUsuario" required/> <br><br>
Contraseña: <input type="password" name="txtContraseña" required /><br><br>
<input type="submit" name="btnLogin" value="Iniciar Sesion" ><br>
</form>
<h1><%=user %></h1>
</body>
</html>