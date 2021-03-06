package DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Dao.MovimientosDao;
import Entidad.Movimientos;
import sun.util.calendar.CalendarDate;

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

	@Override
	public int contarPagoCuota(String dni, int cuota, int idPrestamo) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		String sql= "SELECT COUNT(detalle) FROM movimientos WHERE detalle LIKE 'Pago de cuota "+ cuota+" de prestamo "+idPrestamo+"%' AND DNI_m = "+dni+"";
		System.out.println(sql);
		int n= 0;
	     Connection conexion = Conexion.getConexion().getSQLConexion();
	     try {
	    	 Statement stm = conexion.createStatement();
		     // almaceno resultado de consulta en ResultSet
		     ResultSet rs  = stm.executeQuery(sql);
		     while(rs.next()) {
		       //Si hay resultados obtengo el valor. 
		        n= rs.getInt(1);
		        //System.out.println("CONTAR PAGO CUOTA ENTCONTRADO");
		     }
	     }
	     catch(SQLException e) {
	    	 e.printStackTrace();
	     }
	     return n;
	
	   }

	@Override
	public float ingresosBancoFecha(String fechaInicio, String fechaFin) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
 String query = "SELECT convert(sum(importe), decimal(12,2))  as reporte FROM movimientos  where fecha_m >='"+fechaInicio+"' and fecha_m <= '"+fechaFin+"' and detalle like '%Pago de cuota%' ";
		float reporte = 0;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try {
			
			Statement stm = conexion.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next())
			{
				reporte = rs.getFloat("reporte");
				System.out.println(reporte);
			}
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return reporte;
	   }

	@Override
	public float ingresosBancoAnual(int year) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		String query = "SELECT convert(sum(importe), decimal(12,2)) as reporte, YEAR(fecha_m) as anio FROM Movimientos WHERE YEAR(fecha_m) = '" + year + "'and detalle like '%Pago de cuota%'";
		float reporte = 0;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		
		try {
			
			Statement stm = conexion.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next())
			{
				reporte = rs.getFloat("reporte");
				System.out.println(reporte);
			}
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return reporte;
	   }
               
	
	
	public float ingresosBancoMensual(int year, int month) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		String query = "SELECT convert(sum(importe), decimal(12,2)) as reporte, YEAR(fecha_m) as anio FROM Movimientos WHERE YEAR(fecha_m) = '" + year + "'and MONTH(fecha_m) ='"+month+"' and detalle like '%Pago de cuota%'";
		float reporte = 0;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		
		try {
			
			Statement stm = conexion.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next())
			{
				reporte = rs.getFloat("reporte");
				System.out.println(reporte);
			}
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return reporte;
	   }
	

	
	@Override
	public float egresosBancoFecha(String fechaInicio, String fechaFin) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
 String query = "SELECT convert(sum(importe), decimal(12,2))  as reporte FROM movimientos  where fecha_m >='"+fechaInicio+"' and fecha_m <= '"+fechaFin+"' and tipo_movimiento = 'Deposito' ";
		float reporte = 0;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try {
			
			Statement stm = conexion.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next())
			{
				reporte = rs.getFloat("reporte");
				System.out.println(reporte);
			}
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return reporte;
	   }
	

	@Override
	public float egresosBancoAnual(int year) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		String query = "SELECT convert(sum(importe), decimal(12,2)) as reporte, YEAR(fecha_m) as anio FROM Movimientos WHERE YEAR(fecha_m) = '" + year + "'and tipo_movimiento = 'Deposito'";
		float reporte = 0;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		
		try {
			
			Statement stm = conexion.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next())
			{
				reporte = rs.getFloat("reporte");
				System.out.println(reporte);
			}
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return reporte;
	   }
               
	


/*	public ArrayList<Float>  egresosMensual()
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		
		
	   String query = "SELECT importe as reporte, MONTH(fecha_m) as mes FROM Movimientos WHERE YEAR(fecha_m) ='2021' and tipo_movimiento = 'Deposito'";
		float reporte = 0;

	   int month = 0;
	   ArrayList<Float> reporteMeses = new ArrayList();
		float reporteMes = 0; 
		
		for(int i=0;i<12;i++) {
			reporteMeses.add(reporteMes);

	}

		
		
	Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try {

			Statement stm = conexion.createStatement();
			ResultSet rs = stm.executeQuery(query);
		
			while(rs.next())
			{
				reporte = rs.getFloat("reporte");
			    month = rs.getInt("mes");
	
		    if(month==11) {
			reporteMes += reporte;
		   // reporteMeses.add(i, reporteMes);
		    System.out.println(reporteMes);
		}
		
		
			    
			  for(int i =0; i<12;i++) {
			    	 if(month==i+1) {
			    		    reporteMes += reporte;
						    reporteMeses.add(i, reporteMes);
						    System.out.println(reporteMes);
					}
			    }
			   
		 } 
			
			
			}
			for(int i=0;i<12;i++) {
				System.out.println("AAA: "  + reporteMeses.get(i));

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		
	return reporteMeses;
		
	}*/
	
	
public float gananciaPrestamos(String fechaInicio, String fechaFin) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		float reporte = 0;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try {
			String query = "SELECT SUM(imp_debe_pagar) - SUM(imp_pedido) as gananciaPrestamo FROM  prestamos WHERE fecha_p >='"+fechaInicio+"' and fecha_p <= '"+fechaFin+"' and Autorizado=1";
			Statement stm = conexion.createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next())
			{
				reporte = rs.getFloat("gananciaPrestamo");
				System.out.println(reporte);
			}
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return reporte;
	}


public float ingresoPrestamoAnual(int year) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	
	String query = "SELECT SUM(imp_debe_pagar) - SUM(imp_pedido) as gananciaPrestamoAnual FROM prestamos WHERE YEAR(fecha_p) ='" + year + "'AND Autorizado=1";
	float reporte = 0;
	Connection conexion = Conexion.getConexion().getSQLConexion();
	
	
	try {
		
		Statement stm = conexion.createStatement();
		ResultSet rs = stm.executeQuery(query);
		
		while(rs.next())
		{
			reporte = rs.getFloat("gananciaPrestamoAnual");
			System.out.println(reporte);
		}
		
	} catch(Exception e)
	{
		e.printStackTrace();
	}
	return reporte;
   }

@Override
public float egresosBancoMensual(int year, int month) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	
	String query = "SELECT  convert(sum(importe), decimal(12,2)) as reporte FROM Movimientos WHERE YEAR(fecha_m) ='"+year+"' and tipo_movimiento = 'Deposito' and MONTH(fecha_m) ='"+month+"'"; 
			
	float reporte = 0;
	Connection conexion = Conexion.getConexion().getSQLConexion();
	
	
	try {
		
		Statement stm = conexion.createStatement();
		ResultSet rs = stm.executeQuery(query);
		
		while(rs.next())
		{
			reporte = rs.getFloat("reporte");
			System.out.println(reporte);
		}
		
	} catch(Exception e)
	{
		e.printStackTrace();
	}
	return reporte;
}


}
