<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Entidad.Prestamos" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%Prestamos prestamo = new Prestamos(); %>
	
<%if(request.getAttribute("DatosPrestamo")!=null)
{
prestamo = (Prestamos)request.getAttribute("DatosPrestamo");
} 

%>

<% if (prestamo.isPendiente()==true){ %> 
	<b>Su prestamo está pendiente de autorización</b>
<%}%>


<%if (prestamo.isAutorizado()==false  && prestamo.getId_prestamo() != 0){ %> 
<b>Su prestamo no ha sido autorizado. Para más información contacte al banco Golden Age</b><br>
<%}%>
	
	
<%if (prestamo.getId_prestamo()==0){ %> 
<b>Aún no cuenta con un prestamo solicitado</b><br>
<%}%>
	





</body>
</html>