<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style type="text/css">
body {
font-family: arial;
background-color:lightbue;}

form{
  margin: 0 auto;
}

h1 {
color: rgb(184, 134, 11);}
input {
    width: 133px;
    }
  
div{
text-align: center;}

   footer{
   color: rgb(184, 134, 11);
   
   }

</style>



</head>
<body>

<%
String user="";
if(request.getAttribute("Usuario")!=null)
user="Los datos ingresados no son válidos. Por favor vuelva a intentarlo";
%>

<form method="post" action = "servletLogin">
<div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<a href="Login.jsp">
<img alt="golden age" src="C:\Users\lucas\OneDrive\Escritorio\Facultad\Lab. IV\TP_IntegradorG6-master\Imagenes\Golden age.JPEG">
<h1>Bienvenido a Banco Golden Age</h1>
</a>
</div>
<div id="Blanco" style="background-color:teal;" class="z">
<h2>Home Banking</h2>
</div>
<div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<img alt="Home" src="C:\Users\lucas\OneDrive\Escritorio\Facultad\Lab. IV\TP_IntegradorG6-master\Imagenes\interna-homebanking.JPG" width="100%" height="200">
</div>
<div id="Blanco2" style="background-color:teal;" class="x"><br>

Usuario:     <input type="text" name="txtUsuario" required/><br><br>
Contraseña: <input type="password" name="txtContraseña" required /><br><br>


<input type="submit" name="btnLogin" value="Iniciar Sesion" ><br>
</div>

</form>
<h1><%=user %></h1>
<div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<footer>Golden Age</footer>
</div>
</body>
</html>