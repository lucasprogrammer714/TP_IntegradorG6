package NegocioImpl;

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

}
