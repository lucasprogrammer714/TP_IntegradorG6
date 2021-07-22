package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dao.PrestamosDao;
import Entidad.Prestamos;

public class PrestamosDaoImpl implements PrestamosDao {
	
	private static final String insert = "INSERT INTO Prestamos(DNI_p, num_cuenta_p, fecha_p, imp_debe_pagar, imp_pedido, plazo, monto_mensual, cuotas, pendiente, autorizado) VALUES(?,?,?,?,?,?,?,?,?,?)";

	@Override
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
					statement.setString(6, prestamos.getPlazo().toString());
					statement.setFloat(7, prestamos.getMonto_mensual());
					statement.setInt(8, prestamos.getCuotas());
					statement.setBoolean(9, prestamos.isPendiente());
					statement.setBoolean(10, prestamos.isAutorizado());
					
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

	@Override
	public List<Prestamos> ListarPrestamos() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();

		}
		
		
		String sql = "SELECT DNI_p, num_cuenta_p, id_p, imp_debe_pagar, imp_pedido FROM prestamos";
		List<Prestamos> listap = new ArrayList<Prestamos>();
		
		try{
				
			Connection conexion = Conexion.getConexion().getSQLConexion();	
			Statement st = conexion.createStatement();
	        ResultSet rs = st.executeQuery(sql);
	        
	        while (rs.next())
	        {
	        	Prestamos presta = new Prestamos();
	        	presta.setDni_prestamo(rs.getString("DNI_p"));
	        	presta.setNro_cuenta_p(rs.getInt("num_cuenta_p"));
	        	presta.setImp_debe_pagar(rs.getFloat("imp_debe_pagar"));
	        	presta.setImporte_pedido(rs.getFloat("imp_pedido"));
	        	
	        	listap.add(presta);
	        }
				
				
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	return listap;
	}

	@Override
	public boolean autorizarPrestamo(String dni, int nrocuenta) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();

		}
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean updateExitoso = false;
		
		try {
			
			
			ps = conexion.prepareCall("Call autorizarPrestamo (?,?)");
			ps.setString(1, dni);
			ps.setInt(2, nrocuenta);
			
			if (ps.executeUpdate()>0)
			{
				conexion.commit();
				updateExitoso = true;
			}
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		return updateExitoso;
	}
	

	

}
