<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int contarPrestamos=0;
if(request.getAttribute("prestamopendiente")!=null)
{
	contarPrestamos=Integer.parseInt(request.getAttribute("prestamopendiente").toString());

}
%>
<%if (contarPrestamos!=0){ %> 
<b>DEBE SALDAR EL PRESTAMO PEDIDO PARA CONTINUAR CON LA OPERACION</b><br>
<%}%>
</body>
</html>