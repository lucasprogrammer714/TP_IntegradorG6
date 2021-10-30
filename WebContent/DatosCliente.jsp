<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Entidad.Cliente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DatosCliente</title>
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
<h1>bienvenido/a <%=user %> </h1>

<%usuario=(Cliente)session.getAttribute("datosusuario");%>
Nombre: <%=usuario.getNombre().toString() %><br/>
Apellido: <%=usuario.getApellido().toString() %><br/>
Fecha de Nacimiento: <%=usuario.getNacimiento().toString() %><br/>
DNI: <%=usuario.getDni().toString() %><br>
CUIL: <%=usuario.getCuil().toString() %><br>
Provincia: <%=usuario.getProvincia().toString() %> <br>
Localidad: <%=usuario.getLocalidad().toString() %><br>
Direccion: <%=usuario.getDireccion().toString() %><br>
Email: <%=usuario.getEmail().toString() %><br>
Telefono: <%=usuario.getTelefono().toString() %><br>
Telefono Fijo: <%=usuario.getTelefono_fijo().toString() %><br>

<a href="UsuarioCliente.jsp">Volver</a>
<div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<footer>Golden Age</footer>
</div>

</body>
</html>