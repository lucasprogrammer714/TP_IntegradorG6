<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>bienvenido/a</h1>
<!--  ingresar aqui despues el nombre del administrador -->
<p>solicite aqui su prestamo y aguarde su aprobacion o declinacion</p>
<form method="post" action="ServletCliente">  <!-- aun no cree este servlet pero es un ejemplo de carga -->
	<table>
		<tr>
			<td> Tipo de prestamo</td>
			<td>TNA</td>
			<td>Cant.Cuotas.Max.Min</td>
		</tr>
		<tr>
			<td> <input type="checkbox" name="prestamo-t" value="gusta">Tradicional 
					</td>
			<td>49%
				</td>
				<td> 3-72</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="prestamo-u" value="gusta">uva
					
				</td>
			<td>5%  </td>
				<td> 12-60</td>
				
		</tr>	
	</table>
<input type="submit" name="btnEnviar" value="Solicitar Prestamo">
</form>
<a href="UsuarioCliente">volver atras</a>
</body>
</html>