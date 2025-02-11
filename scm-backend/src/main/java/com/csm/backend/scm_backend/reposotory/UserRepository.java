package com.csm.backend.scm_backend.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.csm.backend.scm_backend.entity.User;


//@RepositoryRestResource(exported=false)    // its used to prevent to create user APIs 
//@RepositoryRestResource(path="users")         // Here we can change URL path 
public interface UserRepository extends JpaRepository<User, String>{

	// By Default expose all method as a  APIs autometicaly
	
	
//	public → The interface is accessible from anywhere in the application.
//	interface → This defines an interface, which means it cannot contain method implementations
//	  (only method signatures).
	
	
//	extends JpaRepository<User, String> → This means that UserRepository inherits from JpaRepository.
//    JpaRepository is a Spring Data JPA interface that provides built-in CRUD (Create, Read, Update, Delete) operations for                                          an entity.


//By inheriting JpaRepository, the UserRepository automatically gets ready-to-use database operations:

//1.save(entity) → Inserts/Updates an entity.
//2.findById(id) → Retrieves an entity by ID.
//3.findAll() → Retrieves all records from the table.
//4.delete(entity) → Deletes a specific record.
//5.deleteById(id) → Deletes a record by ID.
//6.count() → Returns the number of records.
//✅ No need to write queries manually for these operations!


	
	
	
}
