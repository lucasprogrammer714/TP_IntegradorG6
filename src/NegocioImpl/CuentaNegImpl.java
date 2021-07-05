package NegocioImpl;

import java.sql.SQLException;

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

}
