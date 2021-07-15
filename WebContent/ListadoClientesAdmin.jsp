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

<h1>LISTADO DE CLIENTES</h1>

<% 
	List<Cliente> listaclientes = new ArrayList<Cliente>();
	if(request.getAttribute("listaU")!=null)
	{
		listaclientes = (List<Cliente>) request.getAttribute("listaU");
		System.out.println("SE CARGO LA LISTA");
	}

 %>


<table border="1">
    
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
    <div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<footer>Golden Age</footer>
</div>
    
    
</body>