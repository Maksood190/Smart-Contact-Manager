package com.csm.backend.scm_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.csm.backend.scm_backend.entity.User;
import com.csm.backend.scm_backend.exception.UserNotFoundException;
import com.csm.backend.scm_backend.reposotory.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public User createUser(User user) {
		
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user, String id) {
		Optional<User> exsist = userRepo.findById(id);
		if(exsist.isPresent()) {
		User users=exsist.get();
	    	users.setAbout(user.getAbout());
			users.setEamilVerified(user.isEamilVerified());
			users.setEmail(user.getEmail());
			users.setEmailToken(user.getEmailToken());
			users.setEnabled(user.isEnabled());
			users.setName(user.getName());
			users.setPassword(user.getPassword());
			users.setPhoneNumber(user.getPhoneNumber());
			users.setPhoneVerified(user.isPhoneVerified());
			users.setProfilePicture(user.getProfilePicture());
			users.setProvider(user.getProvider());
			users.setProviderUserId(user.getProviderUserId());
			return userRepo.save(user);
		}else {
			
			throw new UserNotFoundException("User is not found with id:"+id); 
		}
		
	}

	@Override
	public User getUserById(String id) {
	return 	userRepo.findById(id)
			.orElseThrow(()-> new UserNotFoundException("User not found with id:"+id));
		
	}

	@Override
	public String deleteUser(String id) {
		if(!userRepo.existsById(id)){
			 throw new UserNotFoundException("User not found with id: " + id);
	}
		return "User succefully deleted with id: "+id;
		}

	@Override
	public Page<User> getAllUser(Pageable pageable) {
		
		return userRepo.findAll(pageable);
	}

	

}
