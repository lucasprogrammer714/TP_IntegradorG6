package Dao;

import java.util.List;

import Entidad.Movimientos;

public interface MovimientosDao {
	public List<Movimientos> Listar_movimientos_por_cuenta(String dni, int ncuenta);
}
