<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clientes</title>
</head>
<body>

<%
String user="";
if(request.getAttribute("Usuario")!=null)
user=request.getAttribute("Usuario").toString();
%>

<%
session.setAttribute("User", user);
 %>
 
 VALOR Session: <%= session.getAttribute("User") %>

<h1>bienvenido/a <%=user %> </h1>
<!--  ingresar aqui despues el nombre del administrador -->

seleccione y observe el historial de movimientos de sus <a href="servletCliente?Param=movCuentas">cuentas</a> <br>
realizar <a href="servletCliente?Param=listCuentasUser">tranferencias</a> <br>
pida un <a href="PrestamosCliente.jsp">prestamo</a> ahora!<br>
<a href="PagosPrestamosClientes.jsp">pague sus prestamos</a>pendientes<br>
visualizar <a href="DatosCliente.jsp">mis datos</a><br> <br>
<a href="Login.jsp">cerrar sesion</a>
<!--
<input type="submit" name="btnCuentas" value="Cuentas"/>
<input type="submit" name="btnTransferencias" value="Transferencias"/>
<input type="submit" name="btnCuentas" value="Prestamos"/>
<input type="submit" name="btnInformacionPersonal" value="Mis datos"/>
-->
</body>
</html>