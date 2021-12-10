<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
form {
  /* Centrar el formulario en la página */
  margin: 0 auto;
  width: 400px;
  /* Esquema del formulario */
  padding: 1em;
  border: 1px solid #CCC;
  border-radius: 1em;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REPORTE PRESTAMOS</title>
</head>
<body>

<% float ingresoPrestamo=0;%>
<%float egresoPrestamo=0;%>

<% if(request.getAttribute("egresoPrestamos") !=null){
	egresoPrestamo=Float.parseFloat(request.getAttribute("egresoPrestamos").toString());
}
%>

<form name = "ingresoPrestamos" method= "post" action= "servletReportes">

<h3> INGRESO DE PRESTAMOS POR FECHA</h3>
<table>
<tr>
	<td>FECHA DE INICIO: <input type="date" id="fechainicio" name ="fechainicio"></td>
	<td>FECHA DE FIN: <input type="date" id="fechafin" name ="fechafin"></td>
</tr>
<tr>
	<td><input type="submit" name="btnReportePrestamoIngreso" value="Calcular"></td>
</tr>
<tr>

	<td>Resultado: <%if(ingresoPrestamo==0){%>
		SIN RESULTADO
	<%}else{ %>
	<%=ingresoPrestamo %>
	<%} %>
	
	</td>
</tr>
</table>
</form>


<form name = "egresoPrestamos" method= "post" action= "servletReportes">
<h3>EGRESO DE PRESTAMOS POR FECHA</h3>
<table>
<tr>
	<td>FECHA DE INICIO: <input type="date" id="fechainicio" name ="fechainicio"></td>
	<td>FECHA DE FIN: <input type="date" id="fechafin" name ="fechafin"></td>
</tr>
<tr>
	<td><input type="submit" name="btnReportePrestamoEgreso" value="Calcular"></td>
</tr>
<tr>

	<td>Resultado: <%if(egresoPrestamo==0){%>
		SIN RESULTADO
	<%}else{ %>
	<%=egresoPrestamo %>
	<%} %>
	
	</td>
</tr>
</table>
</form>

</body>
</html>