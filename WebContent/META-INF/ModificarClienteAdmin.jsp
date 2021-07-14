<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method = "post" action = "servletCliente">
<table>

<tr>
     <td><b>Ingrese dni del cliente:</b></td>
     <td><input type="text" name="txtDni" required/></td>
</tr>
<tr>
<td><b>Nuevo nombre:</b></td>
<td>
<input type="text" name="txtNombre" required/><td>
</tr>
<tr>
<td><b>Nuevo apellido:</b></td>
<td>
<input type="text" name="txtApellido" required/><td>
</tr>
<tr>
<td><b>Nueva direccion:</b></td>
<td>
<input type="text" name="txtDireccion" required/><td>
</tr>
<tr>
<td><b>Nueva localidad:</b></td>
<td>
<input type="text" name="txtLocalidad" required/><td>
</tr>
<tr>
<td><b>Nueva provincia:</b></td>
<td>
<input type="text" name="txtProvincia" required/><td>
</tr>
<tr>
<td><b>Nuevo mail:</b></td>
<td>
<input type="text" name="txtMail" required/><td>
</tr>
<tr>
<td><b>Nuevo telefono:</b></td>
<td>
<input type="text" name="txtTelefono" required/><td>
</tr>
<tr>
<td><b>Nuevo telefono fijo:</b></td>
<td>
<input type="text" name="txtTelefonoFijo" required/><td>
</tr>
<tr>
<td>
<b>Nuevo Usuario:</b>
</td>
<td><input type="text" name="txtUsuario" required/><td></td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="btnModificar" value="Modificar"/></td>

</tr>
</table>
<a href="MenuClientesAdmin.jsp">Volver al menú anterior</a>
</form>
</body>
</html>