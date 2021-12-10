package Presentacion.Controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Cuentas;
import Entidad.Movimientos;
import Entidad.Prestamos;
import Negocio.ClienteNeg;
import Negocio.CuentaNeg;
import Negocio.MovimientosNeg;
import Negocio.PrestamosNeg;
import NegocioImpl.ClienteNegImpl;
import NegocioImpl.CuentaNegImpl;
import NegocioImpl.MovimientosNegImpl;
import NegocioImpl.PrestamosNegImpl;

/**
 * Servlet implementation class servletPrestamos
 */
@WebServlet("/servletPrestamos")
public class servletPrestamos extends HttpServlet {
	CuentaNeg cuentaNeg = new CuentaNegImpl();
	//Cuentas cuenta = new Cuentas();
	
	PrestamosNeg prestamoN = new PrestamosNegImpl();
	ClienteNeg clienteNeg = new ClienteNegImpl();
	MovimientosNeg movimientoNeg = new MovimientosNegImpl();
	
	
	

    public servletPrestamos() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("Param")!=null)
		{
	        String user_dni;
			String option = request.getParameter("Param").toString();
			
			switch(option)
			{
			case "PagarCuotasPrestamos":
			{
				System.out.println("SERVLET PRESTAMO SIN BOTON PAGAR");
				int nro_cuenta_prestamo_Datos;
				boolean prestamosaldado= false;
				int contador=0;
				Prestamos prestamo = new Prestamos();
				String user = request.getSession().getAttribute("usuariolog").toString();
				int nro_cuenta_prestamo = 0;
				user_dni = clienteNeg.Dni_de_Usuario(user).toString();
				nro_cuenta_prestamo = prestamoN.cuentaPrestamo(user_dni);
				nro_cuenta_prestamo_Datos = prestamoN.cuentaPrestamo(user_dni);
				ArrayList <Cuentas> list = cuentaNeg.ListarCuentaxCliente(user_dni);
				ArrayList <Integer> listaCuotas=new ArrayList <Integer>(); ///***************************** LISTA PARA LAS CUOTAS PAGAS
				boolean updateprestamo=false;
				prestamo = prestamoN.datosPagoPrestamos(user_dni, nro_cuenta_prestamo);
				
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
				
				    request.setAttribute("listaCuentasUser", list);	
					request.setAttribute("DniUser", user_dni);
					request.setAttribute("DatosPrestamo", prestamoN.datosPagoPrestamos(user_dni, nro_cuenta_prestamo));
					
				///********************CARGA DE LA LISTA DE LAS CUOTAS PAGAS*****************
			   for(int i=1;i<=prestamo.getCuotas(); i++) {
				   int valor=movimientoNeg.contarPagoCuota(user_dni, i, prestamo.getId_prestamo());
				   listaCuotas.add(valor);
			   }
			   ///*********************** MUESTRA LA LISTA ***********************
			   for(int i=0;i<prestamo.getCuotas(); i++) {
				   if(listaCuotas.get(i)==1) {
					   contador++;
				   }
				   System.out.println("VALOR CUOTA "+i+": "+listaCuotas.get(i));
			   }
			   
			   if(prestamo.getCuotas()==contador) {
				   prestamosaldado=true;
			   }

			   if(prestamosaldado==true) {
				   
				   updateprestamo = prestamoN.prestamoSaldado(user_dni, nro_cuenta_prestamo_Datos, prestamo.getId_prestamo());
				   System.out.println("ESTADO DE UPDATE PRESTAMO: " + updateprestamo);
			   }
				request.setAttribute("arrayCuotas", listaCuotas); /// REQUEST DE LA LISTA CUOTAS
				
				if(prestamo.isAutorizado()==false || prestamo.isPendiente() == true || updateprestamo==true)
				{
					request.setAttribute("updateprestamo", updateprestamo);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/MensajesPrestamos.jsp");
					dispatcher.forward(request, response);
				}
				
				else {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/PagosPrestamosClientes.jsp");
				dispatcher.forward(request, response);
				}
				break;
			}
			case "ListadoPrestamos":
			{	
				request.setAttribute("listaPrestamos", prestamoN.ListarPrestamos());
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AutorizarPrestamosAdmin.jsp");
				dispatcher.forward(request, response);
				break;
			}
			case "listarTodosLosPrestamos":
			{
				request.setAttribute("listaTodosPrestamos", prestamoN.ListarTodosPrestamos());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarPrestamos.jsp");
				dispatcher.forward(request, response);
			}
				default:
				break;
			}
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("btnSolicitarPrestamo")!=null)
		{
			Prestamos prestamos = new Prestamos();
			Boolean registro = false;
			String user_dni;
			float interes=(float) 1.54;
			float importe_a_pagar = Float.parseFloat(request.getParameter("txtMonto").toString()) * interes;
			
			int cuotas = Integer.parseInt(request.getParameter("Cuotas").toString());
		
			
			float monto_mensual = importe_a_pagar/cuotas;
			
			
			
			
			String user = request.getSession().getAttribute("usuariolog").toString();
			user_dni = clienteNeg.Dni_de_Usuario(user).toString();
			
			
			ArrayList <Cuentas> list = cuentaNeg.ListarCuentaxCliente(user_dni);			
			request.setAttribute("listaCuentasUser", list);
			
			prestamos.setDni_prestamo(user_dni);
			prestamos.setNro_cuenta_p(Integer.parseInt(request.getParameter("ddlNroCuenta").toString()));  
			prestamos.setFecha_p(LocalDate.now());
			prestamos.setImporte_pedido(Float.parseFloat(request.getParameter("txtMonto").toString()));//es el importe que solicita el cliente
			prestamos.setCuotas(cuotas);
			prestamos.setPlazo("2022-01-01");
			prestamos.setImp_debe_pagar(importe_a_pagar); // segun el importe pedido se le multiplica un interes del 54% tomando de ejemplo un banco
			prestamos.setMonto_mensual(monto_mensual); // calcula lo que se calculo en el importe que se debe pagar dividido las cuotas solicitadas esto daria el importe a pagar por mes          
			prestamos.setPendiente(true);
			prestamos.setAutorizado(false);
			prestamos.setSaldado(false);
			
			registro = prestamoN.insertar(prestamos);
			
			request.setAttribute("RegistroExitoso", registro);
			System.out.println("REGISTRO PEDIDO DE PRESTAMO: " +registro);
			//request.setAttribute("listaMovimientos", list);	
			request.setAttribute("listaCuentasUser", cuentaNeg.ListarCuentaxCliente(user_dni));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/SolicitarPrestamosCliente.jsp");
			dispatcher.forward(request, response);
		}
		
		if (request.getParameter("btnAutorizar")!=null)
		{
			Movimientos movimiento=new Movimientos();
			String dni = request.getParameter("dniPrestamo");
			int nro_cuenta = Integer.parseInt(request.getParameter("NroCuentaPrestamo"));
			float saldo = Float.parseFloat(request.getParameter("Importe"));
			int idPrestamo = Integer.parseInt(request.getParameter("idPrestamo"));
			
			movimiento.setDni_movimiento(dni);
			movimiento.setNro_cuenta_movimiento(nro_cuenta);
			movimiento.setFecha_movimiento(LocalDate.now());
			movimiento.setDetalle("Autorizacion de prestamo aceptada"); /// VERIFICAR QUE PONEMOS ACA
			movimiento.setImporte(saldo);
			movimiento.setTipo_movimiento("Deposito");
			
			prestamoN.autorizarPrestamo(idPrestamo);
			cuentaNeg.actualizarSaldoCuenta(dni, nro_cuenta, saldo);
			movimientoNeg.registarMovimiento(movimiento);
			
			request.setAttribute("listaPrestamos", prestamoN.ListarPrestamos());
			System.out.println("BOTON AUTORIZAR");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AutorizarPrestamosAdmin.jsp");
			dispatcher.forward(request, response);
		}  
		
		
		if (request.getParameter("btnRechazar")!=null)
		{
			
			System.out.println("BOTON RECHAZAR");
			int idPrestamo = Integer.parseInt(request.getParameter("idPrestamo"));
			prestamoN.rechazarPrestamo(idPrestamo);
			request.setAttribute("listaPrestamos", prestamoN.ListarPrestamos());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AutorizarPrestamosAdmin.jsp");
			dispatcher.forward(request, response);
		}  
		
		if(request.getParameter("btnPagarCuotaPrestamo")!=null)
		{
	
			System.out.println("SERVLET PRESTAMO CON BOTON PAGAR");
			String user = request.getSession().getAttribute("usuariolog").toString();
			String user_dni;
			int nro_cuenta_prestamo = 0;
			int nro_cuenta_prestamo_Datos = 0;
			float montoCuota;
			boolean pagoExitoso = false;
			boolean pagoNoExitoso=true;
			boolean updateprestamo=false;
			 Prestamos prestamo = new Prestamos();
		
		
	
			user_dni = clienteNeg.Dni_de_Usuario(user).toString();
			nro_cuenta_prestamo = Integer.parseInt(request.getParameter("cuentassaldo"));
			
		    nro_cuenta_prestamo_Datos = prestamoN.cuentaPrestamo(user_dni);
			ArrayList <Cuentas> list = cuentaNeg.ListarCuentaxCliente(user_dni);
			
			
			
               prestamo =  prestamoN.datosPagoPrestamos(user_dni, nro_cuenta_prestamo_Datos);
			
			   montoCuota = prestamo.getMonto_mensual();
			   String numcuota=request.getParameter("rdbMontoCuota");///numero de cuota
			   
			   for(int a=0; a<list.size();a++) {
					
					if(list.get(a).getNumero_cuenta() == Integer.parseInt(request.getParameter("cuentassaldo"))) {
					
						if(montoCuota>list.get(a).getSaldo()) {
							
							request.setAttribute("listaCuentasUser", list);	
							request.setAttribute("DniUser", user_dni);
							request.setAttribute("DatosPrestamo", prestamoN.datosPagoPrestamos(user_dni, nro_cuenta_prestamo_Datos));
							ArrayList <Integer> listaCuotas=new ArrayList <Integer>();
							///********************CARGA DE LA LISTA DE LAS CUOTAS PAGAS*****************
							   for(int i=1;i<=prestamo.getCuotas(); i++) {
								   int valor=movimientoNeg.contarPagoCuota(user_dni, i, prestamo.getId_prestamo());
								   listaCuotas.add(valor);
							   }
							   
							request.setAttribute("pagoNoExitoso", pagoNoExitoso);
							request.setAttribute("arrayCuotas", listaCuotas); /// REQUEST DE LA LISTA CUOTAS
							RequestDispatcher dispatcher = request.getRequestDispatcher("/PagosPrestamosClientes.jsp");
							dispatcher.forward(request, response);
							
						}
						else {
							pagoExitoso =  prestamoN.pagoCuotaPrestamo(user_dni, nro_cuenta_prestamo, montoCuota); // SE REALIZA EL PAGO
							registrarMovimiento(user_dni,nro_cuenta_prestamo,montoCuota, numcuota,prestamo.getId_prestamo()); // SE REGISTRA EL MOVIMIENTO
							
							request.setAttribute("listaCuentasUser", list);	
							request.setAttribute("DniUser", user_dni);
							request.setAttribute("DatosPrestamo", prestamoN.datosPagoPrestamos(user_dni, nro_cuenta_prestamo_Datos));
							ArrayList <Integer> listaCuotas=new ArrayList <Integer>();
							///********************CARGA DE LA LISTA DE LAS CUOTAS PAGAS*****************
							   for(int i=1;i<=prestamo.getCuotas(); i++) {
								   int valor=movimientoNeg.contarPagoCuota(user_dni, i, prestamo.getId_prestamo());
								   listaCuotas.add(valor);
							   }
							   
							   ///*********************** MUESTRA LA LISTA ***********************
							   boolean prestamosaldado= false;
							   int contador=0;
							   for(int i=0;i<prestamo.getCuotas(); i++) {
								   
								   if(listaCuotas.get(i)==1) {
									   contador++;
								   }
								   System.out.println("VALOR CUOTA "+i+": "+listaCuotas.get(i));
							   }
							   
							   
							   if(prestamo.getCuotas()==contador) {
								   prestamosaldado=true;
							   }

							   if(prestamosaldado==true) {
								   
								   updateprestamo = prestamoN.prestamoSaldado(user_dni, nro_cuenta_prestamo_Datos, prestamo.getId_prestamo());
								   System.out.println("ESTADO DE UPDATE PRESTAMO: " + updateprestamo);
							   }
								request.setAttribute("arrayCuotas", listaCuotas); /// REQUEST DE LA LISTA CUOTAS
								
								if(prestamo.isAutorizado()==false || prestamo.isPendiente() == true || updateprestamo==true)
								{
									request.setAttribute("updateprestamo", updateprestamo);
									RequestDispatcher dispatcher = request.getRequestDispatcher("/MensajesPrestamos.jsp");
									dispatcher.forward(request, response);
								}
								else {
									request.setAttribute("PagoExitoso", pagoExitoso);
									RequestDispatcher dispatcher = request.getRequestDispatcher("/PagosPrestamosClientes.jsp");
									dispatcher.forward(request, response);
								}
						}
						
					}
					
					
					
				}
			   /*
			   	///DESDE ACA ES EL PAGO DE CUOTA VALIDO
				pagoExitoso =  prestamoN.pagoCuotaPrestamo(user_dni, nro_cuenta_prestamo, montoCuota); // SE REALIZA EL PAGO
				registrarMovimiento(user_dni,nro_cuenta_prestamo,montoCuota, numcuota,prestamo.getId_prestamo()); // SE REGISTRA EL MOVIMIENTO
				
				request.setAttribute("listaCuentasUser", list);	
				request.setAttribute("DniUser", user_dni);
				request.setAttribute("DatosPrestamo", prestamoN.datosPagoPrestamos(user_dni, nro_cuenta_prestamo_Datos));
				ArrayList <Integer> listaCuotas=new ArrayList <Integer>();
				///********************CARGA DE LA LISTA DE LAS CUOTAS PAGAS*****************
				   for(int i=1;i<=prestamo.getCuotas(); i++) {
					   int valor=movimientoNeg.contarPagoCuota(user_dni, i, prestamo.getId_prestamo());
					   listaCuotas.add(valor);
				   }
				   
				   ///*********************** MUESTRA LA LISTA ***********************
				   boolean prestamosaldado= false;
				   int contador=0;
				   for(int i=0;i<prestamo.getCuotas(); i++) {
					   
					   if(listaCuotas.get(i)==1) {
						   contador++;
					   }
					   System.out.println("VALOR CUOTA "+i+": "+listaCuotas.get(i));
				   }
				   
				   
				   if(prestamo.getCuotas()==contador) {
					   prestamosaldado=true;
				   }

				   if(prestamosaldado==true) {
					   
					   updateprestamo = prestamoN.prestamoSaldado(user_dni, nro_cuenta_prestamo_Datos, prestamo.getId_prestamo());
					   System.out.println("ESTADO DE UPDATE PRESTAMO: " + updateprestamo);
				   }
					request.setAttribute("arrayCuotas", listaCuotas); /// REQUEST DE LA LISTA CUOTAS
					
					if(prestamo.isAutorizado()==false || prestamo.isPendiente() == true || updateprestamo==true)
					{
						request.setAttribute("updateprestamo", updateprestamo);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/MensajesPrestamos.jsp");
						dispatcher.forward(request, response);
					}
					else {
						request.setAttribute("PagoExitoso", pagoExitoso);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/PagosPrestamosClientes.jsp");
						dispatcher.forward(request, response);
					}
					*/
	   }
}


	private void registrarMovimiento(String user_dni, int nro_cuenta, float montoCuota, String numerocuota, int idprestamo ) {
		
		String tipo_movimiento = "Extraccion";
		String detalle = "Pago de cuota "+numerocuota+" de prestamo "+idprestamo+" pedido";
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	
		
		Movimientos movimiento = new Movimientos();
		
		movimiento.setDni_movimiento(user_dni);
		movimiento.setNro_cuenta_movimiento(nro_cuenta);
		movimiento.setFecha_movimiento(LocalDate.now());
		movimiento.setDetalle(detalle);
		movimiento.setImporte(montoCuota);
		movimiento.setTipo_movimiento(tipo_movimiento);
		
		 movimientoNeg.registarMovimiento(movimiento);
	}

}