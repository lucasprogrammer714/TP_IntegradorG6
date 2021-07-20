package Presentacion.Controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Cuentas;
import Entidad.Movimientos;
import Entidad.Prestamos;
import Negocio.ClienteNeg;
import Negocio.CuentaNeg;
import Negocio.MovimientosNeg;
import Negocio.PrestamosNeg;
import NegocioImpl.ClienteNegImpl;
import NegocioImpl.CuentaNegImpl;
import NegocioImpl.MovimientosNegImpl;
import NegocioImpl.PrestamosNegImpl;

/**
 * Servlet implementation class servletPrestamos
 */
@WebServlet("/servletPrestamos")
public class servletPrestamos extends HttpServlet {
	CuentaNeg cuentaNeg = new CuentaNegImpl();
	//Cuentas cuenta = new Cuentas();
	
	PrestamosNeg prestamoN = new PrestamosNegImpl();
	

	
	ClienteNeg clienteNeg = new ClienteNegImpl();
	MovimientosNeg movimientoNeg = new MovimientosNegImpl();
	
	
	

    public servletPrestamos() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("btnSolicitarPrestamo")!=null)
		{
			Prestamos prestamos = new Prestamos();
			Boolean registro = false;
			String user_dni;
			float interes=(float) 1.54;
			float importe_a_pagar = Float.parseFloat(request.getParameter("txtMonto").toString()) * interes;
			System.out.println("A PAGAR: "  + importe_a_pagar);
			int cuotas = Integer.parseInt(request.getParameter("Cuotas").toString());
			System.out.println("cuotas: " + cuotas);
			
			float monto_mensual = importe_a_pagar/cuotas;
			System.out.println("monto mes: " + monto_mensual);
			
			
			
			String user = request.getSession().getAttribute("User").toString();
			user_dni = clienteNeg.Dni_de_Usuario(user).toString();
			
			
			ArrayList <Cuentas> list = cuentaNeg.ListarCuentaxCliente(user_dni);			
			request.setAttribute("listaCuentasUser", list);
			
			prestamos.setDni_prestamo(user_dni);
			prestamos.setNro_cuenta_p(Integer.parseInt(request.getParameter("ddlNroCuenta").toString()));  
			prestamos.setFecha_p(LocalDate.now());
			prestamos.setImporte_pedido(Float.parseFloat(request.getParameter("txtMonto").toString()));//es el importe que solicita el cliente
			prestamos.setCuotas(cuotas);
			prestamos.setPlazo("12");
			prestamos.setImp_debe_pagar(importe_a_pagar); // segun el importe pedido se le multiplica un interes del 54% tomando de ejemplo un banco
			prestamos.setMonto_mensual(monto_mensual); // calcula lo que se calculo en el importe que se debe pagar dividido las cuotas solicitadas esto daria el importe a pagar por mes          
			prestamos.setPendiente(true);
			prestamos.setAutorizado(false);
			
			registro = prestamoN.insertar(prestamos);
			
			request.setAttribute("RegistroExitoso", registro);
			//request.setAttribute("listaMovimientos", list);	
			request.setAttribute("listaCuentasUser", cuentaNeg.ListarCuentaxCliente(user_dni));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/SolicitarPrestamosCliente.jsp");
			dispatcher.forward(request, response);
		}

	}

}
