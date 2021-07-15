<%@page import="Entidad.Cuentas" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado cuentas</title>
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
<body><div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<a href="Login.jsp">
<img alt="golden age" src="C:\Users\usuario\Desktop\TP5_AaronMeza\TP_IntegradorG6\Imagenes\Golden age.JPEG">
</a>
</div>

<% 
	
	List<Cuentas> lc = new ArrayList<Cuentas>();

if(request.getAttribute("listaCue")!=null){
   lc = (List<Cuentas>) request.getAttribute("listaCue");
    
}
    
%>

	<table border="1">
		<tr>
			<td><b>DNI</b></td>
			<td><b>N. CUENTA</b></td>
			<td><b>CBU</b></td>
			<td><b>CREACION</b></td>
			<td><b>TIPO DE CUENTA</b></td>
			<td><b>SALDO</b></td>
			<td><b>ESTADO</b></td>
		</tr>

		<%
			for (Cuentas c : lc) {
		%>

		<tr>
			<td><%=c.getDni_cuenta()%></td>
			<td><%=c.getNumero_cuenta()%></td>
			<td><%=c.getCbu()%></td>
			<td><%=c.getCreacion() %></td>
			<td><%=c.getTipo_cuenta()%></td>
			<td><%=c.getSaldo()%></td>
			<td><%=c.getEstado_cuenta()%></td>
		</tr>

		
		<%
			}
		%>


	</table>

<a href= "MenuCuentasAdmin.jsp">Volver</a>

<div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<footer>Golden Age</footer>
</div>

</body>
</html>