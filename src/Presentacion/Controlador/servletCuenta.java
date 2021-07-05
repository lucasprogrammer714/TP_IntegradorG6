package Presentacion.Controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Cuentas;
import Negocio.ClienteNeg;
import Negocio.CuentaNeg;
import NegocioImpl.ClienteNegImpl;
import NegocioImpl.CuentaNegImpl;

@WebServlet("/servletCuenta")
public class servletCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	CuentaNeg cuenta_N = new CuentaNegImpl();
	Cuentas cuenta = new Cuentas();
	ClienteNeg cliente_N = new ClienteNegImpl();
	
	
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
			int contcuentas=cuenta_N.contarCuentasAdmin(request.getParameter("txtDniAltaCuenta"));
			///System.out.println("NUMERO DE CUENTAS: " + contcuentas);
			if(contcuentas<=2) {
				
				boolean cuentaAgregada = false;
			    cuenta.setDni_cuenta(request.getParameter("txtDniAltaCuenta"));
				cuenta.setNumero_cuenta(Integer.parseInt(request.getParameter("txtNroCuenta")));
				cuenta.setTipo_cuenta(request.getParameter(("ddlTipoCuenta").toString()));
				cuenta.setCbu(request.getParameter("txtCBU"));
				cuenta.setCreacion(LocalDate.parse(request.getParameter("txtFechaCreacionCuenta").toString()));
				cuenta.setSaldo(Float.parseFloat(request.getParameter("txtSaldo")));
				cuenta.setEstado_cuenta(true);
				
				System.out.println("USUARIO: " + cuenta.getDni_cuenta());
				System.out.println("N CUENTA: " + cuenta.getNumero_cuenta());
				System.out.println("CBU: " + cuenta.getCbu());
				System.out.println("FECHA: " + cuenta.getCreacion());
				System.out.println("TIPO CUENTA: " + cuenta.getTipo_cuenta());
				System.out.println("SALDO: " + cuenta.getSaldo());
				System.out.println("ESTADO: " + cuenta.getEstado_cuenta());
				
				cuentaAgregada = cuenta_N.insert(cuenta);
				
				if (cuentaAgregada == true)
				{
					request.setAttribute("cuentaAgregada", cuentaAgregada);
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AltaCuentaAdmin.jsp");
				dispatcher.forward(request, response);
			}
			
			else {
				request.setAttribute("NCuentasExcedida", contcuentas);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AltaCuentaAdmin.jsp");
				dispatcher.forward(request, response);
			}
			
			
		}
	
	
	
	
	
	
	if (request.getParameter("btnBajaCuenta")!=null)
	   {
		
		 int existeCuenta = 0;
		 
		 try { 
			 boolean bajaCuenta = false;
				existeCuenta = cuenta_N.buscar_una_cuenta(Integer.parseInt(request.getParameter("txtNroCuentaEliminar")));
				System.out.println("Cuenta_EXISTE: " + existeCuenta);
				if(existeCuenta == 1){
				
					bajaCuenta = cuenta_N.borrarCuenta(Integer.parseInt(request.getParameter("txtNroCuentaEliminar")));
					if(bajaCuenta=true) {
					int baja=1;
					System.out.println("ESTADO: " + baja);
					request.setAttribute("baja_cuenta", baja);
					}
				
				}
				else {
				   request.setAttribute("noExiste", existeCuenta);
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher("/BajaCuentaAdmin.jsp");
				dispatcher.forward(request, response);
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
	   }
	
	}
}
