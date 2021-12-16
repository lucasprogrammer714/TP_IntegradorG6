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
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
$(document).ready( function () {
    $('#tablacuentas').DataTable();
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

	<table id="tablacuentas" class="display" border="1">
		<thead>
		<tr>
			<th>DNI</th>
			<th>N. CUENTA</th>
			<th>CBU</th>
			<th>CREACION</th>
			<th>TIPO DE CUENTA</th>
			<th>SALDO</th>
		
		</tr>
		</thead>
		<tbody>
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
		
		</tr>
		<%
			}
		%>
		</tbody>

	</table>

<a href= "MenuCuentasAdmin.jsp">Volver al menú anterior</a>



</body>
</html>