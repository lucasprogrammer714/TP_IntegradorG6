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
			String usuario = request.getSession().getAttribute("usuariolog").toString();
			String tipo_movimiento ="Extraccion";
			String CBU=request.getParameter("txtCBU");
			String dniDepo="";
			String ncuentaDepo="";
			
			user_dni = clienteNeg.Dni_de_Usuario(usuario);
			Movimientos movimiento = new Movimientos();
			boolean registro = false;
			boolean registroF=true;
			
			
			movimiento.setDni_movimiento(user_dni);
			movimiento.setNro_cuenta_movimiento(Integer.parseInt(request.getParameter("cuentassaldo").toString()));
			movimiento.setFecha_movimiento(LocalDate.parse(request.getParameter("txtFechaTransferencia")));
			movimiento.setDetalle(request.getParameter("txtDetalle"));
			movimiento.setImporte(Float.parseFloat(request.getParameter("txtImporte")));
			movimiento.setTipo_movimiento(tipo_movimiento);
			dniDepo=cuentaNeg.Dni_de_Cuenta(CBU);
			ncuentaDepo=cuentaNeg.Numero_de_Cuenta(CBU);
			
			System.out.println("DNI DEPO: " + dniDepo + ", CUENTA DEPO: " + ncuentaDepo);
			ArrayList <Cuentas> list = cuentaNeg.ListarCuentaxCliente(user_dni);
			
			
			
			for(int i=0; i<list.size();i++) {
				if(list.get(i).getNumero_cuenta() == Integer.parseInt(request.getParameter("cuentassaldo"))) {
					if(Float.parseFloat(request.getParameter("txtImporte"))>list.get(i).getSaldo()){
						request.setAttribute("registroFallido", registroF);
						request.setAttribute("listaCuentasUser", list);	
						RequestDispatcher dispatcher = request.getRequestDispatcher("/TransferenciaClientes.jsp");
						dispatcher.forward(request, response);
					}
					else {
						registro = move.registrarMovimientoSP(movimiento,dniDepo, ncuentaDepo);
						System.out.println("ESTADO: " + registro);
						request.setAttribute("listaCuentasUser", list);	
						request.setAttribute("registroExitoso", registro);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/TransferenciaClientes.jsp");
						dispatcher.forward(request, response);
					}
				}
			} 
		}	
	}
}
