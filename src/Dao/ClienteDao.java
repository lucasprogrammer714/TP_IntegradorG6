package Dao;

import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.Cliente;


public interface ClienteDao {
	

public boolean insertar(Cliente cliente);

public boolean cambiar_contrasena(String nombreUsuario, String contrasena) throws SQLException;
public boolean borrar(int dni);

public int buscar_un_cliente(int dni) throws SQLException;
public int buscarUsuario(String usuario, String contrase�a) throws SQLException;
public int buscarNombreUsuarioCliente (String usuario);
public String Dni_de_Usuario (String user);
public List<Cliente> listarClientes();
public List<Cliente> listarClientesBusqueda(String Busqueda);
public List<Cliente> listarClientesFiltro(String fechainicio, String fechafin);
}
