package Presentacion.Controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

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

		if(request.getParameter("btnReporteFechas")!=null)
		{
			
			String fechaInicio = request.getParameter("txtFechaInicio");
			String fechaFin = request.getParameter("txtFechaFin");
			
			float reporte = movNeg.reporteIngresoFecha(fechaInicio, fechaFin);
			
			request.setAttribute("reporteFechas", reporte);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ReporteIngresos.jsp");
			dispatcher.forward(request, response);
			
		}
		 
		
		
		if(request.getParameter("btnReporteIngresoMensual")!=null)
		{
			
			int month = Integer.parseInt(request.getParameter("MesesReporte"));
			
			LocalDate currentDate = LocalDate.now();
			int year = currentDate.getYear(); 
			
			
			
			float reporteMensual = movNeg.reporteIngresoMensual(year, month);
			
			request.setAttribute("ReporteMes", reporteMensual);
			RequestDispatcher disptacher = request.getRequestDispatcher("/ReporteIngresos.jsp");
			disptacher.forward(request, response);
			
		}
		
		if(request.getParameter("btnReporteAnual")!=null)
		{
			
			LocalDate currentDate = LocalDate.now();
			int year = currentDate.getYear(); 
			
			float reporteAnual = movNeg.reporteIngresoAnual(year);
			//Float[] reporteMensual = new Float[12];
			
			//reporteMensual = movNeg.ingresosMensual();
	
		//	String param = Arrays.toString(reporteMensual);
			
			request.setAttribute("reporteAnual", reporteAnual);
			//request.setAttribute("reporteMensual", param);
			RequestDispatcher disptacher = request.getRequestDispatcher("/ReporteIngresos.jsp");
			disptacher.forward(request, response);
		}
		
		if(request.getParameter("btnReporteEgresoFechas")!=null)
		{
			
			String fechaInicio = request.getParameter("txtFechaInicio");
			String fechaFin = request.getParameter("txtFechaFin");
			
			float reporte = movNeg.reporte_egresoFecha(fechaInicio, fechaFin);
			
			request.setAttribute("reporteFechas", reporte);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ReporteEgresos.jsp");
			dispatcher.forward(request, response);
			
		}
		 
		if(request.getParameter("btnReporteEgresoAnual")!=null)
		{
			
			LocalDate currentDate = LocalDate.now();
			int year = currentDate.getYear(); 
			
			float reporteAnual = movNeg.reporte_egresoAnual(year);
			
		
			
			request.setAttribute("reporteAnual", reporteAnual);
		
			RequestDispatcher disptacher = request.getRequestDispatcher("/ReporteEgresos.jsp");
			disptacher.forward(request, response);
		}
		
		
		if(request.getParameter("btnReporteEgresoMensual")!=null)
		{
			
			int month = Integer.parseInt(request.getParameter("Meses"));
			
			LocalDate currentDate = LocalDate.now();
			int year = currentDate.getYear(); 
			
			
			
			float reporteMensual = movNeg.egresosBancoMensual(year, month);
			
			request.setAttribute("ReporteMes", reporteMensual);

			
			RequestDispatcher disptacher = request.getRequestDispatcher("/ReporteEgresos.jsp");
			disptacher.forward(request, response);
			
		}
		
		if(request.getParameter("btnGananciaPrestamo")!=null)
		{
			
			String fechaInicio = request.getParameter("fechainicio");
			String fechaFin = request.getParameter("fechafin");
			
			float reporte = movNeg.gananciaPrestamos(fechaInicio, fechaFin);
			
			request.setAttribute("gananciaPrestamos", reporte);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ReportePrestamos.jsp");
			dispatcher.forward(request, response);
			
		}
		
		if(request.getParameter("btngananciaPrestamoAnual")!=null) {
			LocalDate currentDate = LocalDate.now();
			int year = currentDate.getYear();
			float gananciaAnual = movNeg.ingresoPrestamoAnual(year);
			System.out.println("GANANCIA ANUAL: " + gananciaAnual);
			request.setAttribute("gananciaAnual", gananciaAnual);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ReportePrestamos.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

}
