package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dao.MovimientosDao;
import Entidad.Movimientos;

public class MovimientosDaoImpl implements MovimientosDao {
	
	 private static final String insert = "INSERT INTO movimientos (DNI_m, num_cuenta_m, fecha_m, detalle, importe, tipo_movimiento) VALUES (?,?,?,?,?,?)";

	@Override
	public boolean registrarMovimiento(Movimientos move) {
		
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			
		 
		 PreparedStatement ps;
		 Connection conectar_a_bd = Conexion.getConexion().getSQLConexion();
		 boolean movimientoRegistrado = false;
		 
		 try {
			 
			 ps = conectar_a_bd.prepareStatement(insert);
			 ps.setString(1, move.getDni_movimiento());
			 ps.setInt(2, move.getNro_cuenta_movimiento());
			 ps.setString(3, move.getFecha_movimiento().toString());
			 ps.setString(4, move.getDetalle());
			 ps.setFloat(5, move.getImporte());
			 ps.setString(6, move.getTipo_movimiento());
			 
			 if (ps.executeUpdate()>0)
				 
			 {
				 conectar_a_bd.commit();
				 movimientoRegistrado =true;
			 }
			 
			 
		 }
		 catch (SQLException e) {
				
				
				e.printStackTrace();
				} 
		 
		 
		return movimientoRegistrado;
	}

	@Override
	public List<Movimientos> Listar_movimientos_por_cuenta(String dni, int ncuenta) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();

		}
		
	
		
		String sql = "SELECT * FROM movimientos WHERE DNI_m = '"+dni+"' AND num_cuenta_m = '" +ncuenta+"'";
		
		List<Movimientos> lista_movixcuenta = new ArrayList<Movimientos>();
		
		try{
			
		Connection conexion = Conexion.getConexion().getSQLConexion();
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(sql); 
		
		while (rs.next())
		{
			//Cliente cliente = new Cliente();
			Movimientos movimiento = new Movimientos() ;
			movimiento.setDni_movimiento(rs.getString("DNI_m"));
			movimiento.setNro_cuenta_movimiento(rs.getInt("num_cuenta_m"));
			movimiento.setId_movimiento(rs.getInt("id_m"));
			movimiento.setFecha_movimiento(rs.getDate("fecha_m").toLocalDate());
			movimiento.setDetalle(rs.getString("detalle"));
			movimiento.setImporte(rs.getFloat("importe"));
			movimiento.setTipo_movimiento(rs.getString("tipo_movimiento"));
			lista_movixcuenta.add(movimiento);
		}

		}catch (Exception e) {

		        e.printStackTrace();
		        
		}
	return lista_movixcuenta;	
	}

	public boolean registrarMovimientoSP(Movimientos move, String dniDepo, String nCuentaDepo) {
		
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			
		 
		 PreparedStatement statement;
			Connection conexion = Conexion.getConexion().getSQLConexion();
			boolean movimientoRegistrado = false;
			try 
			{
				statement = conexion.prepareCall("Call TransferenciaMovimiento (?,?,?,?,?,?,?,?)");
				statement.setString(1, move.getDni_movimiento());
				statement.setInt(2, move.getNro_cuenta_movimiento());
				statement.setString(3, dniDepo);
				statement.setString(4, nCuentaDepo);
				statement.setString(5, move.getFecha_movimiento().toString());
				statement.setString(6, move.getDetalle());
				statement.setFloat(7, move.getImporte());
				statement.setString(8, move.getTipo_movimiento());
				if(statement.executeUpdate() > 0)
				{
					conexion.commit();
					movimientoRegistrado = true;
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		 
		return movimientoRegistrado;
	}

}
