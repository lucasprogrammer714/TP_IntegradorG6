package Entidad;

import java.time.LocalDate;
import java.util.Date;

public class Cuentas {

	
	private String dni_cuenta;
	private int numero_cuenta;
	private String cbu;
	private LocalDate creacion;
	private String tipo_cuenta;
	private float saldo;
	private boolean estado_cuenta;
	
	public Cuentas()
	{
		
	}

	public String getDni_cuenta() {
		return dni_cuenta;
	}

	public void setDni_cuenta(String dni_cuenta) {
		this.dni_cuenta = dni_cuenta;
	}

	public int getNumero_cuenta() {
		return numero_cuenta;
	}

	public void setNumero_cuenta(int numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

	
	
	public LocalDate getCreacion() {
		return creacion;
	}

	public void setCreacion(LocalDate creacion) {
		this.creacion = creacion;
	}

	public String getTipo_cuenta() {
		return tipo_cuenta;
	}

	public void setTipo_cuenta(String tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean getEstado_cuenta() {
		return estado_cuenta;
	}

	public void setEstado_cuenta(boolean estado_cuenta) {
		this.estado_cuenta = estado_cuenta;
	}
}
