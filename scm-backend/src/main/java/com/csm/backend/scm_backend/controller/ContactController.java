package com.csm.backend.scm_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.csm.backend.scm_backend.entity.Contact;
import com.csm.backend.scm_backend.service.ContactService;

     @RestController
     @RequestMapping("contacts")
     public class ContactController {

	@Autowired
	ContactService contactService;
	
	
	
      @PostMapping
      ResponseEntity<Contact>	createContact(@RequestBody Contact contact){
		
		Contact contact2 = contactService.createContact(contact);
		return  new ResponseEntity<>(contact2,HttpStatus.OK);
		
	    }
      
	
     @PutMapping("/{id}")
     ResponseEntity<Contact>updateContact(@RequestBody Contact contact, @PathVariable String id){
		
	 Contact updateContact = contactService.updateContact(contact, id);
	 return  new ResponseEntity<>(updateContact,HttpStatus.OK);
	}
	
    @GetMapping("/{id}")
    ResponseEntity<Contact> getContactById(@PathVariable String id){	
    Contact contactById = contactService.getContactById(id);
    	
    return  new ResponseEntity<>(contactById,HttpStatus.OK);
    	
    }
   
     @DeleteMapping("/{id}")
     ResponseEntity<String>delete(@PathVariable String id){
    	 String deleteContact = contactService.deleteContact(id); 
    	 return new ResponseEntity<>(deleteContact,HttpStatus.OK);
     } 
    
     @GetMapping()
     ResponseEntity<Page<Contact>> getAll(
    		 @RequestParam(defaultValue = "0") int page,
    		 @RequestParam(defaultValue = "15") int size
    		 ){
    	 
    	 return ResponseEntity.ok(contactService.getAllContact(PageRequest.of(page, size)));
     }
     
}
