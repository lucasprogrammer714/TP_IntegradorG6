package Negocio;

import java.util.ArrayList;

import Entidad.Movimientos;

public interface MovimientosNeg {
	
	
	public boolean registarMovimiento(Movimientos move);
	public ArrayList<Movimientos> Listar_movimientos_por_cuenta(String dni, int ncuenta);

}
