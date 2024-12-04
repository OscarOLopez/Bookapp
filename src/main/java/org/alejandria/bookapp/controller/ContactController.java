package org.alejandria.bookapp.controller;

import java.util.List;

import org.alejandria.bookapp.model.ContactEntity;
import org.alejandria.bookapp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {
	private final ContactService contactService;
	
	@Autowired
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	@GetMapping("/find/all")
	public List<ContactEntity> findAll(){
		return this.contactService.findAll();
	}
	
	@GetMapping("/find/id/{id}")
	public ContactEntity findById(@PathVariable(name = "id") Long id) {
		return this.contactService.findById(id);
	}
	
	@GetMapping("/find/email/{email}")
	public List<ContactEntity> findByEmail(@PathVariable(name = "email") String email){
		return this.contactService.findByEmail(email);
	}
	
	@DeleteMapping("/delete-contact/{id}")
	public void deleteById(@PathVariable(name = "id") Long id) {
		this.contactService.deleteById(id);
	}
	
	@DeleteMapping("/delete-contact/{email}")
	public void deleteByEmail(@PathVariable(name = "email") String email) {
		this.contactService.deleteByEmail(email);
	}
	
	@GetMapping("/find-word-message/{word}")
	public List<ContactEntity> getMessaageByWord(@PathVariable(name = "word") String word){
		return this.contactService.getMessageByWord(word);
	}
	
	@GetMapping("/find-word-issue/{word}")
	public List<ContactEntity> getIssueByWord(@PathVariable(name = "word") String word){
		return this.contactService.getIssueByWord(word);
	}
	
	
	
	
	
	
	
	
	
	
}
