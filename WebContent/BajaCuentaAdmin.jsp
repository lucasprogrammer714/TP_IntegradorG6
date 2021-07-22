<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Baja de cuenta bancaria</title>
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

<form  method = "post" action = "servletCuenta">

<div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<a href="Login.jsp">
<img alt="golden age" src="C:\Users\usuario\Desktop\TP5_AaronMeza\TP_IntegradorG6\Imagenes\Golden age.JPEG">
</a>
</div>

<table>
   <tr>
        <td><b>Ingrese el numero de cuenta:</b></td>
        <td><input type="text" name="txtNroCuentaEliminar" required/></td>
   </tr>
   <tr>
        <td></td>
        <td><input type="submit" name="btnBajaCuenta" value="Aceptar"></td>
   </tr>

</table>
</form>


<%

int baja = 0;
int existe = 1;

if (request.getAttribute("noExiste")!=null)
	 {
	     existe = Integer.parseInt((request.getAttribute("noExiste").toString()));        
	 }

if (request.getAttribute("baja_cuenta")!=null)
{
	baja = Integer.parseInt(request.getAttribute("baja_cuenta").toString());
}

%>

<% if (existe == 0){ %>
 
<h1>La cuenta no se encuentra registrada</h1>
<%} %>

<% if (baja == 1){ %>
 
<h1>La cuenta fue dada de baja exitosamente</h1>
<%} %>

<a href="MenuCuentasAdmin.jsp">Volver al menú</a>
<div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<footer>Golden Age</footer>
</div>
<a href = "MenuCuentasAdmin.jsp">Volve
</body>
</html>