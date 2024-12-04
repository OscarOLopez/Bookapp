package org.alejandria.bookapp.exceptions;

public class ContactByEmailNotFound extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ContactByEmailNotFound(String email) {
		super("No hay mensajes provenientes de "+email+".");
	}	

}
