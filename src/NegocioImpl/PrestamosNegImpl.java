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

	@Override
	public Prestamos datosPagoPrestamos(String dni, int nro_cuenta) {
		// TODO Auto-generated method stub
		return prestamoDao.datosPagoPrestamo(dni, nro_cuenta) ;
	}

	@Override
	public int cuentaPrestamo(String dni_p) {
		// TODO Auto-generated method stub
		return prestamoDao.cuentaPrestamo(dni_p);
	}

	@Override
	public boolean pagoCuotaPrestamo(String dni_c, int num_cuenta, float montoCuota) {
		// TODO Auto-generated method stub
		return prestamoDao.pagoCuotaPrestamo(dni_c, num_cuenta, montoCuota);
	}

}
