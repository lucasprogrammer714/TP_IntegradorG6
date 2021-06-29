package Entidad;

import java.time.LocalDate;
import java.util.Date;

public class Cliente {
	
	private	String dni;
	private String cuil;
	private	String nombre;
	private	String apellido;
	private	String sexo;
	private Date nacimiento;
	private String nacionalidad;
	private	String direccion;
	private	String localidad;
	private String provincia;
	private	String email;
	private String telefono;
    private String usuario;
	private String contrase�a;
	private boolean administrador;
	private	boolean estado;
	private String telefono_fijo;


	public Cliente()
	{
		
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getCuil() {
		return cuil;
	}


	public void setCuil(String cuil) {
		this.cuil = cuil;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public Date getNacimiento() {
		return nacimiento;
	}


	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}
	
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	public String getUsuario() {
		return usuario;
	}
	
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	public String getContrase�a() {
		return contrase�a;
	}
	
	
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	
	public boolean getAdministrador() {
		return administrador;
	}
	
	
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	
	
	public boolean getEstado() {
		return estado;
	}
	
	
	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public String getTelefono_fijo() {
		return telefono_fijo;
	}


	public void setTelefono_fijo(String telefono_fijo) {
		this.telefono_fijo = telefono_fijo;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
}
