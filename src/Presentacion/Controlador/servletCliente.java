package Presentacion.Controlador;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

///import javax.servlet.RequestDispatcher;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entidad.Cliente;
import Entidad.Cuentas;
import Entidad.Movimientos;
import Entidad.Prestamos;
import Excepciones.FaltaArrobaException;
import Excepciones.FaltaPuntoException;
import Negocio.ClienteNeg;
import Negocio.CuentaNeg;
import Negocio.MovimientosNeg;
import Negocio.PrestamosNeg;
import NegocioImpl.ClienteNegImpl;
import NegocioImpl.CuentaNegImpl;
import NegocioImpl.MovimientosNegImpl;
import NegocioImpl.PrestamosNegImpl;


@WebServlet("/servletCliente")
public class servletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	ClienteNeg clienteNeg = new ClienteNegImpl();
	CuentaNeg cuentaNeg = new CuentaNegImpl();
	MovimientosNeg movimientoNeg = new MovimientosNegImpl();
	PrestamosNeg prestamoNeg = new PrestamosNegImpl();

    public servletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getParameter("Param")!=null)
		{
		
           String user_dni;
			
			String option = request.getParameter("Param").toString();
			
			
			switch (option){
			
			case "listCuentasUser":
			{
				
					String user = request.getSession().getAttribute("usuariolog").toString();
					
					user_dni = clienteNeg.Dni_de_Usuario(user).toString();
					
					ArrayList <Cuentas> list = cuentaNeg.ListarCuentaxCliente(user_dni);
					
					request.setAttribute("listaCuentasUser", list);	
					RequestDispatcher dispatcher = request.getRequestDispatcher("/TransferenciaClientes.jsp");
					dispatcher.forward(request, response);
			
			break;	
			}
			case "list":
			{
				
			request.setAttribute("listaU", clienteNeg.listarClientes());	
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ListadoClientesAdmin.jsp");
			dispatcher.forward(request, response);
			break;
			}
			
			case "movCuentas":
			{
				HttpSession misession= request.getSession(true);
				String user = request.getSession().getAttribute("usuariolog").toString();
				user_dni = clienteNeg.Dni_de_Usuario(user).toString();
				///ArrayList <Cuentas> list = cuentaNeg.ListarCuentaxCliente(user_dni);
				///misession.setAttribute("listacuentas", list);
				///request.setAttribute("listaCuentasUser", list);	
				request.setAttribute("listaCuentasUser", cuentaNeg.ListarCuentaxCliente(user_dni));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/MovimientosCuentas.jsp");
				dispatcher.forward(request, response);
			
			break;
			}
			case "listCuentasUserSaldo":
			{
				
					String user = request.getSession().getAttribute("usuariolog").toString();
					
					user_dni = clienteNeg.Dni_de_Usuario(user).toString();
					
					ArrayList <Cuentas> list = cuentaNeg.ListarCuentaxCliente(user_dni);
				
					request.setAttribute("listaCuentasUserSaldo", list);	
					RequestDispatcher dispatcher = request.getRequestDispatcher("/SaldoCuentasCliente.jsp");
					dispatcher.forward(request, response);
			
			break;	
			}

			
			case "solicitarPrestamo":
			{
				
				Prestamos prestamo = new Prestamos();
				String user = request.getSession().getAttribute("usuariolog").toString();
				//int nro_cuenta_prestamo = 0;
				user_dni = clienteNeg.Dni_de_Usuario(user).toString();
				
				//nro_cuenta_prestamo = prestamoNeg.cuentaPrestamo(user_dni);
				int contarPrestamo=prestamoNeg.contarPrestamo(user_dni);
				//System.out.println("nro_cuenta_prestamo: " + nro_cuenta_prestamo);
				//System.out.println("CONTADOR DE PRESTAMOS PENDIENTES: " + contarPrestamo);
			    //System.out.println(prestamo.getDni_prestamo());
				//System.out.println(prestamo.getNro_cuenta_p());
				//System.out.println(prestamo.getFecha_p().toString());
				//System.out.println(prestamo.getImp_debe_pagar());
				//System.out.println(prestamo.getImporte_pedido());
				//System.out.println(prestamo.getPlazo());
				System.out.println(prestamo.getId_prestamo());
				System.out.println(prestamo.getMonto_mensual());
				System.out.println(prestamo.getCuotas());
				System.out.println(prestamo.isPendiente());
				System.out.println(prestamo.isAutorizado());
				System.out.println(prestamo.getSaldado());
				if(contarPrestamo>0) {
					if(contarPrestamo==1) {
						System.out.println("TIENE UN PRESTAMO PENDIENTE PARA AUTORIZACION");
						request.setAttribute("ESTADOPRESTAMO", contarPrestamo);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/MensajePrestamosPendientes.jsp");
						dispatcher.forward(request, response);
					}
					else {
						System.out.println("TIENE UN PRESTAMO SIN SALDAR");
						request.setAttribute("ESTADOPRESTAMO", contarPrestamo);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/MensajePrestamosPendientes.jsp");
						dispatcher.forward(request, response);
					}	
				}
				
				else {
					request.setAttribute("listaCuentasUser", cuentaNeg.ListarCuentaxCliente(user_dni));
					RequestDispatcher dispatcher = request.getRequestDispatcher("/SolicitarPrestamosCliente.jsp");
					dispatcher.forward(request, response);
				}
				
			break;
			}
			
			case "mostrarDatos":
				String user = request.getSession().getAttribute("usuariolog").toString();
				user_dni = clienteNeg.Dni_de_Usuario(user).toString();
				request.setAttribute("datosuser", clienteNeg.obtenerdatoscliente(user_dni));
				request.getSession().setAttribute("datosusuario", clienteNeg.obtenerdatoscliente(user_dni));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/DatosCliente.jsp");
				dispatcher.forward(request, response);
			
			default:
				break;
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if (request.getParameter("btnRegistrarUsuario")!=null)
		{
			
			boolean contraseñasIguales = compararContraseña(request.getParameter("txtContraseña"),request.getParameter("txtContraseñaConfirmar"));
			boolean dniSoloNumeros = isNumeric(request.getParameter("txtDni"));
			boolean cuilSoloNumeros = isNumeric(request.getParameter("txtCuil"));
			boolean telFijoSoloNumeros = isNumeric(request.getParameter("txtTelFijo"));
			boolean telCelularSoloNumeros = isNumeric(request.getParameter("txtTelCel"));
			boolean validarMail  = false;
			try {
				validarMail = validarMail(request.getParameter("txtCorreo"));
				
			} catch (FaltaArrobaException e1) {
				
				e1.printStackTrace();
			} catch (FaltaPuntoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


			int nombreUsuarioExiste = clienteNeg.buscarNombreUsuarioCliente(request.getParameter("txtUsuarioCliente"));
			int dniCliente;
			try {
				dniCliente = clienteNeg.buscar_un_cliente(request.getParameter("txtDni"));
				
				if(contraseñasIguales==true && nombreUsuarioExiste != 1 && dniCliente != 1 &&
						dniSoloNumeros == true && cuilSoloNumeros == true  && telFijoSoloNumeros == true && telCelularSoloNumeros == true && validarMail == true)
				{
					
		Cliente cliente = new Cliente();
			
		Boolean registro = false;
				
		cliente.setDni(request.getParameter("txtDni"));
		cliente.setCuil(request.getParameter("txtCuil"));
		cliente.setNombre(request.getParameter("txtNombre"));
		cliente.setApellido(request.getParameter("txtApellido"));
		cliente.setSexo(request.getParameter("ddlSexo").toString());
		cliente.setNacionalidad(request.getParameter("txtNacionalidad"));
		cliente.setNacimiento(LocalDate.parse(request.getParameter("txtFechaNacimiento").toString()));
		///cliente.setNacimiento(null);
		cliente.setDireccion(request.getParameter("txtDireccion"));
		cliente.setLocalidad(request.getParameter("txtLocalidad"));
		cliente.setProvincia(request.getParameter("txtProvincia"));
		cliente.setEmail(request.getParameter("txtCorreo"));
		cliente.setTelefono_fijo(request.getParameter("txtTelFijo"));
		cliente.setTelefono(request.getParameter("txtTelCel"));
		cliente.setUsuario(request.getParameter("txtUsuarioCliente"));
		cliente.setContraseña(request.getParameter("txtContraseña"));
		cliente.setAdministrador(false);
		cliente.setEstado(true);
		registro = clienteNeg.insertar(cliente);
		
		
		
		
		
		request.setAttribute("RegistroExitoso", registro);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/RegistroClienteAdmin.jsp");
		dispatcher.forward(request, response);
		
				}
				else
				{
					request.setAttribute("ContraseñasIguales", contraseñasIguales);
					request.setAttribute("NombreUsuarioExiste", nombreUsuarioExiste);
					request.setAttribute("DniCliente", dniCliente);
					request.setAttribute("DniSoloNumeros", dniSoloNumeros);
					request.setAttribute("CuilSoloNumeros", cuilSoloNumeros);
					request.setAttribute("TelFijoSoloNumeros", telFijoSoloNumeros);
					request.setAttribute("CelularSoloNumeros", telCelularSoloNumeros);
					request.setAttribute("ValidacionMail", validarMail);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/RegistroClienteAdmin.jsp");
					dispatcher.forward(request, response);

				}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		
		
	if (request.getParameter("btnBajaCliente")!= null)
		{
			
			boolean baja = false;
			int cliente_existe;
			try {
				cliente_existe = clienteNeg.buscar_un_cliente(request.getParameter("txtDniBajaCliente"));
				///System.out.println("CLIENTE_EXISTE: " +cliente_existe);
				if(cliente_existe == 1){
				
					baja = clienteNeg.borrar(Integer.parseInt(request.getParameter("txtDniBajaCliente")));
					if(baja=true) {
					int baja1=1;
					//System.out.println("ESTADO: " + baja);
					request.setAttribute("baja_cliente", baja1);
					}
				
				}
				else {
				   request.setAttribute("noExiste", cliente_existe);
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher("/BajaClienteAdmin.jsp");
				dispatcher.forward(request, response);
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
	
	
		
		
		if (request.getParameter("btnCambiarContraseña")!= null)
		{
			
			boolean contrasenaCambiada = false;

			String user = request.getParameter("txtNombreUsuario");
			String pass = request.getParameter("txtContraseña");
			String pass2 = request.getParameter("txtConfirmarContraseña");
	
			int iguales = 0;
			int usuarioExiste = 0;
			
			
			try {
			
				usuarioExiste = clienteNeg.buscarNombreUsuarioCliente(user);

				if (usuarioExiste==1) {
					
					if (pass.equals(pass2)) {
						iguales = 1;
				contrasenaCambiada =	clienteNeg.cambiar_contrasena(user,pass);	
			    request.setAttribute("cambioExitoso", contrasenaCambiada);
					}
					
					else
						request.setAttribute("igualPass", iguales);
				}else
					request.setAttribute("UserExiste", usuarioExiste);
					
			}
			
				
			
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/CambioContraseñaAdmin.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
		if(request.getParameter("btnListarMovimientos")!=null) {
			String user = request.getSession().getAttribute("usuariolog").toString();
			String user_dni = clienteNeg.Dni_de_Usuario(user).toString();
			int ncuenta=Integer.parseInt(request.getParameter("ncuenta"));
			System.out.println("DNI USUARIO: " + user_dni + ", NCUENTA: " + ncuenta);
			ArrayList <Movimientos> list = movimientoNeg.Listar_movimientos_por_cuenta(user_dni, ncuenta);
			
			request.setAttribute("listaMovimientos", list);	
			request.setAttribute("listaCuentasUser", cuentaNeg.ListarCuentaxCliente(user_dni));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/MovimientosCuentas.jsp");
			dispatcher.forward(request, response);
		}
		
		
		if(request.getParameter("btnBuscar")!=null) {
			String busqueda = request.getParameter("txtBusqueda");
			request.setAttribute("listaU", clienteNeg.listarClientesBusqueda(busqueda));	
			RequestDispatcher dispatcher = request.getRequestDispatcher("/BuscarFiltrarClientesAdmin.jsp");
			dispatcher.forward(request, response);
		}
		
		if(request.getParameter("btnBuscarPorFecha")!=null) {
			String fechainicio = request.getParameter("fechainicio");
			String fechafin = request.getParameter("fechafin");
			System.out.println("INICIO: " + fechainicio + ", FIN: " + fechafin);
			request.setAttribute("listaU", clienteNeg.listarClientesFiltro(fechainicio, fechafin));	
			RequestDispatcher dispatcher = request.getRequestDispatcher("/BuscarFiltrarClientesAdmin.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
	} 
	
	

    public static boolean isNumeric(String str)
  {
    return str.matches("-?\\d+(\\.\\d+)?");  
  }
	
	public boolean validarMail(String mail) throws FaltaArrobaException, FaltaPuntoException
	{
		boolean arroba = false;
		boolean punto = false;
		
		
		
		for (int i = 0; i< mail.length(); i ++)
		{
			if (mail.charAt(i) == '@')
				arroba = true;
			if (mail.charAt(i) == '.')
				punto = true;
		}
		
		
		if (arroba == false)
		{
			
			
			FaltaArrobaException excArroba = new FaltaArrobaException();
			 throw excArroba;
			
		}
		
		
		if (punto == false)
		{
			FaltaPuntoException excPunto = new FaltaPuntoException();
            throw excPunto;
		}
		
		
		if (arroba == true && punto == true)
		{
			return  true ;
		}
		
		return false;
	}
		
	public boolean compararContraseña (String contraseña, String contraseña2)
	{
		if(contraseña.equals(contraseña2))
		{
			return true;
		}
		
		return false;
	}
}
