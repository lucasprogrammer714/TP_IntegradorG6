package Presentacion.Controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Cuentas;
import Entidad.Prestamos;
import Negocio.ClienteNeg;
import Negocio.CuentaNeg;
import Negocio.PrestamoNeg;
import NegocioImpl.ClienteNegImpl;
import NegocioImpl.CuentaNegImpl;
import NegocioImpl.PrestamosNegImpl;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Servlet implementation class servletPrestamos
 */
@WebServlet("/servletPrestamos")
public class servletPrestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ClienteNeg clienteNeg = new ClienteNegImpl();
	CuentaNeg cuentaNeg = new CuentaNegImpl();
	PrestamoNeg prestamoNeg = new PrestamosNegImpl();
	
    public servletPrestamos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("btnEnviar")!=null)
		{
			Prestamos prestamos = new Prestamos();
			Boolean registro = false;
			String user_dni;
			float interes=(float) 1.54;
			
			String user = request.getSession().getAttribute("User").toString();
			user_dni = clienteNeg.Dni_de_Usuario(user).toString();
			ArrayList <Cuentas> list = cuentaNeg.ListarCuentaxCliente(user_dni);			
			request.setAttribute("listaCuentasUser", list);
			
			prestamos.setDni_prestamo(user_dni);
			//prestamos.setNro_cuenta_p();//no recuerdo como agregar los numeros de cuenta que tenia el cliente
			prestamos.setFecha_p(LocalDate.now());
			prestamos.setImporte_pedido(Float.parseFloat(request.getParameter("txtMonto").toString()));//es el importe que solicita el cliente
			prestamos.setCuotas(Integer.parseInt(request.getParameter("Cuotas").toString())); //las cuotas en las que el cliente desea pagar
			prestamos.setImp_debe_pagar(Float.parseFloat(request.getParameter("txtMonto"))*interes); // segun el importe pedido se le multiplica un interes del 54% tomando de ejemplo un banco
			prestamos.setMonto_mensual(prestamos.getImp_debe_pagar()/ Integer.parseInt(request.getParameter("Cuotas"))); // calcula lo que se calculo en el importe que se debe pagar dividido las cuotas solicitadas esto daria el importe a pagar por mes          
			prestamos.setPendiente(true);
			prestamos.setAutorizado(false);
			registro = prestamoNeg.insertar(prestamos);
			request.setAttribute("RegistroExitoso", registro);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/PrestamosClienteTradicional.jsp");
			dispatcher.forward(request, response);
		} //fin del if btn enviar
	}

}
