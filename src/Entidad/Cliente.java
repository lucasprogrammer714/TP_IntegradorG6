package Entidad;

public class Cliente {
	
	private	String dni;
	private String cuil;
	private	String nombre;
	private	String apellido;
	private	String sexo;
	private String nacionalidad;
	private	String nacimiento;
	private	String direccion;
	private	String localidad;
	private String provincia;
	private	String email;
	private String telefono;
	private String usuario;
	private String contraseña;
	private boolean administrador;
	private	boolean estado;


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


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNacimiento() {
		return nacimiento;
	}


	public void setNacimiento(String nacimiento) {
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
	
	
	public String getContraseña() {
		return contraseña;
	}
	
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
}
