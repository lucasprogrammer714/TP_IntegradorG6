package Negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import Entidad.Cuentas;

public interface CuentaNeg {
	
	public ArrayList<Cuentas> ListarCuentas();
	public boolean insert(Cuentas cuenta);
	public boolean borrarCuenta (int nro_cuenta);
	public int buscar_una_cuenta(int nro_cuenta) throws SQLException;;

}
