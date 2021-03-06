package NegocioImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public int buscar_un_cliente(String dni) throws SQLException  {
	return clienteDao.buscar_un_cliente(dni);
	}
	
	
	public int buscarUsuario(String usuario, String contraseņa) throws SQLException {
		
		return clienteDao.buscarUsuario(usuario, contraseņa);
	}


	@Override
	public boolean cambiar_contrasena(String nombreUsuario, String contrasena) throws SQLException {
		
		return clienteDao.cambiar_contrasena(nombreUsuario, contrasena);
	}


	@Override
	public int buscarNombreUsuarioCliente(String usuario) {
	
		return clienteDao.buscarNombreUsuarioCliente(usuario);
	}
	
	
	public List<Cliente> listarClientes(){
        return clienteDao.listarClientes();  
    }


	@Override
	public String Dni_de_Usuario(String user) {
		// TODO Auto-generated method stub
		return clienteDao.Dni_de_Usuario(user);
	}

	public List<Cliente> listarClientesBusqueda(String Busqueda){
		return clienteDao.listarClientesBusqueda(Busqueda);
	}
	
	public List<Cliente> listarClientesFiltro(String fechainicio, String fechafin){
		return clienteDao.listarClientesFiltro(fechainicio, fechafin);
	}

	public Cliente obtenerdatoscliente(String dni) {
		return clienteDao.obtenerdatoscliente(dni);
	}
	
	
	
}
