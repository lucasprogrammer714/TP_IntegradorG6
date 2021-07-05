package DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import Dao.CuentasDao;
import Entidad.Cuentas;
import DaoImpl.Conexion;


public class CuentasDaoImpl implements CuentasDao {

	
	private static final String query = "INSERT INTO cuentas (DNI_c, num_cuenta, CBU, creacion, tipo_cuenta, saldo, estado) VALUES (?,?,?,?,?,?,?)";
	
	@Override
	public boolean insertar(Cuentas cuenta) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean queryExitosa = false;
		
		try
		{
			
			System.out.println("USUARIO: " + cuenta.getDni_cuenta());
			System.out.println("N CUENTA: " + cuenta.getNumero_cuenta());
			System.out.println("CBU: " + cuenta.getCbu());
			System.out.println("FECHA: " + cuenta.getCreacion());
			System.out.println("TIPO CUENTA: " + cuenta.getTipo_cuenta());
			System.out.println("SALDO: " + cuenta.getSaldo());
			System.out.println("ESTADO: " + cuenta.getEstado_cuenta());
			
			statement = conexion.prepareStatement(query);
			statement.setString(1, cuenta.getDni_cuenta());
			statement.setInt(2, cuenta.getNumero_cuenta());
			statement.setString(3, cuenta.getCbu());
			statement.setString(4, cuenta.getCreacion().toString());
			statement.setString(5, cuenta.getTipo_cuenta());
			statement.setFloat(6, cuenta.getSaldo());
			statement.setBoolean(7, cuenta.getEstado_cuenta());
			

			if(statement.executeUpdate() > 0){
				conexion.commit();
				queryExitosa = true;
			}
		}
		
		catch(SQLException e)
		{
			///e.printStackTrace();

		}
		
		try {
			conexion.rollback();
		} catch (SQLException e1) {
			///e1.printStackTrace();
		}
	
		return queryExitosa;
		
		
	}
	
	
	
	
	

	@Override
	public boolean borrarCuenta(int nro_cuenta) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
	
		//String query = "UPDATE cuentas SET estado = 0 WHERE num_cuenta='"+ nro_cuenta+"'";
		
		PreparedStatement st;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean deleteExitoso = false;
		
		try {
			  
			st = conexion.prepareCall("Call bajaCuenta (?)");
			st.setString(1, Integer.toString(nro_cuenta));
			
			if (st.executeUpdate()>0)
			{
				conexion.commit();
				deleteExitoso = true;
			}
			
		} catch (SQLException e3)
		{
			e3.printStackTrace();
		}
		
		
		return deleteExitoso;
	}






	@Override
	public int buscar_una_cuenta(int nro_cuenta) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		  Connection cn = Conexion.getConexion().getSQLConexion();
		  	
		  	int cuentaEncontrada=0;
	    		String query = "SELECT num_cuenta FROM cuentas WHERE num_cuenta ='" + nro_cuenta+"'";
	    		Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery(query);
				if(rs.next()) {
					cuentaEncontrada=1;
				}
				System.out.println(cuentaEncontrada);
				return cuentaEncontrada;
	}






	@Override
	public List<Cuentas> ListarCuentas() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		List<Cuentas> lc = new ArrayList<Cuentas>();
		Connection cn = Conexion.getConexion().getSQLConexion();
		try{
			String query2 ="SELECT * FROM cuentas"; //String sql = "SELECT * FROM cuentas";
			Statement st = cn.createStatement(); //PreparedStatement pstm = Conexion.prepareStatement(query);
			ResultSet rs = st.executeQuery(query2);//ResultSet rs = pstm.executeQuery();
			while (rs.next())
			{
				rs.getString(1);  //String dni = rs.getString(1);
				rs.getInt(2);  //int num_cuenta  = rs.getInt(2);
				rs.getString(3);  //String cbu = rs.getString(3);
				LocalDate.parse(rs.getString(4).toString()); //LocalDate creacion =(LocalDate.parse(rs.getString(4).toString()));rs.getString(4); //revisar si es correcto
				rs.getString(5);  //String tipo_cuenta = rs.getString(5);
				rs.getFloat(6);  //Float saldo = rs.getFloat(6);
				rs.getBoolean(7);  //Boolean estado = rs.getBoolean(7);
				
				Cuentas cuenta = new Cuentas(); // sino crear un constructor con los datos
				lc.add(cuenta);
			}

		} catch (Exception e) {
		}
		return lc;	}
}