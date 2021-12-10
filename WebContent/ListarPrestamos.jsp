<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Prestamos" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Prestamos</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
$(document).ready( function () {
    $('#tablaPrestamos').DataTable();
} );
</script>
</head>
<body>

<%List<Prestamos> listaPrestamos = new ArrayList<Prestamos>();



if (request.getAttribute("listaTodosPrestamos")!=null)
{
  listaPrestamos = (List<Prestamos>)request.getAttribute("listaTodosPrestamos");
}

 %>
 
 <table id="tablaPrestamos" class="display" border="1">
		<thead>
			<tr>
			<th>DNI</th>
			<th>Numero de cuenta</th>
			<th>Importe de pago</th>
			<th>Importe pedido</th>
			<th>Estado</th>
			</tr>
		</thead>
		<tbody>
           <%for (Prestamos pr : listaPrestamos){ %>
		<tr>
		<td> <%=pr.getDni_prestamo()%></td>
		<td> <%=pr.getNro_cuenta_p() %></td>
		<td> <%=pr.getImp_debe_pagar() %> </td>
		<td> <%=pr.getImporte_pedido() %> </td> 
		<td> <% if(pr.isPendiente()==true && pr.isAutorizado()==false){
			%>
			Pendiente
			<%
		} if(pr.isPendiente()==false && pr.isAutorizado()==true && pr.getSaldado()==false){
			%>
			Autorizado
			<%
		} if(pr.isPendiente()==false && pr.isAutorizado()==true && pr.getSaldado()==true){
			%>
			Saldado
		<%
		} if(pr.isPendiente()==false && pr.isAutorizado()==false){
			%>
			Rechazado
			<%
		}
		%>
		</td>
		</tr>
		<% } %>
	</tbody>
	</table>


  
   <div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<footer>Golden Age</footer>
</div>
   <a href = "MenuPrestamosAdmin.jsp">Volver
</body>
</html>