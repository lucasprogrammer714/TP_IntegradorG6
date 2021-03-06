package Negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidad.Cliente;

public interface ClienteNeg {
	
	
	public boolean borrar (int dni);
	public boolean insertar(Cliente cliente);
	public boolean cambiar_contrasena (String nombreUsuario, String contrasena) throws SQLException;
	public int buscar_un_cliente(String dni) throws SQLException;
	public int buscarUsuario(String usuario, String contraseņa) throws SQLException;
	public int buscarNombreUsuarioCliente(String usuario);
	public String Dni_de_Usuario(String user);
	public List<Cliente> listarClientes();
	public List<Cliente> listarClientesBusqueda(String Busqueda);
	public List<Cliente> listarClientesFiltro(String fechainicio, String fechafin);
	public Cliente obtenerdatoscliente(String dni);
}
