<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <!-- ingresar aqui el usuario conectado -->
 <form method = "post" action = "servletCliente">
<table>

<tr>
     <td><b>Ingrese nombre de Usuario:</b></td>
     <td><input type="text" name="txtNombreUsuario" required/></td>
</tr>
<tr>
<td><b>Nueva Contrase�a:</b></td>
<td>
<input type="password" name="txtContrase�a" required/><td>
</tr>
<tr>
<td>
<b>Confirmar Contrase�a:</b>
</td>
<td><input type="password" name="txtConfirmarContrase�a" required/><td></td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="btnCambiarContrase�a" value="Cambiar Contrase�a"/></td>

</tr>
</table>

<%

boolean cambiada = false;
int existeUser = -1;
int igual = -1;

if (request.getAttribute("UserExiste")!=null)
{
	existeUser = Integer.parseInt(request.getAttribute("UserExiste").toString());
}


if (request.getAttribute("cambioExitoso")!=null)
{
	cambiada = Boolean.parseBoolean(request.getAttribute("cambioExitoso").toString());
}


if (request.getAttribute("igualPass")!=null)
{
	igual = Integer.parseInt(request.getAttribute("igualPass").toString());
}
%>


<%
if (existeUser==0)
{
%>
<h2>El usuario no se encuentra registrado</h2>
<%} %>

<%
if (cambiada == true)
{
%>
<h2>La contrase�a fue cambiada exitosamente</h2>
<% } %>


<%
if (igual == 0)
{
%>

<h2>Las contrase�as deben ser iguales</h2>

<%} %>
</form>
</body>
</html>