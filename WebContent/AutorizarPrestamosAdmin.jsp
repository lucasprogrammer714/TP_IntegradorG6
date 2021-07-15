<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Autorizacion de Prestamos</title>
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

   <table>
           <tr>
                 <td><b>DNI del Cliente:</b></td>
                 <td><input type="text" name="txtDniCliente"   required/></td>
           
           </tr>
           <tr><td><b>Numero de cuenta a depositar:</b></td>
                <td><input type="text"  name = "txtNroCuentaPrestamo" required /></td>           
           
           </tr>
           <tr>
           <td><b>Fecha:</b></td>
                 <td><input type="text" name="txtFechaPrestamo" required/></td>
           
           </tr>
          <tr>
            <td> <b>Intereses (según tipo de prestamo):</b></td>
             <td> Tradicional<input type ="radio" name = "rdbTipoPrestamo" value="Tradicional" /> 
             UVA<input type ="radio" name="rdbTipoPrestamo" value = "UVA"/>
              </td>
          
          </tr>
          <tr>
           <td><b>Importe de pago:</b></td>
                 <td><input type="text" name="txtImportePagoPrestamo" required/></td>
           
           </tr>
           <tr>
           <td><b>Importe del prestamo:</b></td>
                 <td><input type="text" name="txtImportePrestamo" required/></td>
           
           </tr>
           <tr>
           <td><b>Plazo de pago:</b></td>
                 <td><input type="text" name="txtUsuarioPrestamo" required/></td>
           
           </tr>
           <tr>
           <td><b>Monto a pagar por mes:</b></td>
                 <td><input type="text" name="txtUsuarioPrestamo" required/></td>
           
           </tr>
           <tr>
           <td><b>Cuotas:</b></td>
                 <td><input type="text" name="txtCuotasPrestamo" required/></td>
           
           </tr>
           <tr>
           <td></td>
           <td>
          
                 <input type="submit" name="btnAutorizarPrestamo" value="Aceptar"/>
           
           </td>
           
           </tr>


   </table>
   <div id="negro" style="background-color: black;" class="Bienvenida" lign="right">
<footer>Golden Age</footer>
</div>
   
</body>
</html>