<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menú administrador</title>
<style type="text/css">
body {
font-family: arial;
 background-color: lightblue;
} 

a {
  outline: none;
  text-decoration: none;
  display: inline-block;
  width: 25%;
  margin-right: 0.625%;
  text-align: left;
  line-height: 3;
  color: black;
}
 a.back
 {
 margin: 20px;
 }

a:link, a:visited {
  background-color: #f44336;
  color: white;
  padding: 14px 25px;
  text-align: left;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: red;
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
if(session.getAttribute("adminlog")!=null)
user=session.getAttribute("adminlog").toString();
%>

<h1> Bienvenido/a <%=user %></h1> <br>


<a href= "CambioContraseñaAdmin.jsp">Cambiar Contraseña Cliente</a><br>
<a href="RegistroClienteAdmin.jsp">Registrar Cliente</a><br>
<a href="BajaClienteAdmin.jsp">Borrar Cliente</a><br>
<a href="servletCliente?Param=list">Listar de clientes</a><br>
<% 
///<a href="BuscarFiltrarClientesAdmin.jsp" hidden>Listar de clientes por busqueda</a><br><br>
%>
<a href="UsuarioAdmin.jsp" class = "back">Volver al menu anterior</a>
<div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<footer>Golden Age</footer>
</div>


</body>
</html>