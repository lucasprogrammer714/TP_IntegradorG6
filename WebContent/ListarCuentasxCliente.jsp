<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.util.ArrayList"%>
    <%@page import="java.util.List"%>
     <%@page import="Entidad.Cuentas"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado cuentas</title>
<style type="text/css">
body {
font-family: arial;
 background-color: lightblue;
}

form {
  /* Centrar el formulario en la página */
  margin: 0 auto;
  width: 400px;
  /* Esquema del formulario */
  padding: 1em;
  border: 1px solid #CCC;
  border-radius: 1em;
}
  
  table
  {
    margin: 0 auto;
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
<form method = "post" action = "servletCuenta">
 <b>INGRESE EL DNI DEL CLIENTE:</b>  <input type="text" name = "txtListarCuentaxDNI" required/><br><br>
 
 <input type ="submit" name = "btnListarCuentaxDni" value = "Mostrar"/> <br> <br>

</form>
<%
int existe = 1;
List<Cuentas> listaCuentas = new ArrayList<Cuentas>();

if (request.getAttribute("listaCuentaxCliente")!=null)
{
	listaCuentas = (List<Cuentas>)request.getAttribute("listaCuentaxCliente");
}

%>

<%

if (request.getAttribute("clienteExiste")!=null)
	
{
	existe = Integer.parseInt(request.getAttribute("clienteExiste").toString());
}

%>

<% if (existe == 0) {%>
<h2>El cliente no se encuentra registrado</h2>
<%} %>

	<table border="1">
		<tr>
			<td><b>DNI</b></td>
			<td><b>NRO. CUENTA</b></td>
			
		</tr>

		<%
			for (Cuentas c : listaCuentas) {
		%>

		<tr>
			<td><%=c.getDni_cuenta()%></td>
			<td><%=c.getNumero_cuenta()%></td>
		
		</tr>

		
		<%
			}
		%>


	</table>

<br><br>
<a href = "MenuCuentasAdmin.jsp">Volver al menú anterior</a>
<div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<footer>Golden Age</footer>
</div>

</body>
</html>