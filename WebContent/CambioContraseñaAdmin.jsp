<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cambiar contraseña Admin</title>
<style type="text/css">
body {
font-family: arial;
}

  
div{
text-align: center;}

   footer{
   color: rgb(184, 134, 11);
   
   }

</style>
</head>
<body>
 <!-- ingresar aqui el usuario conectado -->
 <form method = "post" action = "servletCliente">
 <div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<a href="Login.jsp">
<img alt="golden age" src="C:\Users\usuario\Desktop\TP5_AaronMeza\TP_IntegradorG6\Imagenes\Golden age.JPEG">
</a>
</div>
<table>

<tr>
     <td><b>Ingrese nombre de Usuario:</b></td>
     <td><input type="text" name="txtNombreUsuario" required/></td>
</tr>
<tr>
<td><b>Nueva Contraseña:</b></td>
<td>
<input type="password" name="txtContraseña" required/><td>
</tr>
<tr>
<td>
<b>Confirmar Contraseña:</b>
</td>
<td><input type="password" name="txtConfirmarContraseña" required/><td></td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="btnCambiarContraseña" value="Cambiar Contraseña"/></td>

</tr>
</table>
<a href="MenuClientesAdmin.jsp">Volver al menú anterior</a>

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
<h2>La contraseña fue cambiada exitosamente</h2>
<% } %>


<%
if (igual == 0)
{
%>

<h2>Las contraseñas deben ser iguales</h2>

<%} %>
</form>
<div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<footer>Golden Age</footer>
</div>
</body>
</html>