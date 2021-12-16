<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aviso prestamo pendiente</title>

<style  type = "text/css">

body{
font-family: arial;
 background-color: lightblue;
}


</style>

</head>
<body>
<%
int contarPrestamos=0;
if(request.getAttribute("ESTADOPRESTAMO")!=null)
{
	contarPrestamos=Integer.parseInt(request.getAttribute("ESTADOPRESTAMO").toString());

}
%>
<%if (contarPrestamos==1){ %> 
<b>TIENE UN PRESTAMO PENDIENTE PARA AUTORIZACION</b><br>
<%}%>
<%if (contarPrestamos==2){ %> 
<b>TIENE UN PRESTAMO PENDIENTE SIN SALDAR</b><br>
<%}%>
</body>
</html>