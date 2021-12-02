<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="Entidad.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Clientes</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
$(document).ready( function () {
    $('#tablaclientes').DataTable();
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
<img alt="golden age" src="C:\Users\IsaAli\eclipse-workspace\TP_IntegradorG6\Imagenes\Golden age.JPEG">
</a>
</div>

<h1>LISTADO DE CLIENTES</h1>

<% 
	List<Cliente> listaclientes = new ArrayList<Cliente>();
	if(request.getAttribute("listaU")!=null)
	{
		listaclientes = (List<Cliente>) request.getAttribute("listaU");
		System.out.println("SE CARGO LA LISTA");
	}

 %>

<%///aca empieza la tabla antes de la paginacion %>
<table id="tablaclientes" class="display" border="1">
	<thead>
		<tr>
		<th>Dni</th>
		<th>CUIL</th>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>Sexo</th>
		<th>Nacionalidad</th>
		<th>Fecha Nac.</th>
		<th>Direccion</th>
		<th>Localidad</th>
		<th>Provincia</th>
		<th>Correo Electronico</th>
		<th>Telefono</th>
		<th>Telefono Fijo</th>
		<th>Usuario</th>
		</tr>
	</thead>
	<tbody>
	<%  
		for(Cliente user : listaclientes) 
		{
	%>
			<tr>  
		 
				<td><%=user.getDni() %> </td>
				<td><%=user.getCuil() %></td>
				<td><%=user.getNombre() %></td>   
				<td><%=user.getApellido() %></td>
				<td><%=user.getSexo() %></td>
				<td><%=user.getNacionalidad() %></td>
				<td><%=user.getNacimiento() %></td>
				<td><%=user.getDireccion() %></td>
				<td><%=user.getLocalidad()%></td>
				<td><%=user.getProvincia() %></td>
				<td><%=user.getEmail() %></td>
				<td><%=user.getTelefono() %></td>
				<td><%=user.getTelefono_fijo() %></td>
				<td><%=user.getUsuario() %></td>
			
			</tr>
	<%  } %>
		
	</tbody>
</table>
<%///aca termina la tabla antes de la paginacion %>
    <a href= "MenuClientesAdmin.jsp">Volver</a>
    <div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<footer>Golden Age</footer>
</div>
</body>