<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Prestamos" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Autorizacion de Prestamos</title>
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

List<Prestamos> listaPrestamos = new ArrayList<Prestamos>();



if (request.getAttribute("listaPrestamos")!=null)
{
  listaPrestamos = (List<Prestamos>)request.getAttribute("listaPrestamos");

}

 %>



<h2>PRESTAMOS</h2>


<table border="1">
		<tr>
			<td><b>DNI</b></td>
			<td><b>Numero de cuenta</b></td>
			<td><b>ID</b></td>
			<td><b>Importe de pago</b></td>
			<td><b>Importe pedido</b></td>
		</tr>
           <%for (Prestamos pr : listaPrestamos){ %>
		<tr>
		<form action="servletPrestamos" method = "post" >
		<td> <%=pr.getDni_prestamo()%> <input type="hidden" name= "dniPrestamo" value= "<%=pr.getDni_prestamo()%>"/> </td>
		<td> <%=pr.getNro_cuenta_p() %> <input type="hidden" name= "NroCuentaPrestamo" value= "<%=pr.getNro_cuenta_p()%>"/>  </td>
		<td> <%=pr.getId_prestamo() %></td>
		<td> <%=pr.getImp_debe_pagar() %> </td>
		<td> <%=pr.getImporte_pedido() %> </td> <input type="hidden" name= "Importe" value= "<%=pr.getImporte_pedido()%>"/>
		<td> <input  type="submit" name = "btnAutorizar" value = "Autorizar"> </td>
		</form>
		</tr>
		<% } %>
	</table>


  
   <div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<footer>Golden Age</footer>
</div>
   <a href = "MenuPrestamosAdmin.jsp">Volve
</body>
</html>