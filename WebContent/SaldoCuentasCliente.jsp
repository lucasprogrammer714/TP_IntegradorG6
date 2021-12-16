
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Cuentas" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saldo Cuentas</title>
<style type="text/css">
body {
font-family: arial;
 background-color: lightblue;
} 

  
div{
text-align: center;}

   footer{
   color: rgb(184, 134, 11);
   
   }

</style>

</head>
<body>
<%
String user="";
if(session.getAttribute("usuariolog")!=null)
{
user=session.getAttribute("usuariolog").toString();
}
%>
<h1>Bienvenido/a <%=user %> </h1>
<% 	
List<Cuentas> listaCuentas = new ArrayList<Cuentas>();
%>
<% 
if(request.getAttribute("listaCuentasUserSaldo")!=null){
   listaCuentas = (List<Cuentas>) request.getAttribute("listaCuentasUserSaldo");
    
}
%>



<table border="1">
		<tr>
			<td><b>CUENTA</b></td>
			<td><b>SALDO</b></td>
		</tr>
		<%for(Cuentas c : listaCuentas){%>
		<tr>
			<td><b><%=c.getNumero_cuenta() %></b></td>
			<td><b><%=c.getSaldo() %></b></td>
		</tr>
		<%} %>
</table>
<br>
<a href= "UsuarioCliente.jsp">Volver al menú principal</a>
</body>
</html>