package Presentacion.Controlador;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

///import javax.servlet.RequestDispatcher;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Cliente;
import Negocio.ClienteNeg;
import NegocioImpl.ClienteNegImpl;


@WebServlet("/servletCliente")
public class servletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	ClienteNeg clienteNeg = new ClienteNegImpl();
	

    public servletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if (request.getParameter("btnRegistrarUsuario")!=null)
		{
			
			Cliente cliente = new Cliente();
			
			///LocalDate date = LocalDate.parse(request.getParameter("txtFechaNacimiento"));
			
			/*
			
			try {
				SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				Date fecha;
				fecha = (Date) formato.parse(request.getParameter("txtFechaNacimiento"));
				cliente.setNacimiento(fecha);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			
			///System.out.println("FECHA: " + date);
			//cliente.setNacimiento(null);
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
			clienteNeg.insertar(cliente);
			
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
		
	}
	
	
}
