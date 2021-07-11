package DaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dao.MovimientosDao;
import Entidad.Movimientos;

public class MovimientosDaoImpl implements MovimientosDao {

	
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
	
}
