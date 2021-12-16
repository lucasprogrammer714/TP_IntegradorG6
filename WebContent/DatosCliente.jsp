<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Entidad.Cliente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DatosCliente</title>
<style type="text/css">
body{font-family: arial;
 background-color: lightblue;
}
  
div{
text-align: center;}

   footer{
   color: rgb(184, 134, 11);
   
   }

</style>
</head>

 <!-- ingresar aqui el usuario conectado -->
<body>

<div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<a href="Login.jsp">
<img alt="golden age" src="C:\Users\usuario\Desktop\TP5_AaronMeza\TP_IntegradorG6\Imagenes\Golden age.JPEG">
</a>
</div>

<%
String user="";
Cliente usuario=new Cliente();
if(session.getAttribute("usuariolog")!=null)
{
user=session.getAttribute("usuariolog").toString();
}
%>
<%usuario=(Cliente)session.getAttribute("datosusuario");%>
<h1>Bienvenido/a <%=user %> </h1>

<table class="table" border="1">
  <thead>
    <tr>
      <th >Nombre</th>
      <th >Apellido</th>
      <th >Fecha de Nacimiento</th>
      <th >DNI</th>
      <th >CUIL</th>
      <th >Provincia</th>
      <th >Localidad</th>
      <th >Direccion</th>
      <th>Email</th>
      <th >Telefono</th>
      <th>Telefono Fijo</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><%=usuario.getNombre().toString()%></td>
      <td><%=usuario.getApellido().toString() %></td>
      <td><%=usuario.getNacimiento().toString() %></td>
      <td><%=usuario.getDni().toString() %></td>
      <td><%=usuario.getCuil().toString() %></td>
      <td><%=usuario.getProvincia().toString() %></td>
      <td> <%=usuario.getLocalidad().toString() %></td>
      <td><%=usuario.getDireccion().toString() %></td>
      <td><%=usuario.getEmail().toString() %></td>
      <td><%=usuario.getTelefono().toString() %></td>
      <td><%=usuario.getTelefono_fijo().toString() %></td>
    </tr>
  </tbody>
</table><br>
<a href="UsuarioCliente.jsp">Volver al menú anterior</a>

</body>
</html>