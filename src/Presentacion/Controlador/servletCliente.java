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
import Excepciones.FaltaArrobaException;
import Excepciones.FaltaPuntoException;
import Negocio.ClienteNeg;
import Negocio.CuentaNeg;
import Negocio.MovimientosNeg;
import NegocioImpl.ClienteNegImpl;
import NegocioImpl.CuentaNegImpl;
import NegocioImpl.MovimientosNegImpl;


@WebServlet("/servletCliente")
public class servletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	ClienteNeg clienteNeg = new ClienteNegImpl();
	CuentaNeg cuentaNeg = new CuentaNegImpl();
	MovimientosNeg movimientoNeg = new MovimientosNegImpl();

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
				
					String user = request.getSession().getAttribute("User").toString();
					
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
				String user = request.getSession().getAttribute("User").toString();
				user_dni = clienteNeg.Dni_de_Usuario(user).toString();
				///ArrayList <Cuentas> list = cuentaNeg.ListarCuentaxCliente(user_dni);
				///misession.setAttribute("listacuentas", list);
				///request.setAttribute("listaCuentasUser", list);	
				request.setAttribute("listaCuentasUser", cuentaNeg.ListarCuentaxCliente(user_dni));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/MovimientosCuentas.jsp");
				dispatcher.forward(request, response);
			
			break;
			}
			
			case "solicitarPrestamo":
			{
				String user = request.getSession().getAttribute("User").toString();
				user_dni = clienteNeg.Dni_de_Usuario(user).toString();
				
				request.setAttribute("listaCuentasUser", cuentaNeg.ListarCuentaxCliente(user_dni));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/SolicitarPrestamosCliente.jsp");
				dispatcher.forward(request, response);
			break;
			}
			default:
				break;
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if (request.getParameter("btnRegistrarUsuario")!=null)
		{
			
			Cliente cliente = new Cliente();
			
			Boolean registro = false;
			
			
			String mailValidar = request.getParameter("txtCorreo");
			
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
	cliente.setContrase�a(request.getParameter("txtContrase�a"));
	cliente.setAdministrador(false);
	cliente.setEstado(true);
	registro = clienteNeg.insertar(cliente);
	
	
	request.setAttribute("RegistroExitoso", registro);
	RequestDispatcher dispatcher = request.getRequestDispatcher("/RegistroClienteAdmin.jsp");
	dispatcher.forward(request, response);
		}
		
		
	if (request.getParameter("btnBajaCliente")!= null)
		{
			
			boolean baja = false;
			int cliente_existe;
			try {
				cliente_existe = clienteNeg.buscar_un_cliente(Integer.parseInt(request.getParameter("txtDniBajaCliente")));
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
	
	
		
		
		if (request.getParameter("btnCambiarContrase�a")!= null)
		{
			
			boolean contrasenaCambiada = false;

			String user = request.getParameter("txtNombreUsuario");
			String pass = request.getParameter("txtContrase�a");
			String pass2 = request.getParameter("txtConfirmarContrase�a");
	
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
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/CambioContrase�aAdmin.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
		if(request.getParameter("btnListarMovimientos")!=null) {
			String user = request.getSession().getAttribute("User").toString();
			String user_dni = clienteNeg.Dni_de_Usuario(user).toString();
			int ncuenta=Integer.parseInt(request.getParameter("ncuenta"));
			System.out.println("DNI USUARIO: " + user_dni + ", NCUENTA: " + ncuenta);
			ArrayList <Movimientos> list = movimientoNeg.Listar_movimientos_por_cuenta(user_dni, ncuenta);
			
			request.setAttribute("listaMovimientos", list);	
			request.setAttribute("listaCuentasUser", cuentaNeg.ListarCuentaxCliente(user_dni));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/MovimientosCuentas.jsp");
			dispatcher.forward(request, response);
		}
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
		
	
}
