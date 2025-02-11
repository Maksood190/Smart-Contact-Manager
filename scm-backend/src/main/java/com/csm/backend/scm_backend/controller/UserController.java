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

import com.csm.backend.scm_backend.entity.User;
import com.csm.backend.scm_backend.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	
	@PostMapping
	ResponseEntity<User> createUser(@RequestBody User user){
		User user2 = userService.createUser(user);
		
		  return new ResponseEntity<>(user2,HttpStatus.OK);
	   }  
		
	@PutMapping("/{id}")
	ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String id){
		  User updateUser = userService.updateUser (user,id);
		 return new ResponseEntity<>(updateUser,HttpStatus.OK);
	  }
	  
	 @GetMapping("/{id}")
	ResponseEntity<User> getById(@PathVariable String id){
		 User userById = userService.getUserById(id);
		 
		 return new ResponseEntity<>(userById,HttpStatus.OK);
	 }
	 
    @DeleteMapping("/{id}")
	ResponseEntity<String>  delete(@PathVariable String id){
		   String deleteUser = userService.deleteUser(id);
		   
		   return  new ResponseEntity<>(deleteUser,HttpStatus.OK);
	   }
	 
	 
	 @GetMapping
	ResponseEntity <Page<User>> getAll(
			
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "15") int size
			){	
		return  ResponseEntity.ok(userService.getAllUser(PageRequest.of(page,size)));
	 }
	
	  
}
