package Entidad;

public class Movimientos {
	
	private String dni_movimiento;
	private int nro_cuenta_movimiento;
	private int id_movimiento;
	private String fecha_movimiento;
	private String detalle;
	private float importe;
	private String tipo_movimiento;
	
	
	public Movimientos()
	{
		
	}


	public String getDni_movimiento() {
		return dni_movimiento;
	}


	public void setDni_movimiento(String dni_movimiento) {
		this.dni_movimiento = dni_movimiento;
	}


	public int getNro_cuenta_movimiento() {
		return nro_cuenta_movimiento;
	}


	public void setNro_cuenta_movimiento(int nro_cuenta_movimiento) {
		this.nro_cuenta_movimiento = nro_cuenta_movimiento;
	}


	public int getId_movimiento() {
		return id_movimiento;
	}


	public void setId_movimiento(int id_movimiento) {
		this.id_movimiento = id_movimiento;
	}


	public String getFecha_movimiento() {
		return fecha_movimiento;
	}


	public void setFecha_movimiento(String fecha_movimiento) {
		this.fecha_movimiento = fecha_movimiento;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	public float getImporte() {
		return importe;
	}


	public void setImporte(float importe) {
		this.importe = importe;
	}


	public String getTipo_movimiento() {
		return tipo_movimiento;
	}


	public void setTipo_movimiento(String tipo_movimiento) {
		this.tipo_movimiento = tipo_movimiento;
	}
	
	
	

}
