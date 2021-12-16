<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Cuentas" %>
<%@page import="Entidad.Movimientos" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movimientos</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
$(document).ready( function () {
    $('#tablamovimientos').DataTable();
} );
</script>
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
<h1>Bienvenido/a <%=user %> </h1>

<%
List<Cuentas> listaCuentas = new ArrayList<Cuentas>();
List<Cuentas> lc = new ArrayList<Cuentas>();
if(request.getAttribute("listaCuentasUser")!=null){
   		listaCuentas = (List<Cuentas>) request.getAttribute("listaCuentasUser");
} 
	HttpSession misession= (HttpSession) request.getSession();
	session.setAttribute("listcuentas", listaCuentas);
	lc=(List<Cuentas>)misession.getAttribute("listcuentas");
%>


<form method="post" action = "servletCliente">
Seleccione su cuenta:
<select name="ncuenta" id="ncuenta">
		<%
		   for (Cuentas c : listaCuentas){
		%>
		   		<option> <%=c.getNumero_cuenta() %></option>
					
		 <%} %>
</select>
<%--
String ncuenta=(String)request.getAttribute("ncuenta");
System.out.println("JSP CUENTA: " + ncuenta);
--%>
<%--<a href="servletCliente?Parametro=<%=ncuenta%>">Mostrar Movimientos</a> <br> --%>
<input type="submit" name="btnListarMovimientos" value="Listar Movimientos"/>
</form>

<% 
	

	List<Movimientos> listaMovimientos = new ArrayList<Movimientos>();
	if(request.getAttribute("listaMovimientos")!=null){
		listaMovimientos=(List<Movimientos>) request.getAttribute("listaMovimientos");
	}
%>

<form method="post" action = "">
<h1>Movimientos de cuenta</h1>



<table id="tablamovimientos" class="display" border="1">
		<thead>
		<tr>
			<th>DNI</th>
			<th>Numero de cuenta</th>
			<th>Codigo de movimiento</th>
			<th>Fecha></th>
			<th>Detalle</th>
			<th>Importe</th>
			<th>Tipo de movimiento</th>
		</tr>
		</thead>
		<tbody>
		<%
			for (Movimientos lm : listaMovimientos) {
		%>

		<tr>
			<td><%=lm.getDni_movimiento()%></td>
			<td><%=lm.getNro_cuenta_movimiento()%></td>
			<td><%=lm.getId_movimiento()%></td>
			<td><%=lm.getFecha_movimiento()%></td>
			<td><%=lm.getDetalle()%></td>
			<td><%=lm.getImporte()%></td>
			<td><%=lm.getTipo_movimiento()%></td>
		</tr>
		<%
			}
		%>

	</tbody>
	</table>
	
<a href= "UsuarioCliente.jsp">Volver</a>
</form>

<div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<footer>Golden Age</footer>
</div>


</body>
</html>