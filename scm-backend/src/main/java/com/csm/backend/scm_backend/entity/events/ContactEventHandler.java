/**
package com.csm.backend.scm_backend.entity.events;

import java.util.UUID;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Controller;

import com.csm.backend.scm_backend.entity.Contact;

@Controller
@RepositoryEventHandler(Contact.class)
public class ContactEventHandler {
	
	@HandleBeforeCreate
	public void beforeSave(Contact contact) {
		
		contact.setId(UUID.randomUUID().toString());
	}

}


*/