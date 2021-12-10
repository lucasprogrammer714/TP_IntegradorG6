<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidad.Cuentas" %>
<%@page import="Entidad.Prestamos" %>
<%@page import="Entidad.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagos de prestamos.</title>
<style type="text/css">
body {
font-family: arial;
}

  
div{
text-align: center;}

   footer{
   color: rgb(184, 134, 11);
   
   }

</style>
</head>
<body>
<div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<a href="Login.jsp">
<img alt="golden age" src="C:\Users\usuario\Desktop\TP5_AaronMeza\TP_IntegradorG6\Imagenes\Golden age.JPEG">
</a>
</div>

<%
Prestamos prestamo = new Prestamos();

if(request.getAttribute("DatosPrestamo")!=null)
{
prestamo = (Prestamos)request.getAttribute("DatosPrestamo");
} 
%>

<% 	List<Cuentas> listaCuentas = new ArrayList<Cuentas>();

	ArrayList<Integer> listaCuotas = new ArrayList<Integer>();
	
boolean registrado = false;

if(request.getAttribute("listaCuentasUser")!=null){
   listaCuentas = (List<Cuentas>) request.getAttribute("listaCuentasUser");
    
}

/// LLena la lista con el getAttribute si no es null***********************************************************************
if(request.getAttribute("arrayCuotas")!=null){
	   listaCuotas = (ArrayList<Integer>) request.getAttribute("arrayCuotas");
	   //System.out.println("EL ARRAYLIST NO ESTA VACIO");
}

boolean pagoExitoso = false;
if(request.getAttribute("PagoExitoso")!=null){
  pagoExitoso = (Boolean)request.getAttribute("PagoExitoso");
    
}

boolean pagoNoExitoso=false;
if(request.getAttribute("pagoNoExitoso")!=null){
	pagoNoExitoso=(Boolean)request.getAttribute("pagoNoExitoso");
}


 %>
 
 <form method="post" action = "servletPrestamos">
 <b>Seleccione la cuota que desea pagar: </b><br>

 <%for(int x=1;x<=listaCuotas.size();x++){ 
if(listaCuotas.get(x-1)==1){ %>
 Cuota  <%=x %>  : <input  type ="radio" name= "rdbMontoCuota" value="<%=x %>" required  disabled> Monto a pagar:  <b><%=prestamo.getMonto_mensual()%></b> <br><br>
 <%}else{ %>


 Cuota  <%=x %>  : <input  type ="radio" name= "rdbMontoCuota" value="<%=x %>" required  > Monto a pagar:  <b><%=prestamo.getMonto_mensual()%></b> <br><br>
<%} 
}%>



Seleccione la cuenta con la que desea pagar su cuota: 
		<table border="1">
		<tr>
			<td><b>CUENTA</b></td>
			<td><b>SALDO</b></td>
		</tr>
		<%for(Cuentas c : listaCuentas){%>
		<tr>
			<td><b><%=c.getNumero_cuenta() %></b></td>
			<td><b><%=c.getSaldo() %></b></td>
			<td><input type="radio" name="cuentassaldo" value="<%=c.getNumero_cuenta()%>" required></td>
		</tr>
		<%} %>
		</table>
  <input type="submit" name="btnPagarCuotaPrestamo" value="Pagar"/>
  </form>
  <br><br>
  <%if (pagoExitoso == true){ %>

  El pago de cuota fue exitoso
  
<%} 

if(pagoNoExitoso==true){%>
	no se pudo realizar el pago de cuota
	<% 
}
%>
<br><br>
    <a href= "UsuarioCliente.jsp">Volver</a>
  <div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<footer>Golden Age</footer>
</div>
  
</body>
</html>