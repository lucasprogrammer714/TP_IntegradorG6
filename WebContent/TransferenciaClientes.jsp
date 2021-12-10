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
<!--  ingresar aqui despues el nombre del administrador -->

<% 
	
	List<Cuentas> listaCuentas = new ArrayList<Cuentas>();
boolean registrado=false;
boolean registradoF=false;

if(request.getAttribute("listaCuentasUser")!=null){
   listaCuentas = (List<Cuentas>) request.getAttribute("listaCuentasUser");
    
}


if (request.getAttribute("registroExitoso")!=null)
{
	registrado = Boolean.parseBoolean(request.getAttribute("registroExitoso").toString());
}

if (request.getAttribute("registroFallido")!=null)
{
	registradoF = Boolean.parseBoolean(request.getAttribute("registroFallido").toString());
}
    
%>


<form method="post" action="servletTransferencia">  <!-- aun no cree este servlet pero es un ejemplo de carga -->

	<table>
			<tr>
			<td><b>CBU a transferir:</b></td>
			<td><input type="text" name="txtCBU" required></td>
		</tr>
		<tr>
			<td><b>CUENTA</b></td>
			<td><b>SALDO</b></td>
		</tr>
		<%for(Cuentas c : listaCuentas){%>
		<tr>
			<td><b><%=c.getNumero_cuenta() %></b></td>
			<td><b><%=c.getSaldo() %></b></td>
			<td><input type="radio" name="cuentassaldo" value="<%=c.getNumero_cuenta()%>" required></td>
		</tr>
		<%} %>
		<tr>
			<td><b>Detalle:</b> </td>
			<td><input type="text" name="txtDetalle" required>
		</tr>	
		<tr>
			<td><b>Importe a transferir:</b></td>
			<td> <input type="text" name="txtImporte" required></td>
		</tr>	
		<tr>
		    <td><b>Fecha: </b></td>
		    <td><input type="text" name = "txtFechaTransferencia" required/></td>
		</tr>	
		
</table><br><br>
		
 <input type="submit" name="btnTransferir" value="Transferir">

</form>

<%

if (registrado == true)
{
%>
<h2>Transferencia exitosa</h2>
<%
}
if(registradoF==true){
	%>
	<h2>No se pudo realizar la transferencia</h2>
	<%
}
%>
<a href="UsuarioCliente.jsp">cancelar transferencia</a>


<div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<footer>Golden Age</footer>
</div>
</body>
</html>