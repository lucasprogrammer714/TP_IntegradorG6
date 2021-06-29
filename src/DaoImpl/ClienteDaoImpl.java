package DaoImpl;
import java.sql.Connection;
import java.sql.Date;
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
	
	
	private static final String insert = "INSERT INTO clientes(DNI, cuil, nombre, apellido, sexo, nacionalidad, nacimiento, direccion, localidad, provincia, email, telefono, usuario, contrasena, admin, estado, telefono_fijo) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public boolean insertar(Cliente cliente) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try{
			
			
			//System.out.println("DNI: " + cliente.getDni().toString());
			//System.out.println("CUIL: " + cliente.getCuil().toString());
			//System.out.println("NOMBRE: " + cliente.getNombre());
			//System.out.println("APELLIDO: " + cliente.getApellido().toString());
			//System.out.println("SEXO: " + cliente.getSexo().toString());
			//System.out.println("NACIONALIDAD: " + cliente.getNacionalidad().toString());
			//System.out.println("NACIMIENTO" + cliente.getNacimiento());
			//System.out.println("DIRECCION: " + cliente.getDireccion().toString());
			//System.out.println("LOCALIDAD: " + cliente.getLocalidad().toString());
			//System.out.println("PROVINCIA: " + cliente.getProvincia().toString());
			//System.out.println("EMAIL: " + cliente.getEmail().toString());
			//System.out.println("TELEFONO: " + cliente.getTelefono().toString());
			//System.out.println("USUARIO: " + cliente.getUsuario().toString());
			//System.out.println(cliente.toString());
			//System.out.println(cliente.toString());
			statement = conexion.prepareStatement(insert);
			statement.setString(1, cliente.getDni());
			statement.setString(2, cliente.getCuil());
			statement.setString(3, cliente.getNombre());
			statement.setString(4, cliente.getApellido());
			statement.setString(5, cliente.getSexo());
			statement.setString(6, cliente.getNacionalidad());
			statement.setDate(7,(Date) cliente.getNacimiento());
			statement.setString(8, cliente.getDireccion());
			statement.setString(9, cliente.getLocalidad());
			statement.setString(10, cliente.getProvincia());
			statement.setString(11, cliente.getEmail());
			statement.setString(12, cliente.getTelefono());
			statement.setString(13, cliente.getUsuario());
			statement.setString(14, cliente.getContraseña());
			statement.setBoolean(15, cliente.getAdministrador());
			statement.setBoolean(16, cliente.getEstado());
			statement.setString(17, cliente.getTelefono_fijo());
			
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
