package Dao;

import java.util.List;

import Entidad.Movimientos;

public interface MovimientosDao {
	
	
	public boolean registrarMovimiento(Movimientos move);
	public List<Movimientos> Listar_movimientos_por_cuenta(String dni, int ncuenta);
	public boolean registrarMovimientoSP(Movimientos move, String dniDepo, String nCuentaDepo);
	

}
