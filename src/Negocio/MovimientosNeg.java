package Negocio;

import Entidad.Movimientos;
import java.util.ArrayList;
public interface MovimientosNeg {
	public ArrayList<Movimientos> Listar_movimientos_por_cuenta(String dni, int ncuenta);
}
