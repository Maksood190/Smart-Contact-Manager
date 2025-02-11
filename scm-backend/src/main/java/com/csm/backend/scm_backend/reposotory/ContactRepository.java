package com.csm.backend.scm_backend.reposotory;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.csm.backend.scm_backend.entity.Contact;
import com.csm.backend.scm_backend.entity.User;

// By using same annotation and we can customize REST APIs like given bellow 
//@RepositoryRestResource(exported=false)    // means prevent the operation like post ,put, get,getAll etc.
//@RepositoryRestResource(path="contacts", collectionResourceRel = "contacts")      // means we can change Path URL while using JSON(APIs)
public interface ContactRepository extends JpaRepository<Contact, String>{

	
//	costume find method 
//	i want to  find contact by using number 
	@RestResource(path="by-email")
//	@RestResource(exported=false)      // its used to prevent to finding by email  
	List<Contact> findByEmailContainingIgnoreCase(@Param("email") String email, Pageable pageable);
	
	@RestResource(path="by-phone", rel="by-phone")
	List<Contact> findByPhoneNumberContainingIgnoreCase(@Param("phone")  String phoneNumber, Pageable pageable);
	
	
//	If we want search the data by name then you can used this given below
	@RestResource(path="by-name")      // its used to make as a customization (path finding by name)
	List<Contact> findByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);
	
	
	
	
}
