<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar cuenta bancaria</title>
</head>
<body>
<form method="post" action = "servletCuenta">
<table>
  <tr>
      <td> <b>Ingrese DNI del cliente:</b></td>
      <td><input type="text" name="txtDniAltaCuenta" required/></td>
  </tr>
  <tr>
       <td> <b>Numero de cuenta:</b></td>
       <td><input type="text" name="txtNroCuenta" required /></td>
  </tr>
  <tr>
  <td><b>Tipo de cuenta:</b></td>
   <td>
     <select name = "ddlTipoCuenta">
              <option>Caja de ahorro</option>
              <option>Cuenta corriente</option>
  
     </select>
    </td>
  </tr>
  <tr>
    <td><b>Fecha de creaci�n:</b></td>
    <td><input type="text" name="txtFechaCreacionCuenta" required /></td>
   </tr>
   <tr>
     <td><b>CBU:</b></td>
     <td><input type="text" name="txtCBU" required /></td>
   </tr>
   <tr>
      <td><b>Saldo:</b></td>
      <td><input type="text" name="txtSaldo" required /></td>
   </tr>
   <tr>
      <td></td>
      <td><input type="submit" name="btnAgregarCuenta" value="Aceptar"/></td>
   </tr>


</table>

   
</form>

<%

boolean cuentaAgregada = false;

if (request.getAttribute("cuentaAgregada")!=null)
{
	cuentaAgregada = Boolean.parseBoolean(request.getAttribute("cuentaAgregada").toString());
}

%>

<% if (cuentaAgregada == true) { %>

<h2>La cuenta fue agregada exitosamente</h2>

<% } %>
<a href="MenuCuentasAdmin.jsp">Volver al men�</a>

</body>
</html>