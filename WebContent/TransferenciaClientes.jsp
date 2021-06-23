<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>bienvenido/a</h1>
<!--  ingresar aqui despues el nombre del administrador -->

<form method="post" action="ServletCliente">  <!-- aun no cree este servlet pero es un ejemplo de carga -->
	<table>
			<tr>
			<td>CBU a transferir</td>
			<td><input type="text" name="txtCBU"></td>
		</tr>
		<tr>
			<td>tipo de cuenta</td>
			<td><select name="TipoCuenta"> 
					<option>cuenta corriente</option>
					<option>Cuenta ahorro</option>
				</select>  </td>
		</tr>	
		<tr>
			<td>detalle </td>
			<td><input type="text" name="txtDetalle">
		</tr>	
		<tr>
			<td>Importe a transferir</td>
			<td> <input type="text" name="txtImporte"></td>
		</tr>		
		
</table>
		
 <input type="submit" name="btnTransferir" value="Transferir ahora">

</form>

<a href="UsuarioCliente">cancelar transferencia</a>


</body>
</html>