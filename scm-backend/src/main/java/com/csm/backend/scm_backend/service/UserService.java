package com.csm.backend.scm_backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.csm.backend.scm_backend.entity.User;

public interface UserService {

public User	createUser(User user);

public User updateUser(User user, String id);
  
public User getUserById(String id);
  
public String  deleteUser(String id);
  
	
public Page<User> getAllUser(Pageable pageable);
}
