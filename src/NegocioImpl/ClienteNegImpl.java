package NegocioImpl;

import java.sql.SQLException;

import Dao.ClienteDao;
import DaoImpl.ClienteDaoImpl;
import Entidad.Cliente;
import Negocio.ClienteNeg;

public class ClienteNegImpl implements ClienteNeg {
	
	
	
	private ClienteDao clienteDao = new ClienteDaoImpl();
	
	
	public boolean insertar (Cliente cliente)
	{
		return clienteDao.insertar(cliente);
	}


	public boolean borrar(int dni) {
		
		return clienteDao.borrar(dni);
	}


	@Override
	public int buscar_un_cliente(int dni) throws SQLException {
	return clienteDao.buscar_un_cliente(dni);
	}
	
	
	public int buscarUsuario(String usuario, String contraseña) throws SQLException {
		
		return clienteDao.buscarUsuario(usuario, contraseña);
	}


	@Override
	public boolean cambiar_contrasena(String nombreUsuario, String contrasena) throws SQLException {
		
		return clienteDao.cambiar_contrasena(nombreUsuario, contrasena);
	}


	@Override
	public int buscarNombreUsuarioCliente(String usuario) {
	
		return clienteDao.buscarNombreUsuarioCliente(usuario);
	}
	
	
	

}
