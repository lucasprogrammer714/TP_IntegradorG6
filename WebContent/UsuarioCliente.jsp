<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clientes</title>
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

<div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<a href="Login.jsp">
<img alt="golden age" src="C:\Users\usuario\Desktop\TP5_AaronMeza\TP_IntegradorG6\Imagenes\Golden age.JPEG">
</a>
</div>
<%
String user="";
if(session.getAttribute("usuariolog")!=null)
{
user=session.getAttribute("usuariolog").toString();
}
%>
<h1>bienvenido/a <%=user %> </h1>
<!--  ingresar aqui despues el nombre del administrador   session.setAttribute("User", user) %> -->

seleccione y observe el historial de movimientos de sus <a href="servletCliente?Param=movCuentas">cuentas</a> <br>
realizar <a href="servletCliente?Param=listCuentasUser">tranferencias</a> <br>
pida un <a href="servletCliente?Param=solicitarPrestamo">prestamo</a> ahora!<br>
<a href="PagosPrestamosClientes.jsp">pague sus prestamos</a>pendientes<br>
visualizar <a href="servletCliente?Param=mostrarDatos">mis datos</a><br> <br>
<a href="Login.jsp">cerrar sesion</a>
<!--
<input type="submit" name="btnCuentas" value="Cuentas"/>
<input type="submit" name="btnTransferencias" value="Transferencias"/>
<input type="submit" name="btnCuentas" value="Prestamos"/>
<input type="submit" name="btnInformacionPersonal" value="Mis datos"/>
-->
<div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<footer>Golden Age</footer>
</div>
</body>
</html>