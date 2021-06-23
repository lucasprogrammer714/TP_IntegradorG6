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
<p>solicite aqui su prestamo y aguarde su aprobacion o declinacion</p>
<form method="post" action="ServletCliente">  <!-- aun no cree este servlet pero es un ejemplo de carga -->
	<table>
		<tr>
			<td>monto solicitado</td>
			<td><input type="text" name="txtMonto"></td>
		</tr>
		<tr>
			<td>cantidad de cuotas</td>
			<td><input type="text" name="txtCuotas"></td>
		</tr>
		<tr>
			<td>tipo de cuenta a depositar</td>
			<td><select name="TipoCuenta"> 
					<option>cuenta corriente</option>
					<option>Cuenta ahorro</option>
				</select>  </td>
		</tr>	
	</table>
<input type="submit" name="btnEnviar" value="Solicitar Prestamo">
</form>

</body>
</html>