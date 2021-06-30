package Presentacion.Controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Cuentas;
import Negocio.CuentaNeg;
import NegocioImpl.CuentaNegImpl;

@WebServlet("/servletCuenta")
public class servletCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	CuentaNeg cuenta_N = new CuentaNegImpl();
	
    public servletCuenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if(request.getParameter("btnAgregarCuenta")!=null)
		{
			
			Cuentas cuenta = new Cuentas();		
			cuenta.setDni_cuenta(request.getParameter("txtUsuarioAltaCuenta"));
			cuenta.setNumero_cuenta(Integer.parseInt(request.getParameter("txtNroCuenta")));
			cuenta.setTipo_cuenta(request.getParameter(("ddlTipoCuenta").toString()));
			cuenta.setCbu(request.getParameter("txtCBU"));
			cuenta.setCreacion(null);
			cuenta.setSaldo(Float.parseFloat(request.getParameter("txtSaldo")));
			cuenta.setEstado_cuenta(true);
			
			System.out.println("USUARIO: " + cuenta.getDni_cuenta());
			System.out.println("N CUENTA: " + cuenta.getNumero_cuenta());
			System.out.println("CBU: " + cuenta.getCbu());
			System.out.println("FECHA: " + cuenta.getCreacion());
			System.out.println("TIPO CUENTA: " + cuenta.getTipo_cuenta());
			System.out.println("SALDO: " + cuenta.getSaldo());
			System.out.println("ESTADO: " + cuenta.getEstado_cuenta());
			
			cuenta_N.insert(cuenta);
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AltaCuentaAdmin.jsp");
			dispatcher.forward(request, response);
			
		}
		
	}
}
