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


	public int buscarUsuario(String usuario, String contraseña) throws SQLException {
		
		return clienteDao.buscarUsuario(usuario, contraseña);
	}
	
	
	

}
