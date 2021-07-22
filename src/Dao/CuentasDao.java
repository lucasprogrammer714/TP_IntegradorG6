package Dao;


import java.sql.SQLException;
import java.util.List;

import Entidad.Cuentas;

public interface CuentasDao {
	
	
	public boolean insertar(Cuentas cuenta);
	public boolean borrarCuenta (int nro_cuenta);
	public int buscar_una_cuenta(int nro_cuenta) throws SQLException;
	public int contarCuentasAdmin(String dni);
	public List<Cuentas> ListarCuentas();
	public List<Cuentas> Listar_cuenta_por_cliente(String dni);
	public String Dni_de_Cuenta(String CBU);
	public String Numero_de_Cuenta(String CBU);
	public boolean actualizarSaldoCuenta(String dni, int nroCuenta, float saldo);
}
