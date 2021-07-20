package Excepciones;

public class FaltaPuntoException extends Exception {
	
	
	public FaltaPuntoException()
	{
		
	}

	@Override
	public String getMessage() {
    

           return "Ingrese una direccion de correo valida";
	}
	
	

}
