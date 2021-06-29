<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">


div {
border-bottom: 1px solid #efefef;
margin: 10px;
padding-bottom: 20px;
width: 260px;}

.title {
float: left;
width: 100px;
text-align: left;
padding-right: 10px;

}






</style>

</head>
<body>
<form method="post" action=servletCliente>
<div>
<label for="DNI" class="title"><b>DNI:</b> </label>
<input type="text" name="txtDni" />
</div>
<div>
<label for="Cuil" class="title"><b>CUIL:</b></label>
<input type="text" name="txtCuil" />
</div>
<div>
<label for="Nombre" class="title"><b>Nombre:</b></label>
<input type="text" name="txtNombre"/>
</div>
<div>
<label for="Apellido" class="title"><b>Apellido:</b></label>
<input type="text" name="txtApellido"/>
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
<input type="text" name="txtNacionalidad"/>
</div>
<div>
<label for="FechadeNacimiento" class="title"><b>Fecha de Nacimiento:</b></label>
<input type="text" name="txtFechaNacimiento"/>
</div>
<div>
<label for="Direccion" class="title"><b>Direccion:</b></label>
<input type="text" name="txtDireccion"/>
</div>
<div>
<label for="Localidad" class="title"><b>Localidad:</b></label>
<input type="text" name="txtLocalidad"/>
</div>
<div>
<label for="Provincia" class="title"><b>Provincia:</b></label>
<input type="text" name="txtProvincia"/>
</div>
<div>
<label for="CorreoElectronico" class="title"><b>Correo Electronico:</b></label>
<input type="text" name="txtCorreo"/>
</div>
<div>
<label for="TelefonoFijo" class="title"><b>Telefono Fijo:</b></label>
<input type="text" name="txtTelFijo"/>
</div>
<div>
<label for="TelefonoCelular" class="title"><b>Telefono Celular:</b></label>
<input type="text" name="txtTelCel"/>
</div><br>

<div>
<label for="Nombre de Usuario" class="title"><b>Nombre de Usuario:</b></label>
<input type="text" name="txtUsuarioCliente"/>
</div>
<div>
<label for="ContraseñaUsuario" class="title"><b>Contraseña Usuario:</b></label>
<input type="password" name="txtContraseña"/>
</div>
<div>
<label for="ConfirmarContraseña" class="title"><b>Confirmar Contraseña:</b></label>
<input type="password" name="txtContraseñaConfirmar"/>
</div>
<div>
<input type="submit" name="btnRegistrarUsuario" value="Registrar Usuario"/>
</div>
  </form>
  
  <a href="MenuClientesAdmin.jsp">Volver al menú anterior</a>

            </body>
                         </html>