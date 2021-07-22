package NegocioImpl;

import java.util.List;

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

	@Override
	public List<Prestamos> ListarPrestamos() {
	
		return prestamoDao.ListarPrestamos();
	}

	@Override
	public boolean autorizarPrestamos(String dni, int nrocuenta) {
		// TODO Auto-generated method stub
		return prestamoDao.autorizarPrestamo(dni, nrocuenta);
	}

}
