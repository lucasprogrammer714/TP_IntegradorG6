<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dar de baja cliente</title>
</head>
<body>
 <form method = "post" action = "servletCliente">
  <table>
        <tr>
           <td><b>Ingrese DNI de cliente:</b></td>
           <td><input type="text" name="txtDniBajaCliente" required /></td>
        </tr>
       <tr>
            <td></td>
            <td><input type="submit" name="btnBajaCliente" value ="Aceptar"/></td>
       </tr>
        
         
  </table>
  
 </form> 
 
 <%
 int baja = 0;
 int existe = 1;
 
 if (request.getAttribute("baja_cliente")!= null)
 
 {
 
 baja = Integer.parseInt(request.getAttribute("baja_cliente").toString());
 
 }
 
 if (request.getAttribute("noExiste")!=null)
 {
	 
	 existe = Integer.parseInt(request.getAttribute("noExiste").toString());
	 
 }
 
 
 %>
 
 <%
 if (baja == 1)
 {
 %>
 
 <h2>El cliente fue dado de baja exitosamente</h2>
 
 
<% } %>


<% if (existe == 0) { %>
  
  <h2>El cliente no existe </h2>
  
  <%}%>
 <a href="MenuClientesAdmin.jsp">Volver al menú</a>
</body>
</html>