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
import Negocio.ClienteNeg;
import Negocio.CuentaNeg;
import Negocio.MovimientosNeg;
import NegocioImpl.ClienteNegImpl;
import NegocioImpl.CuentaNegImpl;
import NegocioImpl.MovimientosNegImpl;


@WebServlet("/servletTransferencia")
public class servletTransferencia extends HttpServlet {
	
	
	MovimientosNeg move = new MovimientosNegImpl();
	ClienteNeg clienteNeg = new ClienteNegImpl();
	CuentaNeg cuentaNeg = new CuentaNegImpl();

	private static final long serialVersionUID = 1L;
       
 
    public servletTransferencia() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String user_dni;
		
		if (request.getParameter("btnTransferir")!=null)
		{
			String usuario = request.getSession().getAttribute("User").toString();
			String tipo_movimiento ="Extraccion";
			
			user_dni = clienteNeg.Dni_de_Usuario(usuario);
			Movimientos movimiento = new Movimientos();
			boolean registro = false;
			
			
			movimiento.setDni_movimiento(user_dni);
			movimiento.setNro_cuenta_movimiento(Integer.parseInt(request.getParameter("ddlNroCuenta").toString()));
			movimiento.setFecha_movimiento(LocalDate.parse(request.getParameter("txtFechaTransferencia")));
			movimiento.setDetalle(request.getParameter("txtDetalle"));
			movimiento.setImporte(Float.parseFloat(request.getParameter("txtImporte")));
			movimiento.setTipo_movimiento(tipo_movimiento);
			
			registro = move.registarMovimiento(movimiento);
			
			
			ArrayList <Cuentas> list = cuentaNeg.ListarCuentaxCliente(user_dni);
			request.setAttribute("listaCuentasUser", list);	
			request.setAttribute("registroExitoso", registro);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/TransferenciaClientes.jsp");
			dispatcher.forward(request, response);
			
			 
		}
		
		
	}

}
