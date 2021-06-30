package DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			statement.setDate(4, (Date) cuenta.getCreacion());
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
}