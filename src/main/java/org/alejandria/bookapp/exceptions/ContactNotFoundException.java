package org.alejandria.bookapp.exceptions;

public class ContactNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public ContactNotFoundException(Long id) {
		super("Los datos de mensaje con ID:" + id + " no existen.");
	}
	
}
