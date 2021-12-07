package Negocio;

import java.util.List;

import Entidad.Prestamos;

public interface PrestamosNeg {
	public boolean insertar (Prestamos prestamos);
	public List<Prestamos> ListarPrestamos();
	public boolean autorizarPrestamo(int idPrestamo);
	public boolean rechazarPrestamo(int idPrestamo);
	public Prestamos datosPagoPrestamos(String dni, int nro_cuenta);
	public int cuentaPrestamo (String dni_p);
	public boolean pagoCuotaPrestamo(String dni_c, int num_cuenta, float montoCuota);
	public int contarPrestamo(String dni);
	public boolean prestamoSaldado(String dni_p, int nroCuenta_p, int id_p);

}
