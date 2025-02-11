package com.csm.backend.scm_backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.csm.backend.scm_backend.entity.Contact;

public interface ContactService {

 public 	Contact createContact(Contact contact);
	
 public	Contact updateContact(Contact contact, String id);
	
 public Contact	getContactById(String id);
	
 public String deleteContact(String id);
	
 public  Page<Contact>	getAllContact(Pageable pageable);
	
}
