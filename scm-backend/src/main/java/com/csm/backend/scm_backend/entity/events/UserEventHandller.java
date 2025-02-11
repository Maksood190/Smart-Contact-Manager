/**

package com.csm.backend.scm_backend.entity.events;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;

import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.csm.backend.scm_backend.entity.User;

@Component                            // its used to create a beans
@RepositoryEventHandler(User.class)
public class UserEventHandller {

	private Logger log=LoggerFactory.getLogger(UserEventHandller.class);
	
	
	
	@HandleBeforeCreate
	public void handleBeforeCreate(User user) {
		
		log.info("going to create user ");
		user.setId(UUID.randomUUID().toString());
	}
	
}                
                   */
