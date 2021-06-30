package Presentacion.Controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Negocio.ClienteNeg;
import NegocioImpl.ClienteNegImpl;


@WebServlet("/servletLogin")
public class servletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ClienteNeg clienteNeg = new ClienteNegImpl();

    public servletLogin() {
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
		///doGet(request, response);
		
		
		if(request.getParameter("btnLogin")!= null) {
			
			String user = request.getParameter("txtUsuario");
			String pass = request.getParameter("txtContraseña");
			
			try {
				String usu = request.getParameter("txtUsuario");
				int usuario = 3;
				usuario=clienteNeg.buscarUsuario(user, pass);
				if(usuario==1) {
					request.setAttribute("Usuario", usu);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/UsuarioAdmin.jsp");
					dispatcher.forward(request, response);
				}
				
				else if(usuario==2){
					request.setAttribute("Usuario", usu);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/UsuarioCliente.jsp");
					dispatcher.forward(request, response);
				}
				else {
					request.setAttribute("Usuario", usu);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
					dispatcher.forward(request, response);
				}
				
				
			}catch(Exception e){
				System.out.println(e.getMessage());
			}	
		}
	}
}
