<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar cuenta bancaria</title>
</head>
<body>
<table>
  <tr>
      <td> <b>Ingrese nombre de usuario del cliente:</b></td>
      <td><input type="text" name="txtUsuarioAltaCuenta"/></td>
  </tr>
  <tr>
       <td> <b>Numero de cuenta:</b></td>
       <td><input type="text" name="txtNroCuenta"/></td>
  </tr>
  <tr>
  <td><b>Tipo de cuenta:</b></td>
   <td>
     <select>
              <option>Caja de ahorro</option>
              <option>Cuenta corriente</option>
  
     </select>
    </td>
  </tr>
  <tr>
    <td><b>Fecha de creación:</b></td>
    <td><input type="text" name="txtFechaCreacionCuenta"/></td>
   </tr>
   <tr>
     <td><b>CBU:</b></td>
     <td><input type="text" name="txtCBU"/></td>
   </tr>
   <tr>
      <td><b>Saldo:</b></td>
      <td><input type="text" name="txtSaldo"/></td>
   </tr>
   <tr>
      <td></td>
      <td><input type="submit" name="btnAgregarCuenta" value="Aceptar"/></td>
   </tr>


</table>

   <a href="MenuCuentasAdmin.jsp">Volver al menú</a>
</body>
</html>