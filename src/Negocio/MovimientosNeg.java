package Negocio;

import java.util.ArrayList;

import Entidad.Movimientos;

public interface MovimientosNeg {
	
	
	public boolean registarMovimiento(Movimientos move);
	public ArrayList<Movimientos> Listar_movimientos_por_cuenta(String dni, int ncuenta);
	public boolean registrarMovimientoSP(Movimientos move, String dniDepo, String nCuentaDepo);
	public int contarPagoCuota(String dni, int cuota, int idPrestamo);
	public float reporteIngresoFecha(String fechaInicio, String fechaFin);
	public float reporteIngresoAnual(int year);
	public float reporteIngresoMensual(int year, int month);
	public float reporte_egresoFecha(String fechaInicio, String fechaFin);
	public float reporte_egresoAnual(int year);
    public float egresosBancoMensual(int year, int month);
  //  public ArrayList<Float> egresosMensual();

    public float gananciaPrestamos(String fechaInicio, String fechaFin);
    public float ingresoPrestamoAnual(int year);
}
