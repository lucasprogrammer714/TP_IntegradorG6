package Excepciones;

public class FaltaArrobaException extends Exception {

	
	public FaltaArrobaException()
	{
		
	}

	@Override
	public String getMessage() {

            
		return   "Ingrese una direccion de correo valida";

	}
	
}
