<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Entidad.Prestamos" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prestamos avisos</title>

<style  type = "text/css">

body{

font-family: arial;
 background-color: lightblue;

}


</style>

</head>
<body>

<%Prestamos prestamo = new Prestamos(); %>

<% boolean update=false;%>
<%if(request.getAttribute("DatosPrestamo")!=null)
{
prestamo = (Prestamos)request.getAttribute("DatosPrestamo");
} 

if(request.getAttribute("updateprestamo")!=null){
	update=(boolean)request.getAttribute("updateprestamo");
}
%>

<%boolean autorizado=prestamo.isAutorizado(); %>
<%boolean pendiente=prestamo.isPendiente(); %>
<%int idP=prestamo.getId_prestamo(); %>

<% if (prestamo.isPendiente()==true && prestamo.isAutorizado()==false){ %> 
	<b>Su prestamo est� pendiente de autorizaci�n</b>
<%}%>


<%if (prestamo.isAutorizado()==false && prestamo.isPendiente()==false && prestamo.getId_prestamo() != 0){ %> 
<b>Su prestamo no ha sido autorizado. Para m�s informaci�n contacte al banco Golden Age</b><br>
<%}%>
	
	
<%if (prestamo.getId_prestamo()==0){ %> 
<b>A�n no cuenta con un prestamo solicitado</b><br>
<%}%>
	
<%if (update==true){ %> 
<b>Su prestamo fue saldado correctamente</b><br>
<%}%>
<br>
<a href="UsuarioCliente.jsp">Volver</a>

</body>
</html>