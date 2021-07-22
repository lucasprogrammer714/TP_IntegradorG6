package Dao;

import java.util.List;

import Entidad.Prestamos;

public interface PrestamosDao {
	
	public boolean insertar(Prestamos prestamos);
	public List<Prestamos> ListarPrestamos();
	public boolean autorizarPrestamo(String dni, int nrocuenta);
	

	
	

}
