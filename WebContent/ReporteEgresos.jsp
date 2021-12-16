<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@page import="java.util.ArrayList"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Egresos</title>
<style type = "text/css">

body{
font-family: arial;
 background-color: lightblue;
}
form {
  /* Centrar el formulario en la página */
  margin: 0 auto;
  width: 400px;
  /* Esquema del formulario */
  padding: 1em;
  border: 5px solid #CCC;
  border-radius: 1em;
}
</style>
</head>
<body>

<%float reporte = 0;
float reporteAnual = 0;
float reporteMensual =0;




if(request.getAttribute("reporteFechas")!=null){

reporte = Float.parseFloat(request.getAttribute("reporteFechas").toString());

}
if(request.getAttribute("reporteAnual")!=null){

reporteAnual = Float.parseFloat(request.getAttribute("reporteAnual").toString());

}

if(request.getAttribute("ReporteMes")!=null){

reporteMensual = (Float)request.getAttribute("ReporteMes");

}

%>

<%
String user="";
if(session.getAttribute("usuariolog")!=null)
{
user=session.getAttribute("usuariolog").toString();
}
%>
<h1>Bienvenido/a <%=user %> </h1> 

<form name="reporteFechaEgresos" method = "post" action = "servletReportes">
<table>
<h3>EGRESOS POR FECHA:</h3>
<tr>
         <td>FECHA DE INICIO: </td>
         <td>FECHA DE FIN: </td>
        </tr>
        <tr><td style="width: 270px; "><input type = "text" name = "txtFechaInicio" required></input>
        </td><td><input type = "text" name = "txtFechaFin" required></input></td></tr>
  <tr>
  <td><input type = "submit"  name="btnReporteEgresoFechas" value="Calcular">  </td>
  </tr>
      <tr>   
        <td>Resultado: <%if(reporte == 0) {%>
                    SIN RESULTADOS <%} else{%>
            <%=reporte %><%} %>
            </td>
</tr>
</table>
</form>

<form name="reporteAnualEgresos" method = "post" action = "servletReportes">
<h3>REPORTE  MENSUAL:</h3>
<table>
<tr>
<td>
<select name="Meses">
<option>Seleccionar mes</option>
<option  value=1>Enero</option>
<option  value=2>Febrero</option>
<option  value=3>Marzo</option>
<option  value=4>Abril</option>
<option  value=5>Mayo</option>
<option  value=6>Junio</option>
<option  value=7>Julio</option>
<option  value=8>Agosto</option>
<option  value=9>Septiembre</option>
<option  value=10>Octubre</option>
<option  value=11>Noviembre</option>
<option  value=12>Diciembre</option>
</select>
     </td>
     </tr>
     <tr>
      <td><input type = "submit" value = "Calcular"  name = "btnReporteEgresoMensual" ></td>
 </tr> 
    <tr>
      <td>Resultado:<%if(reporteMensual==0){ %>
      SIN RESULTADO
      <%}else{ %>
      <%=reporteMensual %>
      <%} %>
      </td>
    </tr>
                   </table>
</form>

<form name="reporteEgresoAnual" method = "post" action = "servletReportes">
<table>
<h3>EGRESO ANUAL:</h3>
<tr>
<td><input type = "submit" name = "btnReporteEgresoAnual" value = "Calcular"></input></td>
</tr>
<tr>
                <td> <%if(reporteAnual == 0) {%>
                    SIN RESULTADOS<%} else{%>
            <%=reporteAnual %><%} %></td>
         
</tr>
<tr>

 </tr>
</table>

</form>

<a href="Reportes.jsp">Volver al menú principal</a>
</body>
</html>