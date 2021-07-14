package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Dao.PrestamosDao;
import Entidad.Prestamos;


public class PrestamosDaoImpl implements PrestamosDao {
	
	private static final String insert = "INSERT INTO Prestamos(DNI_p, num_cuenta_p, fecha_p, imp_debe_pagar, imp_pedido, plazo, monto_mensual, cuotas, pendiente, autorizado) VALUES(?,?,?,?,?,?,?,?,?,?)";

	public boolean insertar(Prestamos prestamos) {
		
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
				
				statement.setString(1, prestamos.getDni_prestamo());
				statement.setInt(2, prestamos.getNro_cuenta_p());
				statement.setString(3, prestamos.getFecha_p().toString());
				statement.setFloat(4, prestamos.getImp_debe_pagar());
				statement.setFloat(5, prestamos.getImporte_pedido());
				statement.setString(6, prestamos.getPlazo() .toString());
				statement.setFloat(7, prestamos.getMonto_mensual());
				statement.setInt(8, prestamos.getCuotas());
				statement.setBoolean(9, prestamos.getPendiente());
				statement.setBoolean(10, prestamos.getAutorizado());
				
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

}
