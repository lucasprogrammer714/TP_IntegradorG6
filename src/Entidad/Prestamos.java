package Entidad;

import java.time.LocalDate;
import java.util.Date;

public class Prestamos {
	
	private String dni_prestamo;
	private int nro_cuenta_p;
	private int id_prestamo;
	private LocalDate fecha_p;
	private float imp_debe_pagar;
	private float importe_pedido;
	private String plazo;
	private float monto_mensual;
	private int cuotas;
	
	
	public Prestamos()
	{
		
	}


	public String getDni_prestamo() {
		return dni_prestamo;
	}


	public void setDni_prestamo(String dni_prestamo) {
		this.dni_prestamo = dni_prestamo;
	}


	public int getNro_cuenta_p() {
		return nro_cuenta_p;
	}


	public void setNro_cuenta_p(int nro_cuenta_p) {
		this.nro_cuenta_p = nro_cuenta_p;
	}


	public int getId_prestamo() {
		return id_prestamo;
	}


	public void setId_prestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
	}


	public LocalDate getFecha_p() {
		return fecha_p;
	}


	public void setFecha_p(LocalDate fecha_p) {
		this.fecha_p = fecha_p;
	}


	public float getImp_debe_pagar() {
		return imp_debe_pagar;
	}


	public void setImp_debe_pagar(float imp_debe_pagar) {
		this.imp_debe_pagar = imp_debe_pagar;
	}


	public float getImporte_pedido() {
		return importe_pedido;
	}


	public void setImporte_pedido(float importe_pedido) {
		this.importe_pedido = importe_pedido;
	}


	public String getPlazo() {
		return plazo;
	}


	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}


	public float getMonto_mensual() {
		return monto_mensual;
	}


	public void setMonto_mensual(float monto_mensual) {
		this.monto_mensual = monto_mensual;
	}


	public int getCuotas() {
		return cuotas;
	}


	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}
	
	

}
