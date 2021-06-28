package DaoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Dao.ClienteDao;
import Entidad.Cliente;
import DaoImpl.Conexion;

public class ClienteDaoImpl implements ClienteDao {

	private static final String insert = "INSERT INTO Personas(DNI, cuil, usuario, contrasena, admin, estado) VALUES(?, ?, ?, ?, ?, ?)";
	
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

	
	
}
