<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Entidad.Cliente"%>
	<%@page import="java.util.ArrayList"%>
	<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar/Filtrar Clientes</title>
</head>
<body>
<form method="post" action="servletCliente">
<input type="text" name="txtBusqueda" required/>
<input type="submit" name="btnBuscar" value="Buscar" ><br>
</form>
<form method="post" action="servletCliente">
Filtrar clientes por fecha de nacimiento: DESDE <input type="date" name="fechainicio" required/> HASTA <input type="date" name="fechafin" required/>
<input type="submit" name="btnBuscarPorFecha" value="Buscar" ><br>
</form>

<h1>LISTADO DE CLIENTES</h1>

<% 
	List<Cliente> listaclientes = new ArrayList<Cliente>();
	if(request.getAttribute("listaU")!=null)
	{
		listaclientes = (List<Cliente>) request.getAttribute("listaU");
		System.out.println("SE CARGO LA LISTA");
	}

 %>


<table border="1" datapagesize="10">
    
        <tr>
		<td> <b>Dni</b></td>
		<td> <b>CUIL</b></td>
		<td> <b>Nombre</b></td>
		<td> <b>Apellido</b></td>
		<td> <b>Sexo</b></td>
		<td> <b>Nacionalidad</b></td>
		<td> <b>Fecha Nac.</b></td>
		<td> <b>Direccion</b></td>
		<td> <b>Localidad</b></td>
		<td> <b>Provincia</b></td>
		<td> <b>Correo Electronico</b></td>
		<td> <b>Telefono</b></td>
		<td> <b>Telefono Fijo</b></td>
		<td> <b>Usuario</b></td>
		<td> <b>Contraseña</b></td>
		<td> <b>Administrador</b></td>
		<td> <b>Estado</b></td>
        </tr>

 
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
				<td><%=user.getContraseña() %></td>
				<td><%=user.getAdministrador() %></td>
				<td><%=user.getEstado() %></td>
		</tr>
	<%  } %>
    </table>
    <a href= "MenuClientesAdmin.jsp">Volver</a>
</body>
</html>