package org.alejandria.bookapp.repository;

import java.util.List;

import org.alejandria.bookapp.model.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<ContactEntity, Long>{
	 
	//Busqueda por email
	@Query("SELECT c FROM ContactEntity c WHERE c.email = ?1")
	List<ContactEntity> findByEmail(String email);
	
	//Busqueda por palabra en columna message
	@Query("SELECT c FROM ContactEntity c WHERE c.message LIKE %:word%")
	List<ContactEntity> getMessageByWord(String word);
	
	//Busqueda por palabra en columna issue
	@Query("SELECT c FROM ContactEntity c WHERE c.issue LIKE %:word%")
	List<ContactEntity> getIssueByWord(String word);
	
}
