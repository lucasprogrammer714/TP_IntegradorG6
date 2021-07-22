package Excepciones;

public class FaltaArrobaException extends Exception {

	
	public FaltaArrobaException()
	{
		
	}

	@Override
	public String getMessage() {

            
		return   "Ingrese una direccion de correo valida";

	}
	
	public boolean validarMail(String mail) throws FaltaArrobaException, FaltaPuntoException
	{
		boolean arroba = false;
		boolean punto = false;
		
		
		
		for (int i = 0; i< mail.length(); i ++)
		{
			if (mail.charAt(i) == '@')
				arroba = true;
			if (mail.charAt(i) == '.')
				punto = true;
		}
		
		
		if (arroba == false)
		{
			
			
			FaltaArrobaException excArroba = new FaltaArrobaException();
			 throw excArroba;
			
		}
		
		
		if (punto == false)
		{
			FaltaPuntoException excPunto = new FaltaPuntoException();
            throw excPunto;
		}
		
		
		if (arroba == true && punto == true)
		{
			return  true ;
		}
		
		return false;
	}
		
	
	
	
	
}
