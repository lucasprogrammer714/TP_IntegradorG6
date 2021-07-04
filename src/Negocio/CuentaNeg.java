package Negocio;

import java.sql.SQLException;

import Entidad.Cuentas;

public interface CuentaNeg {
	
	
	public boolean insert(Cuentas cuenta);
	public boolean borrarCuenta (int nro_cuenta);
	public int buscar_una_cuenta(int nro_cuenta) throws SQLException;;

}
