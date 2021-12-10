package DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Dao.CuentasDao;
import Entidad.Cuentas;
import Entidad.Cliente;
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
			
			//System.out.println("USUARIO: " + cuenta.getDni_cuenta());
			//System.out.println("N CUENTA: " + cuenta.getNumero_cuenta());
			//System.out.println("CBU: " + cuenta.getCbu());
			//System.out.println("FECHA: " + cuenta.getCreacion());
			//System.out.println("TIPO CUENTA: " + cuenta.getTipo_cuenta());
			//System.out.println("SALDO: " + cuenta.getSaldo());
			//System.out.println("ESTADO: " + cuenta.getEstado_cuenta());
			
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
	
	public int contarCuentasAdmin(String dni) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		int cuentas=0, i=0;
		
		String sql="SELECT * FROM Cuentas WHERE DNI_c ='" + dni + "' AND estado=1 ";
		Conexion conexion = Conexion.getConexion();
		PreparedStatement statement;
		try {
			statement=conexion.getSQLConexion().prepareStatement(sql);
			ResultSet rs;
			rs=statement.executeQuery();
			while(rs.next()) {
				i++;
			}
			cuentas=i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		///System.out.println("DNI: " + dni + ", CANTIDAD DE CUENTAS: " + cuentas);
		return cuentas;
	}






	@Override
	public List<Cuentas> ListarCuentas() {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();

		}
		
	
		
		String sql = "SELECT cuentas.DNI_c, cuentas.num_cuenta, cuentas.CBU, cuentas.creacion, cuentas.tipo_cuenta, cuentas.saldo, cuentas.estado FROM cuentas inner join clientes on cuentas.DNI_c = clientes.DNI ";
		
		List<Cuentas> lc = new ArrayList<Cuentas>();
		
		try{
			
		Connection conexion = Conexion.getConexion().getSQLConexion();
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(sql); 
		
		while (rs.next())
		{
			Cuentas cuenta = new Cuentas() ;
			cuenta.setDni_cuenta(rs.getString("cuentas.DNI_c"));
			cuenta.setNumero_cuenta(rs.getInt("cuentas.num_cuenta"));
			cuenta.setCbu(rs.getString("cuentas.CBU"));
			cuenta.setCreacion(rs.getDate("cuentas.creacion").toLocalDate());
			cuenta.setTipo_cuenta(rs.getString("cuentas.tipo_cuenta"));
			cuenta.setSaldo(rs.getFloat("cuentas.saldo"));
			cuenta.setEstado_cuenta(rs.getBoolean("cuentas.estado"));
			lc.add(cuenta);
		}

		}catch (Exception e) {

		        e.printStackTrace();
		        
		}
	return lc;
		}






	@Override
	public List<Cuentas> Listar_cuenta_por_cliente(String dni) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();

		}
		
	
		
		String sql = "SELECT  DNI, num_cuenta, saldo FROM cuentas INNER JOIN clientes ON clientes.DNI = cuentas.DNI_c WHERE DNI = '"+dni+"'";
		
		List<Cuentas> lista_cuentaxcliente = new ArrayList<Cuentas>();
		
		try{
			
		Connection conexion = Conexion.getConexion().getSQLConexion();
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(sql); 
		
		while (rs.next())
		{
			//Cliente cliente = new Cliente();
			Cuentas cuenta = new Cuentas() ;
			cuenta.setDni_cuenta(rs.getString("DNI"));
			cuenta.setNumero_cuenta(rs.getInt("num_cuenta"));
			cuenta.setSaldo(rs.getFloat("saldo"));;
			
			lista_cuentaxcliente.add(cuenta);
		}

		}catch (Exception e) {

		        e.printStackTrace();
		        
		}
	return lista_cuentaxcliente;
	}






	@Override
	public String Dni_de_Cuenta(String CBU) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
       // System.out.println("CBU: " + CBU);
        String dni="";
        Connection conexion = Conexion.getConexion().getSQLConexion();
        Statement statement;
        try {
            statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM cuentas WHERE CBU='" + CBU+"'");
            if(rs.next()) {
                //System.out.println("RESULTADO: " + rs.getString("DNI_c"));
                dni=rs.getString("DNI_c");
            }
            //System.out.println("DNICLIENTE: " + dni);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dni;
    }






	public String Numero_de_Cuenta(String CBU) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
       // System.out.println("CBU: " + CBU);
        String ncuenta="";
        Connection conexion = Conexion.getConexion().getSQLConexion();
        Statement statement;
        try {
            statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM cuentas WHERE CBU='" + CBU+"'");
            if(rs.next()) {
               // System.out.println("RESULTADO: " + rs.getString("num_cuenta"));
                ncuenta=rs.getString("num_cuenta");
            }
            //System.out.println("Ncuenta: " + ncuenta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ncuenta;
    }






	@Override
	public boolean actualizarSaldoCuenta(String dni, int nroCuenta, float saldo) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();

		}
		PreparedStatement ps;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean updateExitoso = false;
		
		try {
			
			
			ps = conexion.prepareCall("Call actualizarSaldoCuenta (?,?,?)");
			ps.setString(1, dni);
			ps.setInt(2, nroCuenta);
			ps.setFloat(3, saldo);
			
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