package Dao;

import java.awt.List;
import java.sql.SQLException;

import Entidad.Cliente;


public interface ClienteDao {
	

public boolean insertar(Cliente cliente);

public boolean cambiar_contrasena(String nombreUsuario, String contrasena) throws SQLException;
public boolean borrar(int dni);

public int buscar_un_cliente(int dni) throws SQLException;
public int buscarUsuario(String usuario, String contraseña) throws SQLException;
public int buscarNombreUsuarioCliente (String usuario);
	

}
