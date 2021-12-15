<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.ArrayList"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reporte de Ingresos</title>
</head>
<body>

<%float reporte = 0;
float reporteAnual = 0;
float reporteMensual=0;


if(request.getAttribute("reporteFechas")!=null){

reporte = Float.parseFloat(request.getAttribute("reporteFechas").toString());

}
if(request.getAttribute("reporteAnual")!=null){

reporteAnual = Float.parseFloat(request.getAttribute("reporteAnual").toString());

}

if(request.getAttribute("ReporteMes")!=null){

reporteMensual = Float.parseFloat(request.getAttribute("ReporteMes").toString());

}

%>







<form method = "post" action = "servletReportes">
<table>
<tr><td>Ingresos por fecha:</td></tr>
<tr>
         <td>Fecha Inicio:   <input type = "text" name = "txtFechaInicio"></input></td>
         <td>Fecha Fin: <input type = "text" name = "txtFechaFin"></input></td>
          <td><input type = "submit"  name="btnReporteFechas" value="Aceptar"></td>
</tr>
<tr>   <td>  </td>
            <td> <%if(reporte == 0) {%>
                    Sin resultados <%} else{%>
            <%=reporte %><%} %></td>
            
           
</tr>
</table>


<table>
<tr>
<td style="width: 162px; ">Reporte Mensual:</td>
<td>
<select name="MesesReporte">

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
     <td><%=reporteMensual %></td>
     <td style="width: 601px; "><input type = "submit" value = "Aceptar"  name = "btnReporteIngresoMensual" ></td>
          </tr> 
<tr><tr><td>Ingreso anual:</td>
         <td><input></input></td>
         <td><input type = "submit" name = "btnReporteAnual" value = "Aceptar"></input></td>
</tr>
<tr><td></td>
   <td> <%if(reporte == 0) {%>
                    Sin resultados <%} else{%>
            <%=reporteAnual %><%} %></td>
</tr>

</table>

</form>


</body>
</html>