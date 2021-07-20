package DaoImpl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

///mport com.mysql.cj.xdevapi.Statement;

import Dao.ClienteDao;
import Entidad.Cliente;
import DaoImpl.Conexion;

public class ClienteDaoImpl implements ClienteDao {

	

	
	
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
			
			
			statement = conexion.prepareStatement(insert);
			statement.setString(1, cliente.getDni());
			statement.setString(2, cliente.getCuil());
			statement.setString(3, cliente.getNombre());
			statement.setString(4, cliente.getApellido());
			statement.setString(5, cliente.getSexo());
			statement.setString(6, cliente.getNacionalidad());
			statement.setString(7, cliente.getNacimiento().toString());
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
	
	

	


	public boolean borrar(int dni) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareCall("Call bajaCliente (?)");
			statement.setString(1, Integer.toString(dni));
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	public int buscar_un_cliente(int dni) throws SQLException{

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		  Connection cn = Conexion.getConexion().getSQLConexion();
		  	
		  	int clienteEncontrado=0;
	    		String query = "SELECT DNI FROM clientes WHERE DNI ='" + dni+"'";
	    		Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery(query);
				if(rs.next()) {
					clienteEncontrado=1;
				}
				///System.out.println(clienteEncontrado);
				return clienteEncontrado;
	}
	
	
	
	
	public int buscarUsuario(String usuario, String contraseña) throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		Connection conexion = Conexion.getConexion().getSQLConexion();
		Statement statement =conexion.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM Clientes WHERE usuario='" + usuario + "' AND contrasena='" + contraseña+"'");
		if(rs.next()) {
			boolean admin = rs.getBoolean("admin");
			if(admin==true) {
				return 1;
			}
			else {
				return 2;
			}
		}
		
		else {
			return 3;
		}
		
	}


	@Override
	public boolean cambiar_contrasena(String nombreUsuario, String contrasena) throws SQLException {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		
		PreparedStatement statement;

		Connection conectar = Conexion.getConexion().getSQLConexion();
		boolean cambioExitoso = false;
		
		try {
			
			statement = conectar.prepareCall("Call cambioContraseña (?,?)");
			statement.setString(1, contrasena);
			statement.setString(2, nombreUsuario);
			
			if (statement.executeUpdate()>0)
			{
				conectar.commit();
				cambioExitoso = true;
				
			}
			
		}
		catch(SQLException e)
		{
		   e.printStackTrace();	
		}
		
		
		
		return cambioExitoso;
	}




	@Override
	public int buscarNombreUsuarioCliente(String usuario) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		//System.out.println("USUARIO: " + usuario);
		//String dni="";

		Connection conexion = Conexion.getConexion().getSQLConexion();
		Statement statement;
               int userEncontrado = 0;
		try {
			statement = conexion.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM Clientes WHERE usuario='" + usuario+"'");
			if(rs.next()) {
				
				userEncontrado = 1;
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userEncontrado;
	}

	public List<Cliente> listarClientes() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="SELECT clientes.DNI, clientes.cuil, clientes.nombre, clientes.apellido, clientes.sexo, clientes.nacionalidad, clientes.nacimiento, clientes.direccion, clientes.localidad, clientes.provincia, clientes.email, clientes.telefono, clientes.usuario, clientes.contrasena, clientes.admin, clientes.telefono_fijo, clientes.estado From clientes ";
		List<Cliente> lista = new ArrayList<Cliente>();
		try{
			
			Connection conexion = Conexion.getConexion().getSQLConexion();
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			
			
			while(rs.next()){
				
				Cliente usuarioRs = new Cliente();
				usuarioRs.setDni(rs.getString("clientes.DNI"));
				usuarioRs.setCuil(rs.getString("clientes.cuil"));
				usuarioRs.setNombre(rs.getString("clientes.nombre"));
				usuarioRs.setApellido(rs.getString("clientes.apellido"));
				usuarioRs.setSexo(rs.getString("clientes.sexo"));
				usuarioRs.setNacionalidad(rs.getString("clientes.nacionalidad"));
				usuarioRs.setNacimiento(rs.getDate("clientes.nacimiento").toLocalDate());
				usuarioRs.setDireccion(rs.getString("clientes.direccion"));
				usuarioRs.setLocalidad(rs.getString("clientes.localidad"));
				usuarioRs.setProvincia(rs.getString("clientes.provincia"));
				usuarioRs.setEmail(rs.getString("clientes.email"));
				usuarioRs.setTelefono(rs.getString("clientes.telefono"));
				usuarioRs.setUsuario(rs.getString("clientes.usuario"));
				usuarioRs.setContraseña(rs.getString("clientes.contrasena"));
				usuarioRs.setAdministrador(rs.getBoolean("clientes.admin"));
				usuarioRs.setTelefono_fijo(rs.getString("clientes.telefono_fijo"));
				usuarioRs.setEstado(rs.getBoolean("clientes.estado"));
				lista.add(usuarioRs);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}



	
	public String Dni_de_Usuario(String usuario) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        //System.out.println("USUARIO: " + usuario);
        String dni="";
        Connection conexion = Conexion.getConexion().getSQLConexion();
        Statement statement;
        try {
            statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Clientes WHERE usuario='" + usuario+"'");
            if(rs.next()) {
                System.out.println("RESULTADO: " + rs.getString("DNI"));
                dni=rs.getString("DNI");
            }
            System.out.println("DNICLIENTE: " + dni);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dni;
    }

	

	/*@Override
	public String Dni_de_Usuario(String user) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}	
		
		
		String dni = "";
		
		Connection conectar = Conexion.getConexion().getSQLConexion();
		Statement st = conectar.createStatement();
		String query = "SELECT * FROM clientes WHERE usuario = ' "+user+"'";
		ResultSet rs = st.executeQuery(query);
		
		
		System.out.println("DNI cliente: " + user);
		
		if(rs.next())
		{
			
			dni = rs.getString("DNI");
			System.out.println("DNI cliente: " + dni);
			
		}
		
		
		return dni;
	}*/
	
	
	public List<Cliente> listarClientesBusqueda(String Busqueda) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="SELECT *\r\n" + 
				"FROM clientes\r\n" + 
				"WHERE `DNI` LIKE concat('%', '"+Busqueda+"' , '%')\r\n" + 
				"OR `cuil` LIKE concat('%', '"+Busqueda+"' , '%')\r\n" + 
				"OR `nombre` LIKE concat('%', '"+Busqueda+"' , '%')\r\n" + 
				"OR `apellido` LIKE concat('%', '"+Busqueda+"' , '%')\r\n" + 
				"OR `sexo` LIKE concat('%', '"+Busqueda+"' , '%')\r\n" + 
				"OR `nacionalidad` LIKE concat('%', '"+Busqueda+"' , '%')\r\n" + 
				"OR `direccion` LIKE concat('%', '"+Busqueda+"' , '%')\r\n" + 
				"OR `localidad` LIKE concat('%', '"+Busqueda+"' , '%')\r\n" + 
				"OR `provincia` LIKE concat('%', '"+Busqueda+"' , '%')\r\n" + 
				"OR `email` LIKE concat('%', '"+Busqueda+"' , '%')\r\n" + 
				"OR `telefono` LIKE concat('%', '"+Busqueda+"' , '%')\r\n" + 
				"OR `usuario` LIKE concat('%', '"+Busqueda+"' , '%') ";
		List<Cliente> lista = new ArrayList<Cliente>();
		try{
			
			Connection conexion = Conexion.getConexion().getSQLConexion();
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			
			
			while(rs.next()){
				
				Cliente usuarioRs = new Cliente();
				usuarioRs.setDni(rs.getString("clientes.DNI"));
				usuarioRs.setCuil(rs.getString("clientes.cuil"));
				usuarioRs.setNombre(rs.getString("clientes.nombre"));
				usuarioRs.setApellido(rs.getString("clientes.apellido"));
				usuarioRs.setSexo(rs.getString("clientes.sexo"));
				usuarioRs.setNacionalidad(rs.getString("clientes.nacionalidad"));
				usuarioRs.setNacimiento(rs.getDate("clientes.nacimiento").toLocalDate());
				usuarioRs.setDireccion(rs.getString("clientes.direccion"));
				usuarioRs.setLocalidad(rs.getString("clientes.localidad"));
				usuarioRs.setProvincia(rs.getString("clientes.provincia"));
				usuarioRs.setEmail(rs.getString("clientes.email"));
				usuarioRs.setTelefono(rs.getString("clientes.telefono"));
				usuarioRs.setUsuario(rs.getString("clientes.usuario"));
				usuarioRs.setContraseña(rs.getString("clientes.contrasena"));
				usuarioRs.setAdministrador(rs.getBoolean("clientes.admin"));
				usuarioRs.setTelefono_fijo(rs.getString("clientes.telefono_fijo"));
				usuarioRs.setEstado(rs.getBoolean("clientes.estado"));
				lista.add(usuarioRs);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}
	
	
	public List<Cliente> listarClientesFiltro(String fechainicio, String fechafin) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="SELECT * FROM clientes WHERE nacimiento>= '" +fechainicio+"' AND nacimiento <= '" + fechafin+"'";
		List<Cliente> lista = new ArrayList<Cliente>();
		try{
			
			Connection conexion = Conexion.getConexion().getSQLConexion();
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql); 
			
			
			while(rs.next()){
				
				Cliente usuarioRs = new Cliente();
				usuarioRs.setDni(rs.getString("clientes.DNI"));
				usuarioRs.setCuil(rs.getString("clientes.cuil"));
				usuarioRs.setNombre(rs.getString("clientes.nombre"));
				usuarioRs.setApellido(rs.getString("clientes.apellido"));
				usuarioRs.setSexo(rs.getString("clientes.sexo"));
				usuarioRs.setNacionalidad(rs.getString("clientes.nacionalidad"));
				usuarioRs.setNacimiento(rs.getDate("clientes.nacimiento").toLocalDate());
				usuarioRs.setDireccion(rs.getString("clientes.direccion"));
				usuarioRs.setLocalidad(rs.getString("clientes.localidad"));
				usuarioRs.setProvincia(rs.getString("clientes.provincia"));
				usuarioRs.setEmail(rs.getString("clientes.email"));
				usuarioRs.setTelefono(rs.getString("clientes.telefono"));
				usuarioRs.setUsuario(rs.getString("clientes.usuario"));
				usuarioRs.setContraseña(rs.getString("clientes.contrasena"));
				usuarioRs.setAdministrador(rs.getBoolean("clientes.admin"));
				usuarioRs.setTelefono_fijo(rs.getString("clientes.telefono_fijo"));
				usuarioRs.setEstado(rs.getBoolean("clientes.estado"));
				lista.add(usuarioRs);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return lista;
	}
	
	

}	
