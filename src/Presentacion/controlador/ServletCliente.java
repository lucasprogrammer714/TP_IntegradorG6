package Presentacion.controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Cliente;
import negocio.ClienteNeg;
import negocioImpl.ClienteNegImpl;
//import presentacion.controller.RequestDispatcher;


@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ClienteNeg negCli = new ClienteNegImpl();
       
    public ServletCliente() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if(request.getParameter("btnRegistrarUsuario")!=null)
		{
			Cliente c = new Cliente();
			c.setDni(request.getParameter("txtDni"));
			c.setCuil(request.getParameter("txtCuil"));
			c.setNombre(request.getParameter("txtNombre"));
			c.setApellido(request.getParameter("txtApellido"));
			c.setSexo(request.getParameter("ddlSexo"));
			c.setNacionalidad(request.getParameter("txtNacionalidad"));
			c.setNacimiento(request.getParameter("txtFechaNacimiento"));  //esto tenia que ser datetime o date en sql ya que eclipse no trabaja con datetime
			c.setDireccion(request.getParameter("txtDireccion"));
			c.setLocalidad(request.getParameter("txtLocalidad"));
			c.setProvincia(request.getParameter("txtProvincia"));
			c.setEmail(request.getParameter("txtCorreo"));
			c.setTelefono(request.getParameter("txtTelCel"));
			c.setUsuario(request.getParameter("txtCliente"));
			c.setContraseña(request.getParameter("txtContraseña"));
			c.setAdministrador(false);
			c.setEstado(true);
			boolean est=true;
			est = negCli.insertar(c);
			
			request.setAttribute("estadoCliente", est);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/RegistroClienteAdmin.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
