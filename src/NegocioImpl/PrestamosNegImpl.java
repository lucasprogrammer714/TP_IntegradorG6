package NegocioImpl;

import Dao.PrestamosDao;
import DaoImpl.PrestamosDaoImpl;
import Entidad.Prestamos;
import Negocio.PrestamosNeg;

public class PrestamosNegImpl implements PrestamosNeg{
	
	PrestamosDao prestamoDao = new PrestamosDaoImpl();

	@Override
	public boolean insertar(Prestamos prestamos) {
		return prestamoDao.insertar(prestamos);
	}

}
