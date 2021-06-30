package Dao;

import java.awt.List;
import java.sql.SQLException;

import Entidad.Cliente;


public interface ClienteDao {
	

public boolean insertar(Cliente cliente);
public boolean editar(Cliente cliente);
public boolean borrar(int dni);
public int buscarUsuario(String usuario, String contrase�a) throws SQLException;

	

}
