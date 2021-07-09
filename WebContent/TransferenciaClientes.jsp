<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="Entidad.Cuentas" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>bienvenido/a</h1>
<!--  ingresar aqui despues el nombre del administrador -->

<% 
	
	List<Cuentas> listaCuentas = new ArrayList<Cuentas>();

if(request.getAttribute("listaCuentasUser")!=null){
   listaCuentas = (List<Cuentas>) request.getAttribute("listaCuentasUser");
    
}
    
%>


<form method="post" action="ServletCliente">  <!-- aun no cree este servlet pero es un ejemplo de carga -->
	<table>
			<tr>
			<td><b>CBU a transferir:</b></td>
			<td><input type="text" name="txtCBU"></td>
		</tr>
		<tr>
		
		
			<td><b>Nro. de  Cuenta:</b></td>
			
			<td><select name="NroCuenta"> 
			<%
		   for (Cuentas c : listaCuentas){
		%>
					<option> <%=c.getNumero_cuenta() %></option>
					
					<%} %>
				</select> </td>
		</tr>	
		<tr>
			<td><b>Detalle:</b> </td>
			<td><input type="text" name="txtDetalle">
		</tr>	
		<tr>
			<td><b>Importe a transferir:</b></td>
			<td> <input type="text" name="txtImporte"></td>
		</tr>		
		
</table><br><br>
		
 <input type="submit" name="btnTransferir" value="Transferir">

</form>

<a href="UsuarioCliente">cancelar transferencia</a>


</body>
</html>