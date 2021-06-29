package Presentacion.Controlador;

import java.io.IOException;

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
			
			cliente.setDni(request.getParameter("txtDni"));
			cliente.setCuil(request.getParameter("txtCuil"));
			cliente.setNombre(request.getParameter("txtNombre"));
			cliente.setApellido(request.getParameter("txtApellido"));
			cliente.setSexo(request.getParameter("ddlSexo"));
			cliente.setNacionalidad(request.getParameter("txtNacionalidad"));
		
			cliente.setDireccion(request.getParameter("txtDireccion"));
			cliente.setLocalidad(request.getParameter("txtLocalidad"));
			cliente.setProvincia(request.getParameter("txtProvincia"));
			cliente.setEmail(request.getParameter("txtCorreo"));
			cliente.setTelefono_fijo(request.getParameter("txtTelFijo"));
			cliente.setTelefono(request.getParameter("txtTelCel"));
			cliente.setUsuario(request.getParameter("txtUsuarioCliente"));
			//cliente.setContraseña(request.getParameter("txtContraseña"));
			
			clienteNeg.insertar(cliente);
			
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/RegistroClienteAdmin.jsp");
			dispatcher.forward(request, response);
		
		}
		


}
	
	
}
