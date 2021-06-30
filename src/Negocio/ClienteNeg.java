package Negocio;

import java.sql.SQLException;

import Entidad.Cliente;

public interface ClienteNeg {
	
	
	
	public boolean insertar(Cliente cliente);
	public int buscarUsuario(String usuario, String contraseña) throws SQLException;

}
