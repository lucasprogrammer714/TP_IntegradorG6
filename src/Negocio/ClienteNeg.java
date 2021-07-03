package Negocio;

import java.sql.SQLException;

import Entidad.Cliente;

public interface ClienteNeg {
	
	
	
	public boolean insertar(Cliente cliente);
	public boolean borrar (int dni);
	public int buscar_un_cliente(int dni)throws SQLException;
	public int buscarUsuario(String usuario, String contraseña) throws SQLException;

}
