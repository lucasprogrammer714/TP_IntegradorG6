package DaoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Dao.ClienteDao;
import Entidad.Cliente;
//import datosImpl.Exception;
//import datosImpl.String;
import DaoImpl.Conexion;

public class ClienteDaoImpl implements ClienteDao {
	private static final String insert = "INSERT INTO Personas(DNI, cuil, nombre, apellido, sexo, nacionalidad, nacimiento, direccion, localidad, provincia, email, telefono, usuario, contrasena, admin, estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	@Override
	public boolean insertar(Cliente cliente) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try{
			
			statement = conexion.prepareStatement(insert);
			statement.setString(1, cliente.getDni());
			statement.setString(2, cliente.getCuil());
			statement.setString(3, cliente.getNombre());
			statement.setString(4, cliente.getApellido());
			statement.setString(5, cliente.getSexo());
			statement.setString(6, cliente.getNacionalidad());
			statement.setString(7, cliente.getNacimiento());
			statement.setString(8, cliente.getDireccion());
			statement.setString(9, cliente.getLocalidad());
			statement.setString(10, cliente.getProvincia());
			statement.setString(11, cliente.getEmail());
			statement.setString(12, cliente.getTelefono());
			statement.setString(12, cliente.getTelefono());
			statement.setString(13, cliente.getUsuario());
			statement.setString(14, cliente.getContraseña());
			statement.setBoolean(15, cliente.getAdministrador());
			statement.setBoolean(16, cliente.getEstado());
			
			if(statement.executeUpdate() > 0){
				conexion.commit();
				isInsertExitoso = true;
			}
		}
		catch (SQLException e) {
				///e.printStackTrace();
				
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				///e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}

	@Override
	public boolean editar(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean borrar(int dni) {
		// TODO Auto-generated method stub
		return false;
	}

	
	/*private static final String insert = "INSERT INTO Personas(DNI, cuil, usuario, contrasena, admin, estado) VALUES(?, ?, ?, ?, ?, ?)";
	
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
			statement.setString(3, cliente.getUsuario());
			statement.setString(4, cliente.getContraseña());
			statement.setBoolean(5, cliente.getAdministrador());
			statement.setBoolean(6, cliente.getEstado());
			
			if(statement.executeUpdate() > 0){
				conexion.commit();
				isInsertExitoso = true;
			}
		}
		catch (SQLException e) {
				///e.printStackTrace();
				
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				///e1.printStackTrace();
			}
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

	*/
	
}
