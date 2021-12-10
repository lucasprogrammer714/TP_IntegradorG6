<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@page import="java.util.ArrayList"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Egresos</title>
</head>
<body>

<%float reporte = 0;
float reporteAnual = 0;
ArrayList<Float>reporteMensual = new ArrayList<Float>();


if(request.getAttribute("reporteFechas")!=null){

reporte = Float.parseFloat(request.getAttribute("reporteFechas").toString());

}
if(request.getAttribute("reporteAnual")!=null){

reporteAnual = Float.parseFloat(request.getAttribute("reporteAnual").toString());

}

if(request.getAttribute("reporteMensual")!=null){

reporteMensual = (ArrayList<Float>)request.getAttribute("reporteMensual");

}

%>





<form method = "post" action = "servletReportes">
<table>
<tr><td>Egresos por fecha:</td></tr>
<tr>
         <td>Fecha Inicio:   <input type = "text" name = "txtFechaInicio"></input></td>
         <td>Fecha Fin: <input type = "text" name = "txtFechaFin"></input></td>
          <td><input type = "submit"  name="btnReporteEgresoFechas" value="Aceptar"></td>
</tr>
<tr>   <td>  </td>
            <td> <%if(reporte == 0) {%>
                    Sin resultados <%} else{%>
            <%=reporte %><%} %></td>
    
</tr>
</table>


<table>
<tr><tr><td>Egreso anual:</td>
         <td><input></input></td>
         <td><input type = "submit" name = "btnReporteEgresoAnual" value = "Aceptar"></input></td>
</tr>
<tr><td></td>
         <td> <%if(reporteAnual == 0) {%>
                    Sin resultados <%} else{%>
            <%=reporteAnual %><%} %></td><br>
            

        
      
</tr>
</table>

</form>

<%for(	int i =0;i<reporteMensual.size();i++){

%>
<%=reporteMensual.get(i) %>
<% }%>

</body>
</html>