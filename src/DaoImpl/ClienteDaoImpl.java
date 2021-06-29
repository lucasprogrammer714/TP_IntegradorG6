package DaoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Dao.ClienteDao;
import Entidad.Cliente;
import DaoImpl.Conexion;

public class ClienteDaoImpl implements ClienteDao {

	
	//Estuve haciendo pruebas y por eso hice cambios. Pensaba mejor hacer un sp para esta parte porque son muchos
	// campos. Y saque varios para probar. 
	
	
	// Esto puse de lo que encontre sobre manejar la fecha 
	/// iria en servletCliente --setFechaNacimiento(Date.valueOf(request.getParameter("dateFechaNacimiento")));
	
	
	private static final String insert = "INSERT INTO clientes(DNI, cuil, nombre, apellido) VALUES(?, ?, ?,?)";
	
	public boolean insertar(Cliente cliente) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try{
			
			
			
			statement = conexion.prepareStatement(insert);
			statement.setString(1, cliente.getDni());
			statement.setString(2, cliente.getCuil());
			statement.setString(3, cliente.getNombre());
			statement.setString(4, cliente.getApellido());
			/*statement.setString(5, cliente.getSexo());
			statement.setString(6, cliente.getNacionalidad());
			statement.setString(7, cliente.getDireccion());
			statement.setString(8, cliente.getLocalidad());
			statement.setString(9, cliente.getProvincia());
			statement.setString(10, cliente.getEmail());
			statement.setString(11, cliente.getTelefono());
			
			statement.setString(12, cliente.getUsuario());
			statement.setString(13, cliente.getContraseña());
			statement.setBoolean(14, cliente.getAdministrador());
			statement.setBoolean(15, cliente.getEstado());
			statement.setString(16, cliente.getTelefono_fijo());*/
			
			if(statement.executeUpdate() > 0){
				conexion.commit();
				isInsertExitoso = true;
			}
		}
		catch (SQLException e) {
			
		
		///e.printStackTrace();
		}
				
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				///e1.printStackTrace();
			}
		
		
		return isInsertExitoso;

	}

	
	public boolean editar(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean borrar(int dni) {
		// TODO Auto-generated method stub
		return false;
	}

	
	}	
