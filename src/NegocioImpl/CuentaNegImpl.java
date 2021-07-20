package NegocioImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import Dao.CuentasDao;
import DaoImpl.CuentasDaoImpl;
import Entidad.Cuentas;
import Negocio.CuentaNeg;

public class CuentaNegImpl implements CuentaNeg {
	
	
	private CuentasDao cuentaDao = new CuentasDaoImpl();

	@Override
	public boolean insert(Cuentas cuenta) {
	
		return cuentaDao.insertar(cuenta);
	}

	@Override
	public boolean borrarCuenta(int nro_cuenta) {
		return cuentaDao.borrarCuenta(nro_cuenta);
	}

	@Override
	public int buscar_una_cuenta(int nro_cuenta) throws SQLException {
		return cuentaDao.buscar_una_cuenta(nro_cuenta);
	}
	
	public int contarCuentasAdmin(String dni) {
		return cuentaDao.contarCuentasAdmin(dni);
	}

	@Override
	public ArrayList<Cuentas> ListarCuentas() {
		return (ArrayList<Cuentas>) cuentaDao.ListarCuentas();
	}

	@Override
	public ArrayList<Cuentas> ListarCuentaxCliente(String dni) {
		// TODO Auto-generated method stub
		return (ArrayList<Cuentas>) cuentaDao.Listar_cuenta_por_cliente(dni);
	}
	
	public String Dni_de_Cuenta(String CBU) {
		return cuentaDao.Dni_de_Cuenta(CBU);
	}

	public String Numero_de_Cuenta(String CBU) {
		return cuentaDao.Numero_de_Cuenta(CBU);
	}

}
