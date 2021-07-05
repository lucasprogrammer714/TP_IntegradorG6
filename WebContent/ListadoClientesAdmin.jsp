<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="Entidad.Cliente"%>
<%@page import="java.util.ArrayList"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Clientes</title>
<h1> LISTADO DE CLIENTES</h1>

<% 
	ArrayList<Cliente> listaclientes = null;
	if(request.getAttribute("listaU")!=null)
	{
		listaclientes = (ArrayList<Cliente>) request.getAttribute("listaU");
	}

 %>


<table border="1">
    
        <tr>
		<th> <b>Dni</b></th>
		<th> <b>CUIL</b></th>
		<th> <b>Nombre</b></th>
		<th> <b>Apellido</b></th>
		<th> <b>Sexo</b></th>
		<th> <b>Nacionalidad</b></th>
		<th> <b>Fecha Nac.</b></th>
		<th> <b>Direccion</b></th>
		<th> <b>Localidad</b></th>
		<th> <b>Provincia</b></th>
		<th> <b>Correo Electronico</b></th>
		<th> <b>Telefonos</b></th>
		<th> <b>Usuario</b></th>
		<th> <b>Contraseña</b></th>
		<th> <b>Estado</b></th>
            <th></th>
        </tr>

 
       <%  if(listaclientes!=null)
		for(Cliente user : listaclientes) 
		{
	%>
		<tr>  
		<form name="formulario" action="servletCliente?DNI=<%=user.getDni()%>" method="get">
				<td><%=user.getDni() %>   </td> <input type="hidden" name="DNI" value="<%=user.getDni()%>"> </td> 
				<td><%=user.getCuil() %></td>
				<td><%=user.getNombre() %></td>   
				<td><%=user.getApellido() %></td>
				<td><%=user.getSexo() %></td>
				<td><%=user.getNacionalidad() %></td>
				<td><%=user.getNacimiento() %></td>
				<td><%=user.getDireccion() %></td>
				<td><%=user.getLocalidad()%></td>
				<td><%=user.getProvincia() %></td>
				<td><%=user.getLocalidad() %></td>
			
				<td><%=user.getTelefono() %></td>
				<td><%=user.getTelefono_fijo() %></td>
				<td><%=user.getUsuario() %></td>
				<td><%=user.getContraseña() %></td>
				<td><%=user.getEstado() %></td>
				
				
			
		</tr>
	<%  } %>
    </tbody>
</table>