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

<% float gananciaAnual=0;%>
<%float gananciaPrestamo=0;%>

<% if(request.getAttribute("gananciaPrestamos") !=null){
	gananciaPrestamo=Float.parseFloat(request.getAttribute("gananciaPrestamos").toString());
}

if(request.getAttribute("gananciaAnual")!=null){
	gananciaAnual=Float.parseFloat(request.getAttribute("gananciaAnual").toString());
}
%>

<form name = "gananciaPrestamosAnual" method= "post" action= "servletReportes">

<h3> GANANCIA ANUAL DE PRESTAMOS</h3>
<table>
<tr>
	<td>GANANCIA ANUAL:</td>
</tr>
<tr>
	<td><input type="submit" name="btngananciaPrestamoAnual" value="Calcular"></td>
</tr>
<tr>

	<td>Resultado: <%if(gananciaAnual==0){%>
		SIN RESULTADO
	<%}else{ %>
	<%=gananciaAnual %>
	<%} %>
	
	</td>
</tr>
</table>
</form>


<form name = "gananciaPrestamos" method= "post" action= "servletReportes">
<h3>GANANCIA DE PRESTAMOS POR FECHA</h3>
<table>
<tr>
	<td>FECHA DE INICIO: <input type="date" id="fechainicio" name ="fechainicio" required></td>
	<td>FECHA DE FIN: <input type="date" id="fechafin" name ="fechafin" required></td>
</tr>
<tr>
	<td><input type="submit" name="btnGananciaPrestamo" value="Calcular"></td>
</tr>
<tr>

	<td>Resultado: <%if(gananciaPrestamo==0){%>
		SIN RESULTADO
	<%}else{ %>
	<%=gananciaPrestamo %>
	<%} %>
	
	</td>
</tr>
</table>
</form>

</body>
</html>