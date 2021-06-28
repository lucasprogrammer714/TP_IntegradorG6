package Dao;

import java.awt.List;

import Entidad.Cliente;


public interface ClienteDao {
	

public boolean insertar(Cliente cliente);
public boolean editar(Cliente cliente);
public boolean borrar(int dni);

	

}
