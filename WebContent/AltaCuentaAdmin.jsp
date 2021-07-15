<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar cuenta bancaria</title>
<style type="text/css">
body {
font-family: arial;
}


table{
aling-items: center;
justify-content: center;
}

   footer{
   color: rgb(184, 134, 11);
   
   }
   div {

text-align: center;
}



</style>
</head>
<body>
<form method="post" action = "servletCuenta">
<div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<a href="Login.jsp">
<img alt="golden age" src="C:\Users\usuario\Desktop\TP5_AaronMeza\TP_IntegradorG6\Imagenes\Golden age.JPEG">
</a>
</div>
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
    <td><b>Fecha de creación:</b></td>
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

boolean maxCuentas = false;

if (request.getAttribute("NCuentasExcedida")!=null)
{
	maxCuentas = true;
}

%>

<% if (maxCuentas == true) { %>

<h3>El usuario ya posee el maximo de cuentas disponibles</h3>

<% } %>

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
<a href="MenuCuentasAdmin.jsp">Volver al menú</a>
<div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<footer>Golden Age</footer>
</div>

</body>
</html>