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
	
	private static final String insert = "INSERT INTO Prestamos(DNI_p, num_cuenta_p, fecha_p, imp_debe_pagar, imp_pedido, plazo, monto_mensual, cuotas, pendiente, autorizado, saldado) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

	@Override
	public boolean insertar(Prestamos prestamos) {
		

			
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
				}catch(ClassNotFoundException e){
					e.printStackTrace();
				}
				System.out.println(insert);
				PreparedStatement statement;
				Connection conexion = Conexion.getConexion().getSQLConexion();
				boolean isInsertExitoso = false;
				try{
					
					statement = conexion.prepareStatement(insert);
					
					/*
					System.out.println("DNI: "+prestamos.getDni_prestamo());
					System.out.println("NRO CUENTA: "+prestamos.getNro_cuenta_p());
					System.out.println("FECHA: "+prestamos.getFecha_p().toString());
					System.out.println("DEBE PAGAR: "+prestamos.getImp_debe_pagar());
					System.out.println("IMPORTE PEDIDO: "+prestamos.getImporte_pedido());
					System.out.println("PLAZO: "+prestamos.getPlazo().toString());
					System.out.println("MONTOMENSUAL: "+prestamos.getMonto_mensual());
					System.out.println("CUOTAS: "+prestamos.getCuotas());
					System.out.println("PENDIENTE: "+prestamos.isPendiente());
					System.out.println("AUTORIZADO: "+prestamos.isAutorizado());
					System.out.println("SALDADO: "+prestamos.getSaldado());
					*/
					
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
					statement.setBoolean(11, prestamos.getSaldado());
					
					if(statement.executeUpdate() > 0){
						conexion.commit();
						isInsertExitoso = true;
						System.out.println("EXITO ALTA PRESTAMO: " + isInsertExitoso);
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
		
		
		String sql = "SELECT DNI_p, num_cuenta_p, id_p, imp_debe_pagar, imp_pedido, Pendiente FROM prestamos";
		List<Prestamos> listap = new ArrayList<Prestamos>();
		
		try{
				
			Connection conexion = Conexion.getConexion().getSQLConexion();	
			Statement st = conexion.createStatement();
	        ResultSet rs = st.executeQuery(sql);
	        
	        while (rs.next())
	        {
	        	if(rs.getBoolean("Pendiente")==true) {
	        		Prestamos presta = new Prestamos();
		        	presta.setDni_prestamo(rs.getString("DNI_p"));
		        	presta.setNro_cuenta_p(rs.getInt("num_cuenta_p"));
		        	presta.setId_prestamo(rs.getInt("id_p"));
		        	presta.setImp_debe_pagar(rs.getFloat("imp_debe_pagar"));
		        	presta.setImporte_pedido(rs.getFloat("imp_pedido"));
		        	listap.add(presta);
	        	}
	        }				
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	return listap;
	}
	
	
	@Override
	public List<Prestamos> ListarTodosPrestamos() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();

		}
		
		
		String sql = "SELECT DNI_p, num_cuenta_p, id_p, imp_debe_pagar, imp_pedido, pendiente, autorizado, saldado FROM prestamos";
		List<Prestamos> listap = new ArrayList<Prestamos>();
		
		try{
				
			Connection conexion = Conexion.getConexion().getSQLConexion();	
			Statement st = conexion.createStatement();
	        ResultSet rs = st.executeQuery(sql);
	        
	        while (rs.next())
	        {
	        	System.out.println("CARGA TODOS LOS PRESTAMOS");
	        	Prestamos presta = new Prestamos();
		        presta.setDni_prestamo(rs.getString("DNI_p"));
		        presta.setNro_cuenta_p(rs.getInt("num_cuenta_p"));
		        presta.setId_prestamo(rs.getInt("id_p"));
		        presta.setImp_debe_pagar(rs.getFloat("imp_debe_pagar"));
		        presta.setImporte_pedido(rs.getFloat("imp_pedido"));
		        presta.setPendiente(rs.getBoolean("Pendiente"));
		        presta.setAutorizado(rs.getBoolean("Autorizado"));
		        presta.setSaldado(rs.getBoolean("saldado"));
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
	public boolean autorizarPrestamo(int idPrestamo) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();

		}
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean updateExitoso = false;
		
		try {
			
			
			ps = conexion.prepareCall("Call autorizarPrestamo (?)");
			ps.setInt(1, idPrestamo);
			
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
	
	public boolean rechazarPrestamo(int idPrestamo) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();

		}
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean updateExitoso = false;
		
		try {
			
			
			ps = conexion.prepareCall("Call rechazarPrestamo (?)");
			ps.setInt(1, idPrestamo);
			
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

	@Override
	public Prestamos datosPagoPrestamo(String dni, int nrocuent) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();

		}
		
		
		String sql = "SELECT id_p, cuotas, monto_mensual, autorizado, pendiente, saldado FROM prestamos WHERE DNI_p ='" +dni+"' AND num_cuenta_p = '"+nrocuent+"'";
	    Prestamos datosPrestamos = new Prestamos();
		
		try{
				
			Connection conexion = Conexion.getConexion().getSQLConexion();	
			Statement st = conexion.createStatement();
	        ResultSet rs = st.executeQuery(sql);
	        
	        while (rs.next())
	        {
	           if(rs.getBoolean("saldado")==false) {
	           datosPrestamos.setCuotas(rs.getInt("cuotas"));
	           datosPrestamos.setMonto_mensual(rs.getFloat("monto_mensual"));
	           datosPrestamos.setAutorizado(rs.getBoolean("autorizado"));
	           datosPrestamos.setPendiente(rs.getBoolean("pendiente"));
	           datosPrestamos.setId_prestamo(rs.getInt("id_p"));
	           datosPrestamos.setSaldado(rs.getBoolean("saldado"));
	           }
	        }
				
			
	}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	return datosPrestamos;
	}

	@Override
	public int cuentaPrestamo(String dni_p) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();

		}
		
		String query = "SELECT num_cuenta_p FROM prestamos WHERE DNI_p ='" +dni_p+"'";
		int num_cuenta = 0;
		
		try{
			
			Connection conexion = Conexion.getConexion().getSQLConexion();	
			Statement st = conexion.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        
	        if (rs.next())
	        {
	           num_cuenta = rs.getInt("num_cuenta_p");
	        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		return num_cuenta;
	}

	@Override
	public boolean pagoCuotaPrestamo(String dni_c, int nroCuenta, float montoCuota) {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();

		}
		
		PreparedStatement st;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean updateExitoso = false;
		String query = "UPDATE cuentas SET saldo = saldo - '"+montoCuota+"' where Dni_c = '"+dni_c+"' and num_cuenta = '"+nroCuenta+"'";
		
		try 
		{
			st = conexion.prepareStatement(query);
			//st.setString(1, Integer.toString(dni));
			if(st.executeUpdate() > 0)
			{
				conexion.commit();
				updateExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	   
		
		return updateExitoso;
	} 
	
	public int contarPrestamo(String dni) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();

		}
		
		//PENDIENTE = 1
		// NO SALDADO = 2
		int contPrest=0;
		  
		String sql = "SELECT id_p, cuotas, monto_mensual, autorizado, pendiente, saldado FROM prestamos WHERE DNI_p ='" +dni+"'";
		
		try{
				
			Connection conexion = Conexion.getConexion().getSQLConexion();	
			Statement st = conexion.createStatement();
	        ResultSet rs = st.executeQuery(sql);
	      
	        while (rs.next())
	        {
	           if(rs.getBoolean("Pendiente")==true && rs.getBoolean("Autorizado")==false && rs.getBoolean("saldado")==false) {
	        	   contPrest=1;
	           }
	           
	           if(rs.getBoolean("Pendiente")==false && rs.getBoolean("Autorizado")==true && rs.getBoolean("saldado")==false) {
		           contPrest=2;
		       }
	        }
	   }	
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	return contPrest;
	}
	
	
	public boolean prestamoSaldado(String dni_p, int nroCuenta_p, int id_p) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();

		}
		
		PreparedStatement st;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean updateExitoso = false;
		String query = "UPDATE prestamos SET saldado = true where DNI_p = '"+dni_p+"' and num_cuenta_p = '"+nroCuenta_p+"' and id_p ='" + id_p+"'";
		System.out.println(query);
		try 
		{
			st = conexion.prepareStatement(query);
			//st.setString(1, Integer.toString(dni));
			if(st.executeUpdate() > 0)
			{
				conexion.commit();
				updateExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	   
		
		return updateExitoso;
	} 
	
	

	

}
