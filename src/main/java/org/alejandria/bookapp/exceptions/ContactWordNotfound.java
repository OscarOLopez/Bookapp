package org.alejandria.bookapp.exceptions;

public class ContactWordNotfound extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ContactWordNotfound(String word) {		
		super("La palabra: " + word + " no tiene coincidencias en la busqueda");
	}
	
}
