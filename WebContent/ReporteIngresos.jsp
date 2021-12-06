<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reporte de Ingresos</title>
</head>
<body>

<%float reporte = 0;
if(request.getAttribute("reporteFechas")!=null){

reporte = Float.parseFloat(request.getAttribute("reporteFechas").toString());

}


 %>

<form method = "post" action = "servletReportes">
<table>
<tr><td>Ingresos por fecha:</td></tr>
<tr>
         <td>Fecha Inicio:   <input type = "text" name = "txtFechaInicio"></input></td>
         <td>Fecha Fin: <input type = "text" name = "txtFechaFin"></input></td>
          <td><input type = "submit"  name="btnReporte" value="Aceptar"></td>
</tr>
<tr>   <td>  </td>
            <td> <%if(reporte == 0) {%>
                    Sin resultados <%} else{%>
            <%=reporte %><%} %></td>
            
           
</tr>


       
</table>

<table>
<tr><tr><td>Ingreso anual:</td>
         <td><input></input></td>
         <td><input type = "submit" name = "btnReporteAnual" value = "Aceptar"></input></td>
</tr>
</table>



</form>


</body>
</html>