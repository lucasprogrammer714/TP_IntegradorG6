package NegocioImpl;

import java.util.ArrayList;
import java.util.List;

import Dao.MovimientosDao;
import DaoImpl.MovimientosDaoImpl;
import Entidad.Cuentas;
import Entidad.Movimientos;
import Negocio.MovimientosNeg;
public class MovimientosNegImpl implements MovimientosNeg {
	private MovimientosDao movDao = new MovimientosDaoImpl();
	public ArrayList<Movimientos> Listar_movimientos_por_cuenta(String dni, int ncuenta){
		return (ArrayList<Movimientos>) movDao.Listar_movimientos_por_cuenta(dni, ncuenta);
	}
}
