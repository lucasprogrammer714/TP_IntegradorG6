package Negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.Cliente;

public interface ClienteNeg {
	
	
	public boolean borrar (int dni);
	public boolean insertar(Cliente cliente);
	public boolean cambiar_contrasena (String nombreUsuario, String contrasena) throws SQLException;
	public int buscar_un_cliente(int dni)throws SQLException;
	public int buscarUsuario(String usuario, String contraseņa) throws SQLException;
	public int buscarNombreUsuarioCliente(String usuario);
	public ArrayList<Cliente> obtenerClientes();
}
