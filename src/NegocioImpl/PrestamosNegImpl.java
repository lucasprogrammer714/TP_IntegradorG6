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
	
	public List<Prestamos> ListarTodosPrestamos(){
		return prestamoDao.ListarTodosPrestamos();
	}

	@Override
	public boolean autorizarPrestamo(int idPrestamo) {
		// TODO Auto-generated method stub
		return prestamoDao.autorizarPrestamo(idPrestamo);
	}

	public boolean rechazarPrestamo(int idPrestamo) {
		// TODO Auto-generated method stub
		return prestamoDao.rechazarPrestamo(idPrestamo);
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

	@Override
	public int contarPrestamo(String dni) {
		return prestamoDao.contarPrestamo(dni);
	}

	public boolean prestamoSaldado(String dni_p, int nroCuenta_p, int id_p) {
		return prestamoDao.prestamoSaldado(dni_p, nroCuenta_p, id_p);
	}
	
}
