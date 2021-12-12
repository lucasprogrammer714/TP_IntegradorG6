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
	
	public boolean registrarMovimientoSP(Movimientos move, String dniDepo, String nCuentaDepo) {
		return movDao.registrarMovimientoSP(move, dniDepo, nCuentaDepo);
	}


	@Override
	public int contarPagoCuota(String dni, int cuota, int idPrestamo) {
		return movDao.contarPagoCuota(dni, cuota, idPrestamo);
	}


	@Override
	public float reporteIngresoFecha(String fechaInicio, String fechaFin) {

		return movDao.ingresosBancoFecha(fechaInicio, fechaFin);
		
	}


	@Override
	public float reporteIngresoAnual(int year) {
		// TODO Auto-generated method stub
		return  movDao.ingresosBancoAnual(year);
	}


	@Override
	public float reporte_egresoFecha(String fechaInicio, String fechaFin) {
		// TODO Auto-generated method stub
		return movDao.egresosBancoFecha(fechaInicio, fechaFin);
	}


	@Override
	public float reporte_egresoAnual(int year) {
		// TODO Auto-generated method stub
		return movDao.egresosBancoAnual(year);
	}


	@Override
	public ArrayList<Float> egresosMensual() {
		// TODO Auto-generated method stub
		return movDao.egresosMensual();
	}

	public float gananciaPrestamos(String fechaInicio, String fechaFin) {
		return movDao.gananciaPrestamos(fechaInicio, fechaFin);
	}

	public float ingresoPrestamoAnual(int year) {
		return movDao.ingresoPrestamoAnual(year);
	}
	

	/*@Override
	public Float[] ingresosMensual() {
		// TODO Auto-generated method stub
		return movDao.ingresosMensual();
	}*/

}
