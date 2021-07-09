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
</head>
<body>

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
<a href = "MenuCuentasAdmin.jsp">Volver</a>

</body>
</html>