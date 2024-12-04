package org.alejandria.bookapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contact")
@Data
@NoArgsConstructor
public class ContactEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_id")
	private Long contactId;
	
	@Column(name = "issue", length = 50, nullable = false)
	private String issue;
	
	@Column(name = "message", length = 250, nullable = false )
	private String message;
	
	@Column(name = "phone", length = 20)
	private String phone;
	
	@Column(name = "name", length = 45, nullable = false)
	private String name;
	
	@Column(name = "email", length = 45)
	private String email;
	
}
