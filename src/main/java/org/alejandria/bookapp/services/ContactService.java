package org.alejandria.bookapp.services;

import java.util.List;

import org.alejandria.bookapp.exceptions.ContactByEmailNotFound;
import org.alejandria.bookapp.exceptions.ContactNotFoundException;
import org.alejandria.bookapp.exceptions.ContactWordNotfound;
import org.alejandria.bookapp.model.ContactEntity;
import org.alejandria.bookapp.repository.ContactRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactService {
	private ContactRepository contactRepository;
	
	public ContactEntity createContact(ContactEntity contact) {
		return this.contactRepository.save(contact);
	}
	
	//Matodo para mostrar todos los mensajes recibidos
	public List<ContactEntity> findAll() {
		return this.contactRepository.findAll();
	}
	
	//Metodo para encontrar mensaje por Id
	public ContactEntity findById(Long id) {
		return this.contactRepository.findById(id)
				.orElseThrow(()->new ContactNotFoundException(id));
	}
	
	//Metodo para borrar mensaje por id
	public void deleteById(Long id) {
		if (this.contactRepository.existsById(id)) {
			this.contactRepository.deleteById(id);
		} else {
			throw new ContactNotFoundException(id);
		}
	}
	
	//Metodo para encontrar mensajes por email
	public List<ContactEntity> findByEmail(String email) {
		List<ContactEntity> listaEmail = this.contactRepository.findByEmail(email);
		if (listaEmail.isEmpty()) {
			throw new ContactByEmailNotFound(email);
		}
		return listaEmail;
	}
	
	//Metodo para borrar mensaje por email
	public void deleteByEmail(String email) {
		List<ContactEntity> emailContact = this.contactRepository.findByEmail(email);
		if (emailContact.isEmpty()) {			
			throw new ContactByEmailNotFound(email);
		} else {
			for(ContactEntity contact: emailContact) {
				this.contactRepository.delete(contact);
			}
		}
	}
	
	//Metodo para encontar palabra en la columna mensaje
	public List<ContactEntity> getMessageByWord(String word){
		List<ContactEntity> palabra = this.contactRepository.getMessageByWord(word);
		if (palabra.isEmpty()) {			
			throw new ContactWordNotfound(word);
		} 
		return palabra;
		
	}
	
	//Metodo para buscar palabra en columna isssue
	public List<ContactEntity> getIssueByWord(String word){
		List<ContactEntity> palabra = this.contactRepository.getIssueByWord(word);
		if (palabra.isEmpty()) {
			throw new ContactWordNotfound(word);
		} 
		return palabra;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
