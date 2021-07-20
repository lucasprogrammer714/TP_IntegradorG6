package Negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.Cuentas;

public interface CuentaNeg {
	
	
	public boolean insert(Cuentas cuenta);
	public boolean borrarCuenta (int nro_cuenta);
	public int buscar_una_cuenta(int nro_cuenta) throws SQLException;;
	public int contarCuentasAdmin(String dni);
    public ArrayList<Cuentas> ListarCuentas();
    public ArrayList<Cuentas> ListarCuentaxCliente(String dni);
    public String Dni_de_Cuenta(String CBU);
    public String Numero_de_Cuenta(String CBU);
}
