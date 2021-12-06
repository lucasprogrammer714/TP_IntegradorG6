package Presentacion.Controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NegocioImpl.MovimientosNegImpl;

/**
 * Servlet implementation class servletReportes
 */
@WebServlet("/servletReportes")
public class servletReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MovimientosNegImpl movNeg = new MovimientosNegImpl();
    
    public servletReportes() {
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

		if(request.getParameter("btnReporte")!=null)
		{
			
			String fechaInicio = request.getParameter("txtFechaInicio");
			String fechaFin = request.getParameter("txtFechaFin");
			
			float reporte = movNeg.reporteIngresoFecha(fechaInicio, fechaFin);
			
			request.setAttribute("reporteFechas", reporte);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ReporteIngresos.jsp");
			dispatcher.forward(request, response);
			
		}
		
		
	}

}
