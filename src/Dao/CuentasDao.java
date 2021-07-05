package Dao;

import java.sql.SQLException;
import java.util.List;
import Entidad.Cuentas;

public interface CuentasDao {
	
	public List<Cuentas> ListarCuentas();
	public boolean insertar(Cuentas cuenta);
	public boolean borrarCuenta (int nro_cuenta);
	public int buscar_una_cuenta(int nro_cuenta) throws SQLException;


}
