<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="Entidad.Cuentas" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Solicitud de prestamos</title>
<style type="text/css">

body {
font-family: arial;
 background-color: lightblue;

} 

form {
  /* Centrar el formulario en la p�gina */
  margin: 0 auto;
  width: 400px;
  /* Esquema del formulario */
  padding: 1em;
  border: 1px solid #CCC;
  border-radius: 1em;
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
String user="";
if(session.getAttribute("usuariolog")!=null)
{
user=session.getAttribute("usuariolog").toString();
}
%>
<h1>Bienvenido/a <%=user %> </h1> 

<!--  ingresar aqui despues el nombre del administrador -->
<p>Solicite aqui su prestamo y aguarde su aprobacion o declinacion</p>
<%

	List<Cuentas> listaCuentas = new ArrayList<Cuentas>();
boolean registrado = false;

if(request.getAttribute("listaCuentasUser")!=null){
   listaCuentas = (List<Cuentas>) request.getAttribute("listaCuentasUser");
    
}

if(request.getAttribute("RegistroExitoso")!=null)
{
registrado = (Boolean)request.getAttribute("RegistroExitoso");

}

 %>
	



<form method="post" action="servletPrestamos">  <!-- aun no cree este servlet pero es un ejemplo de carga -->
	<table>
		<tr>
			<td><b>Monto:</b></td>
			<td><input type="text" name="txtMonto"></td>
		</tr>
		<tr>
			<td><b>Seleccione la cantidad de cuotas:</b></td>
			<td><select name="Cuotas"> 
				
					<option>12</option><option>13</option><option>14</option>
					<option>15</option><option>16</option><option>17</option>
					<option>18</option><option>19</option><option>20</option>
					<option>21</option><option>22</option><option>23</option>
					<option>24</option>
					
					
				</select></td>
		</tr>
		<tr>
			<td><b>Seleccione nro. de cuenta a depositar el prestamo: </b></td>
		
					<td><select name="ddlNroCuenta"> 
			<%
		   for (Cuentas c : listaCuentas){
		%>
					<option> <%=c.getNumero_cuenta() %></option>
					
					<%} %>
				</select> </td>
				
		</tr>	
	
		
	</table>
<input type="submit" name="btnSolicitarPrestamo" value="Solicitar Prestamo">
</form>
<br>
<%if(registrado==true)
{ %>
<h3>Solicitud de prestamo exitosa, aguarde aviso de autorizaci�n en el men� de pago</h3>
<%} %>
<a href="UsuarioCliente.jsp">Volver al men� anterior</a>
</body>
</html>
<div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<footer>Golden Age</footer>
</div>


</body>
</html>