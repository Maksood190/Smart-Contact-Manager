package com.csm.backend.scm_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.csm.backend.scm_backend.entity.Contact;
import com.csm.backend.scm_backend.exception.ContactNotFoundException;
import com.csm.backend.scm_backend.reposotory.ContactRepository;

@Service
public class ContactServiceImpl  implements ContactService{

	@Autowired
	ContactRepository contactRepo;
	
	@Override
	public Contact createContact(Contact contact) {
		
		return contactRepo.save(contact);
	}

	@Override
	public Contact updateContact(Contact contact, String id) {
		Optional<Contact> exsist = contactRepo.findById(id);
		if(exsist.isPresent()) {
			Contact contact2 = exsist.get();
			contact2.setAddress(contact.getAddress());
			contact2.setDescription(contact.getEmail());
			contact2.setCloudinaryImagePublicId(contact.getCloudinaryImagePublicId());
			contact2.setDescription(contact.getDescription());
			contact2.setFavorite(contact.isFavorite());
			contact2.setInstagramLink(contact.getInstagramLink());
			contact2.setLinkedInLink(contact.getLinkedInLink());
			contact2.setName(contact.getName());
			contact2.setPhoneNumber(contact.getPhoneNumber());
			contact2.setPicture(contact.getPicture());
			contact2.setWebsiteLink(contact.getWebsiteLink());	
		    return	contactRepo.save(contact);
		}
		else {
			throw new ContactNotFoundException("Contact cant be found with id:"+id);
		}
		
		
	}

	@Override
	public Contact getContactById(String id) {
	
	return contactRepo.findById(id)
				.orElseThrow(()-> new ContactNotFoundException("Contact id not found with id:"+id));
	
	}

	@Override
	public String deleteContact(String id) {
		
		if (!contactRepo.existsById(id)){
			 throw new ContactNotFoundException("Contact not found with id: " + id);
	}
		 return "Contact deleted succefully with id:"+id;
		 }


	@Override
	public Page<Contact> getAllContact(Pageable pageable) {
		
		return contactRepo.findAll(pageable);
	}

}
