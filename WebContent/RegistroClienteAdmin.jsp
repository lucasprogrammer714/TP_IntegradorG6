<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@page import="Excepciones.FaltaArrobaException" %>
    
    
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RegistrarCliente</title>
<style type="text/css">


div {
border-bottom: 1px solid #efefef;
margin: 10px;
padding-bottom: 20px;
}

.title {
float: left;
width: 100px;
text-align: left;
padding-right: 10px;

}
body {
font-family: arial;
}
h1 {
color: rgb(184, 134, 11);}


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
 
boolean registrado = false;

if (request.getAttribute("RegistroExitoso")!=null)
{
	registrado = Boolean.parseBoolean(request.getParameter("RegistroExitoso").toString());
}

%>






<form method="post" action="servletCliente">
<div>
<label for="DNI" class="title"><b>DNI:</b> </label>
<input type="text" name="txtDni" required/>
</div>
<div>
<label for="Cuil" class="title"><b>CUIL:</b></label>
<input type="text" name="txtCuil" required/>
</div>
<div>
<label for="Nombre" class="title"><b>Nombre:</b></label>
<input type="text" name="txtNombre" required/>
</div>
<div>
<label for="Apellido" class="title"><b>Apellido:</b></label>
<input type="text" name="txtApellido" required/>
</div>
<div>
<label for="Sexo" class="title"><b>Sexo:</b></label>
<select name="ddlSexo">
<option>Masculino</option>
<option>Femenino</option>
</select>
</div>
<div>
<label for="Nacionalidad" class="title"><b>Nacionalidad:</b></label>
<input type="text" name="txtNacionalidad" required/>
</div>
<div>
<label for="FechadeNacimiento" class="title"><b>Fecha de Nacimiento:</b></label>
<input type="text" name="txtFechaNacimiento" required/>
</div>
<div>
<label for="Direccion" class="title"><b>Direccion:</b></label>
<input type="text" name="txtDireccion" required/>
</div>
<div>
<label for="Localidad" class="title"><b>Localidad:</b></label>
<input type="text" name="txtLocalidad" required/>
</div>
<div>
<label for="Provincia" class="title"><b>Provincia:</b></label>
<input type="text" name="txtProvincia" required/>
</div>
<div>
<label for="CorreoElectronico" class="title"><b>Correo Electronico:</b></label>
<input type="text" name="txtCorreo" required/>
</div>
<div>
<label for="TelefonoFijo" class="title"><b>Telefono Fijo:</b></label>
<input type="text" name="txtTelFijo" required/>
</div>
<div>
<label for="TelefonoCelular" class="title"><b>Telefono Celular:</b></label>
<input type="text" name="txtTelCel" required/>
</div><br>

<div>
<label for="Nombre de Usuario" class="title"><b>Nombre de Usuario:</b></label>
<input type="text" name="txtUsuarioCliente" required/>
</div>
<div>
<label for="ContraseñaUsuario" class="title"><b>Contraseña Usuario:</b></label>
<input type="password" name="txtContraseña" required/>
</div>
<div>
<label for="ConfirmarContraseña" class="title"><b>Confirmar Contraseña:</b></label>
<input type="password" name="txtContraseñaConfirmar" required/>
</div>
<div>
<input type="submit" name="btnRegistrarUsuario" value="Registrar Usuario"/>
</div>
  </form>
  
  
 <%  if (registrado == false) {%>
  <h2>El cliente fue registrado exitosamente</h2>
  <% 
  }
 
  %> 
  <a href="MenuClientesAdmin.jsp">Volver al menú anterior</a>
  
  <div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<footer>Golden Age</footer>
</div>


  
  
  

            </body>
                         </html>