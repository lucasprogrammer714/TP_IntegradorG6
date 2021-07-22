package Negocio;

import java.util.List;

import Entidad.Prestamos;

public interface PrestamosNeg {
	public boolean insertar (Prestamos prestamos);
	public List<Prestamos> ListarPrestamos();
	public boolean autorizarPrestamos(String dni, int nrocuenta);
	


}
