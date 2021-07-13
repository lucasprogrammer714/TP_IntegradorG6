<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Cuentas" %>
<%@page import="Entidad.Movimientos" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movimientos</title>
</head>
<body>

<%
List<Cuentas> listaCuentas = new ArrayList<Cuentas>();
List<Cuentas> lc = new ArrayList<Cuentas>();
if(request.getAttribute("listaCuentasUser")!=null){
   		listaCuentas = (List<Cuentas>) request.getAttribute("listaCuentasUser");
} 
	HttpSession misession= (HttpSession) request.getSession();
	session.setAttribute("listcuentas", listaCuentas);
	lc=(List<Cuentas>)misession.getAttribute("listcuentas");
%>
<form method="post" action = "servletCliente">
Seleccione su cuenta:
<select name="ncuenta" id="ncuenta">
		<%
		   for (Cuentas c : listaCuentas){
		%>
		   		<option> <%=c.getNumero_cuenta() %></option>
					
		 <%} %>
</select>
<%--
String ncuenta=(String)request.getAttribute("ncuenta");
System.out.println("JSP CUENTA: " + ncuenta);
--%>
<%--<a href="servletCliente?Parametro=<%=ncuenta%>">Mostrar Movimientos</a> <br> --%>
<input type="submit" name="btnListarMovimientos" value="Listar Movimientos"/>
</form>

<% 
	

	List<Movimientos> listaMovimientos = new ArrayList<Movimientos>();
	if(request.getAttribute("listaMovimientos")!=null){
		listaMovimientos=(List<Movimientos>) request.getAttribute("listaMovimientos");
	}
%>

<form method="post" action = "">
<h1>Movimientos de cuenta</h1>



<table border="1">
		<tr>
			<td><b>DNI</b></td>
			<td><b>Numero de cuenta</b></td>
			<td><b>Codigo de movimiento</b></td>
			<td><b>Fecha</b></td>
			<td><b>Detalle</b></td>
			<td><b>Importe</b></td>
			<td><b>Tipo de movimiento</b></td>
		</tr>

		<%
			for (Movimientos lm : listaMovimientos) {
		%>

		<tr>
			<td><%=lm.getDni_movimiento()%></td>
			<td><%=lm.getNro_cuenta_movimiento()%></td>
			<td><%=lm.getId_movimiento()%></td>
			<td><%=lm.getFecha_movimiento()%></td>
			<td><%=lm.getDetalle()%></td>
			<td><%=lm.getImporte()%></td>
			<td><%=lm.getTipo_movimiento()%></td>
		</tr>
		<%
			}
		%>


	</table>
<a href= "UsuarioCliente.jsp">Volver</a>
</form>
</body>
</html>