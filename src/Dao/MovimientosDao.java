package Dao;

import java.util.ArrayList;
import java.util.List;

import Entidad.Movimientos;

public interface MovimientosDao {
	
	
	public boolean registrarMovimiento(Movimientos move);
	public List<Movimientos> Listar_movimientos_por_cuenta(String dni, int ncuenta);
	public boolean registrarMovimientoSP(Movimientos move, String dniDepo, String nCuentaDepo);
    public int contarPagoCuota(String dni, int cuota, int idPrestamo);
    public float  ingresosBancoFecha (String fechaInicio, String fechaFin);
    public float ingresosBancoAnual(int year);
    public float ingresosBancoMensual(int year, int month);
    public float  egresosBancoFecha (String fechaInicio, String fechaFin);
    public float  egresosBancoAnual(int year);
    public float egresosBancoMensual(int year, int month);
    //public ArrayList<Float> egresosMensual(); 

	
    public float gananciaPrestamos(String fechaInicio, String fechaFin);
    public float ingresoPrestamoAnual(int year);
}
