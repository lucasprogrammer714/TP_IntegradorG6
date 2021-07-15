package NegocioImpl;

import java.util.ArrayList;

import Dao.MovimientosDao;
import DaoImpl.MovimientosDaoImpl;
import Entidad.Movimientos;
import Negocio.MovimientosNeg;

public class MovimientosNegImpl implements MovimientosNeg {

	private MovimientosDao movDao = new MovimientosDaoImpl();
	

	@Override
	public boolean registarMovimiento(Movimientos move) {
		// TODO Auto-generated method stub
		return movDao.registrarMovimiento(move);
	}


	@Override
	public ArrayList<Movimientos> Listar_movimientos_por_cuenta(String dni, int ncuenta) {
		return (ArrayList<Movimientos>) movDao.Listar_movimientos_por_cuenta(dni, ncuenta);
	}

}
