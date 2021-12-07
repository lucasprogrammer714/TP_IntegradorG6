package Dao;

import java.util.List;

import Entidad.Prestamos;

public interface PrestamosDao {
	
	public boolean insertar(Prestamos prestamos);
	public List<Prestamos> ListarPrestamos();
	public boolean autorizarPrestamo(int idPrestamo);
	public boolean rechazarPrestamo(int idPrestamo);
	public Prestamos  datosPagoPrestamo (String dni, int nrocuent);
	public int cuentaPrestamo (String dni_p);
	public boolean pagoCuotaPrestamo (String dni_c, int nroCuenta, float montoCuota);
	public int contarPrestamo(String dni);
	public boolean prestamoSaldado(String dni_p, int nroCuenta_p, int id_p);
}
